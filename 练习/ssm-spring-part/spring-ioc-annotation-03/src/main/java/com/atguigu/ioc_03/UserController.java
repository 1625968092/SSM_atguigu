package com.atguigu.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


@Controller
public class UserController {

    @Autowired  //<property  UserService>   boolean required () default true必须有组件否则报错
    //@Autowired(required = false)   //佛系装配  可以没有组件，也不报错,不推荐使用，会出现空指针
    //自动装配注解（DI）  1.IOC容器中查找复合类型的对象 2.设置给当前属性（DI）
    @Qualifier(value="userServiceImpl") //有多个组件时可以添加Qualifier来区别组件名称id，不能单独使用
    @Resource  //等于  AutoWired  +  Qualifier
    private UserService userService;

    @Resource(name = "userServiceImpl")
    private UserService userService1;


    public void show(){
        String show = userService1.show();
        System.out.println(show);
    }
}
