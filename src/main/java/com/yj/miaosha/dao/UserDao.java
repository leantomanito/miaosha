package com.yj.miaosha.dao;

import com.yj.miaosha.entry.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User select(@Param("id") int id);
}
