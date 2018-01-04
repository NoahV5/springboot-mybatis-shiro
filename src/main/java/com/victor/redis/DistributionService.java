package com.victor.redis;

import com.victor.sys.entity.Role;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Victor
 * @date 2018/01/04
 */
@Service
public class DistributionService {

    @Autowired
    private RedissonClient redissonClient;

    @DistributedLock(lockName = "lock", lockNamePost = ".lock")
    public Integer aspect() {
        RMap<String, Integer> map = redissonClient.getMap("distributionTest");

        Integer count = map.get("count");

        if (count > 0) {
            count = count - 1;
            map.put("count", count);
        }

        return count;
    }

    @DistributedLock(param = "id", lockNamePost = ".lock")
    public Integer aspect(Role role) {
        RMap<String, Integer> map = redissonClient.getMap("distributionTest");

        Integer count = map.get("count");

        if (count > 0) {
            count = count - 1;
            map.put("count", count);
        }

        return count;
    }

}
