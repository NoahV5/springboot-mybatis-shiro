package com.victor.redis;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.concurrent.CountDownLatch;

/**
 * @author Victor
 * @date 2018/01/04
 */
@Controller
@RequestMapping("/distributedLockTest")
public class DistributedLockTestController {

    private int count = 10;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private DistributionService service;

    @RequestMapping(method = RequestMethod.GET)
    public String distributedLockTest() throws Exception {

        RMap<String, Integer> map = redissonClient.getMap("distributionTest");
        map.put("count", 8);

        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(count);

        for (int i = 0; i < count; ++i) { // create and start threads
            new Thread(new Worker(startSignal, doneSignal, service)).start();
        }

        startSignal.countDown(); // let all threads proceed
        doneSignal.await();
        System.out.println("All processors done. Shutdown connection");

        return "finish";
    }
}
