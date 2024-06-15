package com.atguigu.path;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 路径参数演示
 */

@Controller
@RequestMapping("/path")
@ResponseBody
public class PathController {


    // path/账号/密码

    /**
     * 动态路径的设计  {key}  =  *   {key}可以在形参列表获取传入的参数
     * 接收路径参数  String account,String password-> 接收Param格式参数
     */

    @RequestMapping("{account}/{password}")
    public String login(@PathVariable(value = "account") String username, @PathVariable String password){
        System.out.println("username = " + username +"===="+ " password = " + password);
        return "username = " + username +"===="+ " password = " + password;
    }
}
