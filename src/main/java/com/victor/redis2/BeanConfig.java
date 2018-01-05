package com.victor.redis2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Victor
 * @date 2018/01/05
 */
@Configuration
public class BeanConfig {

    @Bean
    public DistributedLockFactoryBean distributeLockTemplate(){
        DistributedLockFactoryBean d  = new DistributedLockFactoryBean();
        d.setMode("SINGLE");
        return d;
    }
}
