package com.atguigu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mvc")
public class HelloController {

    @GetMapping("hello")
    public String ret(){
        return "this is mvc";
    }
}
