package com.atguitu.ioc_01;

public class HappyComponent {

    static Integer integer;
    public void sayHello(){
        System.out.println("Happy Component");
    }

    public Integer creatInteger(){
        return integer;
    }
}
