package com.dagamer.mall.test;

import com.dagamer.mall.redis.DagamerMallRedisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DagamerMallRedisApplication.class)
public class RedisTester1 {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void t1() {
        redisTemplate.opsForValue().set("h", "j");
    }
}
