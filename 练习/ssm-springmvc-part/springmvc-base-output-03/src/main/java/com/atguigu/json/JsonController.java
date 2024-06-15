package com.atguigu.json;


import com.atguigu.pojo.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/json")
@ResponseBody //返回json的注解，可以添加到类上，也可以添加在方法、接口上
@RestController   // 它是  Controller  +  ResponseBody的结合体
public class JsonController {

    /**
     *  @ResponseBody 会将数据直接放入响应体中，也不会再走视图解析器
     *      快速查找视图和  转发重定向都不生效了！
     */


    @RequestMapping("data")
    @ResponseBody
    public User data(){
        User user = new User();
        user.setName("twoDog");
        user.setAge(3);
        return user;   //user  ---> handlerAdapter --->Json  --->@responseBody--->Json返回【前后端分离模式】
    }


    @RequestMapping("data1")
    @ResponseBody
    public List<User> data1(){

        List<User> users=new ArrayList<>();
        users.add(new User("erya",6));
        users.add(new User("ergouzi",18));
        return users;   //user  ---> handlerAdapter --->Json  --->@responseBody--->Json返回【前后端分离模式】
    }
}
