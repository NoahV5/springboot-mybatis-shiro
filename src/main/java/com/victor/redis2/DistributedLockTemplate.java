package com.victor.redis2;

import java.util.concurrent.TimeUnit;

/**
 * @author Victor
 * @date 2018/01/05
 * 分布式锁操作模板
 */
public interface DistributedLockTemplate {

    /**
     * 使用分布式锁，使用锁默认超时时间。
     *
     * @param callback
     * @return
     */
     <T> T lock(DistributedLockCallback<T> callback);

    /**
     * 使用分布式锁。自定义锁的超时时间
     *
     * @param callback
     * @param leaseTime 锁超时时间。超时后自动释放锁。
     * @param timeUnit
     * @return
     */
     <T> T lock(DistributedLockCallback<T> callback, long leaseTime, TimeUnit timeUnit);
}
