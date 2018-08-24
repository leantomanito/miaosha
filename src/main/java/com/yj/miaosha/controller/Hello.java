package com.yj.miaosha.controller;

import com.yj.miaosha.entry.User;
import com.yj.miaosha.redis.RedisService;
import com.yj.miaosha.result.Result;
import com.yj.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class Hello {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/test")
    @ResponseBody
    Result<String> showName(Model model){
        model.addAttribute("name", "zyj");
        return Result.success("nihao");
    }
    @RequestMapping("/db/get")
    @ResponseBody
    Result<User> getById(){
        System.out.println(userService.getById(2));
        return Result.success(userService.getById(2));
    }
    @RequestMapping("/get/html")
    String getHtml(Model model){
        model.addAttribute("name", "zyj");
        return "hello";
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    Result<String> getRedisVal(){
        String str = redisService.get("key", String.class);
        return Result.success(str);
    }
}
