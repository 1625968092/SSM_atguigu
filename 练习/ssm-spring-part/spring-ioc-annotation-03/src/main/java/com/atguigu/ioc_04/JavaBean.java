package com.atguigu.ioc_04;

import org.springframework.beans.factory.annotation.Value;

public class JavaBean {
    /*
    <bean id="" class="">
        <property name="" value="">
    </bean>
     */

    //方案一：直接赋值
    private String name="二狗子";

    //方案二：使用注解赋值,读取外部配置
    @Value("19")
    private int age;

    @Value("${jdbc.username:admin}")
    private String userName;

    @Value("${jdbc.password}")
    private String passWord;
}
