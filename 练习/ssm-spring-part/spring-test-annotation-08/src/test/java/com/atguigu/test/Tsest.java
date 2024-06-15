package com.atguigu.test;

import com.atguigu.components.A;
import com.atguigu.components.B;
import com.atguigu.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(value = JavaConfig.class)
public class Tsest {

    @Autowired
    private A a;

    @Autowired
    private B b;

    @Test
    public void test(){
        //获取容器

        //获取组件

        System.out.println(a);
        System.out.println(b);
        //关闭容器
    }
}
