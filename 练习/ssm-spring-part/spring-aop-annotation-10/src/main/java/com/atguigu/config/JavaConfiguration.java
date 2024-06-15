package com.atguigu.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.atguigu")
@Configuration
@EnableAspectJAutoProxy  //开启aspectJ的注解
public class JavaConfiguration {

}
