package com.atguigu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
/*
    读取配置的第一种方式 @value
    直接在属性上添加注解
    注意：value的key一定要写全了，value只能读取单个值

    第二种方式 批量配置读取
    方便，可以给集合类型赋值

 */
@Data
@Component
@ConfigurationProperties(prefix = "user")  //yaml中属性名和pojo属性名相同即可
public class User {
   // @Value("${user.name}") //di注入
    private String name;
   // @Value("${user.password}")
    private String password;
   // @Value("${user.gfs}")
    private List<String> gfs;

}
