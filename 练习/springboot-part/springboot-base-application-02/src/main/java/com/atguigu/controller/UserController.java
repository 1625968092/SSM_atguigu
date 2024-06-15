package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("1")
public class UserController {

    @Autowired
    private User user;

    @GetMapping("2")
    public User user(){
        return user;
    }

    @GetMapping("3")
    public String show(){
        return "能不能行";
    }
}
