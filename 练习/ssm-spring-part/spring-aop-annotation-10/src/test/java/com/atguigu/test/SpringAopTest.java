package com.atguigu.test;


import com.atguigu.config.JavaConfiguration;
import com.atguigu.service.Calculator;
import com.atguigu.service.impl.CalculatorPureImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfiguration.class)
public class SpringAopTest {


    //aop - 代理技术  -  因为实现类有接口，选择jdk代理  - 根据接口生成代理类 - 代理对象和目标对象是拜把子关系  - 必须使用接口接值
    //aop - ioc - 真正存储的是代理对象，而不是目标对象了
    @Autowired
    private Calculator calculator;

    @Test
    public void test(){
        int result = calculator.add(1, 0);
        System.out.println("result = " + result);
    }
}
