package com.victor.redis;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author Victor
 * @date 2018/01/04
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DistributedLock {

    String lockName() default ""; //如果lockName可以确定，直接设置该属性

    String lockNamePre() default ""; //lockName后缀

    String lockNamePost() default ""; //lockName后缀

    String param() default ""; //获取注解的方法第一个参数对象的某个属性值来作为lockName。因为有时候lockName是不固定的。

    int argNum() default 0; //将方法第argNum个参数作为锁

    boolean fairLock() default false;  //是否使用公平锁。

    boolean tryLock() default false;  //是否使用尝试锁。

    long waitTime() default 30L;

    long leaseTime() default 5L;

    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
