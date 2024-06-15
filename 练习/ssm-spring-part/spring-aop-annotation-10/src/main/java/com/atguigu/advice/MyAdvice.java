package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * 定义四个增强方法获取对象的方法信息，返回值，异常对象
 *      (JoinPoint joinPoint)
 *      joinPoint中就包含目标方法的信息
 *
 * 1. 定义方法 - 增强代码
 * 2. 使用注解 - 指定对应的位置
 * 3. 切点表达式，选中方法
 * 4. 切面和ioc的配置
 * 5. 开启aspect注解的支持
 *
 *  增强中获取目标信息
 *  1. 全部增强方法中获取，获取目标方法的信息 包括方法名  参数  访问修饰符  所属类的信息
 *      (JoinPoint joinPoint)
 *  *   joinPoint中就包含目标方法的信息
 *  2. 返回的结果，只在AfterReturning中
 *      (Object result)
 *      @AfterReturning(value = "execution(* com..impl.*.*(..))",returning = "result")//正常结束会走这里
 *      //代表result接收返回结果
 *  3. 获取异常信息，只在afterThrowing
 *      (JoinPoint joinPoint,Throwable throwable)
 *      @AfterReturning(value = "execution(* com..impl.*.*(..))",returning = "result")//正常结束会走这里
 *
 */

//@Aspect
//@Component
public class MyAdvice {


    /**
     * 切点表达式的复用
     * 1. 当前类中提取
     *      定义一个空方法
     *      注解@Pointcut()
     *      增强注解中引用切点表达式的方法,直接调用方法名
     *
     * 2. 创建一个存储切点的类
     *      单独维护切点表达式
     *      其他类的切点方法 类的全限定符.方法名()
     */

    @Pointcut("execution(* com..impl.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        //1. 获取方法所属类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        //2. 获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers();
        String modifier = Modifier.toString(modifiers);
        String methodName = joinPoint.getSignature().getName();
        //3. 获取参数列表
        Object[] args = joinPoint.getArgs(); //获取目标方法参数



    }

    @AfterReturning(value = "pointCut()",returning = "result")//正常结束会走这里
    public void afterReturning(JoinPoint joinPoint,Object result){

    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){

    }

    @AfterThrowing(value = "pointCut()",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint,Throwable throwable){

    }
}
