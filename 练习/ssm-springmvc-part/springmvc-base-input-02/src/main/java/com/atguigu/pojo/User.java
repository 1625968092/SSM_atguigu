package com.atguigu.pojo;


import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    private String name;  //属性必须等于参数名
    private int age = 18;

}
