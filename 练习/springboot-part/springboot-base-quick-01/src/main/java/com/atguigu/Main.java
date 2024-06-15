package com.atguigu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //启动类注解
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);  //自动创建IOC容器，启动tomcat服务器软件

    }
}
