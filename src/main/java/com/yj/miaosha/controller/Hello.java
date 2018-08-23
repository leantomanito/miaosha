package com.yj.miaosha.controller;

import com.yj.miaosha.entry.User;
import com.yj.miaosha.result.Result;
import com.yj.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class Hello {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    Result<String> showName(Model model){
        model.addAttribute("name", "zyj");
        return Result.success("nihao");
    }
    @RequestMapping("/db/get")
    Result<User> getById(){
        return Result.success(userService.getById(1));
    }
}
