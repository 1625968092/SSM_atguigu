package com.atguigu.advice;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class TxAroundAdvice {

    /**
     *  环绕通知，需要你在通知中，定义目标方法的执行！
     * @param pjp 目标方法
     * @return 目标方法的返回值
     * @throws Throwable
     */

    @Around("com.atguigu.pointcut.MyPointCut.pointCut()")
    public Object transaction(ProceedingJoinPoint pjp){

        Object[] args = pjp.getArgs();
        Object result=null;


        try{
        //增强代码
            System.out.println("开启事务");
            result = pjp.proceed(args);
            System.out.println("事务结束");
        }catch (Exception e){
            System.out.println("事务回滚");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally最后执行.....");
        }

        return null;
    }
}
