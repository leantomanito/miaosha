package com.yj.miaosha.service;

import com.yj.miaosha.dao.UserDao;
import com.yj.miaosha.entry.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getById(int id){
        User user = userDao.select(id);
        return user;
    }

}
