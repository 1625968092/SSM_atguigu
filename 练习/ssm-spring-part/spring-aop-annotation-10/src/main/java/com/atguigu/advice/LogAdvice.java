package com.atguigu.advice;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

/**
 * 增强类的内部要存储增强代码
 *
 * 1. 定义方法存储增强代码，具体定义几个根据插入位置定
 * 2. 使用注解配置  指定插入目标方法的位置
 *      前置  @Before
 *      后置  @AfterReturning
 *      异常  @AfterThrowing
 *      最后  @After
 *      环绕  @Around
 *
 *      try{
 *          //前置  @Before
 *          目标方法执行
 *          //后置  @AfterReturning
 *      }catch (Exception e)
 *      {
 *          //异常  @AfterThrowing
 *      }finally{
 *          //最后  @After
 *      }
 *
 * 3. 配置切点表达式  【选中插入的方法  切点】
 * 4. 补全注解@Component 和@Aspect
 *
 * spring AOP ---  重点是配置  -->   jdk/Cglib
 *
 * 5. 开启aspect注解的支持
 */

@Component
@Aspect
@Order(20)
public class LogAdvice {
    @Before("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void start(){
        System.out.println("方法开始了");
    }

    @After("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void after(){
        System.out.println("方法结束了");
    }

    @AfterThrowing("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void error(){
        System.out.println("方法报错了");
    }
}
