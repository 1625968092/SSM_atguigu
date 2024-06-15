package com.atguigu.advice;


import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

@Component
@Aspect
@Order(1)  //设置优先级，数字越小优先级越大
public class TxAdvice {


    @Before("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void begin(){
        System.out.println("开启事务....");
    }

    @AfterReturning("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void commit(){
        System.out.println("事务提交.....");
    }

    @AfterThrowing("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void rollBack(){
        System.out.println("事务回滚......");
    }
}
