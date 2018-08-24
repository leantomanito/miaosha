package com.yj.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    public <T> T get(String key, Class<T> clazz){
        Jedis jedis=null;
        try{
            jedis = jedisPool.getResource();
            String str = jedis.get(key);
            T t = jsonToBean(str,clazz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }

    public <T> boolean set(String key, T val){
        Jedis jedis=null;
        try{
            jedis = jedisPool.getResource();
            String valS = beanToString(val);
            jedis.set(key, valS);
            return true;
        }finally {
            returnToPool(jedis);
        }
    }

    private <T> String beanToString(T val) {
        if(val == null){
            return null;
        }
        Class clazz = val.getClass();
        if(clazz == int.class || clazz == Integer.class){
            return ""+val;
        }else if(clazz == String.class){
            return (String)val;
        }else if(clazz == long.class || clazz == Long.class){
            return ""+val;
        }else{
            return JSON.toJSONString(val);
        }
    }

    private <T> T jsonToBean(String str, Class clazz) {
        if(str == null || str.length() <=0 || clazz == null){
            return null;
        }
        if(clazz == int.class || clazz == Integer.class){
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class){
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class){
            return (T)Long.getLong(str);
        }else{
            return (T)JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    private void returnToPool(Jedis jedis) {
        if(jedis!=null){
            jedis.close();
        }
    }



}
