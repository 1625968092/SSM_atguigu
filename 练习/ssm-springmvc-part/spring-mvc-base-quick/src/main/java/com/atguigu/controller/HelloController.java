package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //handler  ---> springMvc/hello   return "springMvc"

    @RequestMapping("springmvc/hello")  //对外访问的地址 到HandlerMapping注册的注解
    @ResponseBody  //直接返回字符串给前端，不要找视图解析器
    public String hello() {
        System.out.println("Hello SpringController");
        //返回给前端
        return "Hello SpringMvc";
    }
}
