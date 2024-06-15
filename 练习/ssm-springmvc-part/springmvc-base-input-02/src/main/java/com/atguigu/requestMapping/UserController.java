package com.atguigu.requestMapping;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {


    //handler ----》 注册到  handlerMapping中

    /**
     *   /  可加可不加
     */

    @RequestMapping("/login")
    public String login(){
        return null;
    }

    /**
     * 可以放在类上
     * @RequestMapping("/user")
     * 只能使用在方法上
     * @GetMapping
     * @PutMapping
     * @DeleteMapping
     * @PostMapping
     */

    @GetMapping("register")
    @PutMapping
    @DeleteMapping
    @PostMapping
    public String register(){
        return null;
    }
}
