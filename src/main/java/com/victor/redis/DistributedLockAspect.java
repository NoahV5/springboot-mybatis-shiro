package com.victor.redis;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author Victor
 * @date 2018/01/04
 * 切面
 */
@Aspect
@Component
public class DistributedLockAspect {

    @Autowired
    private DistributedLockTemplate lockTemplate;

    @Pointcut("@annotation(DistributedLock)")
    public void DistributedLockAspect() {}



    @Around(value = "DistributedLockAspect()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        //切点所在的类名
        String targetName = pjp.getTarget().getClass().getName();

        //使用了注解的方法
        String methodName = pjp.getSignature().getName();

        Class targetClass = Class.forName(targetName);

        Method[] methods = targetClass.getMethods();

        Object[] arguments = pjp.getArgs();

        //得到使用注解的方法。可使用Method.getAnnotation(Class<T> annotationClass)获取指定的注解，然后可获得注解的属性
        Optional<Method> optional = Arrays.stream(methods)
                .parallel()
                .filter(method -> method.getName().equals(methodName))
                .findAny();

        if (optional.isPresent()) {
            Method m = optional.get();
            final String lockName = getLockName(m, arguments);
            return lock(pjp, m, lockName);
        }

        return null;
    }

    public String getLockName(Method method, Object[] args) throws Throwable {

        DistributedLock annotation = method.getAnnotation(DistributedLock.class);

        String lockName = annotation.lockName(),
                param = annotation.param();

        if (StringUtils.isEmpty(lockName)) {

            if (args.length > 0) {
                if (annotation.argNum() > 0) {
                    lockName = args[annotation.argNum() - 1].toString();
                }

                if (!StringUtils.isEmpty(param)) {
                    Object arg = args[0];
                    lockName = String.valueOf(getParam(arg, param));
                }
            }
        }

        if (! StringUtils.isEmpty(lockName)) {
            String preLockName = annotation.lockNamePre(),
                    postLockName = annotation.lockNamePost();

            lockName = preLockName + lockName + postLockName;

            return lockName;
        }

        throw new IllegalArgumentException("Can't get or generate lockName accurately!");
    }

    /**
     * 从方法参数获取数据
     *
     * @param param
     * @param arg 方法的参数数组
     * @return
     */
    public Object getParam(Object arg, String param) throws Throwable {

        if (!StringUtils.isEmpty(param) && arg != null) {
            Object result = PropertyUtils.getProperty(arg, param);
            return result;
        }

        return null;
    }

    public Object lock(ProceedingJoinPoint pjp, Method method, final String lockName) {

        DistributedLock annotation = method.getAnnotation(DistributedLock.class);

        boolean fairLock = annotation.fairLock();

        boolean tryLock = annotation.tryLock();

        if (tryLock) {
            return tryLock(pjp, annotation, lockName, fairLock);
        } else {
            return lock(pjp,lockName, fairLock);
        }
    }

    public Object lock(ProceedingJoinPoint pjp, final String lockName, boolean fairLock) {
        return lockTemplate.lock(new DistributedLockCallback<Object>() {
            @Override
            public Object process() {
                return proceed(pjp);
            }

            @Override
            public String getLockName() {
                return lockName;
            }
        }, fairLock);
    }

    public Object tryLock(ProceedingJoinPoint pjp, DistributedLock annotation, final String lockName, boolean fairLock) {

        long waitTime = annotation.waitTime(),
                leaseTime = annotation.leaseTime();
        TimeUnit timeUnit = annotation.timeUnit();

        return lockTemplate.tryLock(new DistributedLockCallback<Object>() {
            @Override
            public Object process() {
                return proceed(pjp);
            }

            @Override
            public String getLockName() {
                return lockName;
            }
        }, waitTime, leaseTime, timeUnit, fairLock);
    }

    public Object proceed(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
