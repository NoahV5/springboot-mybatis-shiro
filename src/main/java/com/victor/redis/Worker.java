package com.victor.redis;

import com.victor.sys.entity.Role;

import java.util.concurrent.CountDownLatch;

/**
 * @author Victor
 * @date 2018/01/04
 */
public class Worker implements Runnable {

    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private final DistributionService service;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal, DistributionService service) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
        this.service = service;
    }

    @Override
    public void run() {
        try {
            startSignal.await();

            System.out.println(Thread.currentThread().getName() + " start");

            //Integer count = service.aspect();
            Integer count = service.aspect(new Role("张三"));

            System.out.println(Thread.currentThread().getName() + ": count = " + count);

            doneSignal.countDown();

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
