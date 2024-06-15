package com.atguigu.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointCut {

    @Pointcut("execution(* com..impl.*.*(..))")
    public void pointCut(){

    }

    @Pointcut("execution(* com..impl.*.*(..))")
    public void mPc(){

    }
}
