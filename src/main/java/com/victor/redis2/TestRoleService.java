package com.victor.redis2;

import com.victor.sys.mapper.RoleMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author Victor
 * @date 2018/01/05
 */
@Service
public class TestRoleService {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    DistributedLockTemplate distributedLockTemplate;

    /**
     * 加锁
     */
    @Async
    public void addAsync(){
        distributedLockTemplate.lock(new DistributedLockCallback<Object>(){
            @Override
            public Object process() {
                add();
                return null;
            }

            @Override
            public String getLockName() {
                return "MyLock";
            }
        });
    }

    /**
     * 未加锁
     */
    @Async
    public void addNoAsync(){
        add();
    }

    /**
     * 测试异步方法
     * 在不加分布式锁的情况下
     * num数目会混乱
     */
    @Async
    private void add(){
        System.out.println(Thread.currentThread().getName() + " start");
        Random random = new Random();
        int _int = random.nextInt(200);
        System.out.println(Thread.currentThread().getName() + " sleep " + _int + "millis");
        try {
            Thread.sleep(_int);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " end");
      //  doneSignal.countDown();
    }
}
