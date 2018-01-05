package com.victor.redis;

import org.springframework.stereotype.Component;

/**
 * @author Victor
 * @date 2018/01/05
 */
@Component
public class LockTest {

    private static int i = 0;

    @RedisLock(lockKey = "lockKey")
    public void add(@RedisLockKey(order = 1) String key,
                    @RedisLockKey(order = 0) int key1) {
        i++;
        System.out.println("i=***************************************" + i);
    }
}
