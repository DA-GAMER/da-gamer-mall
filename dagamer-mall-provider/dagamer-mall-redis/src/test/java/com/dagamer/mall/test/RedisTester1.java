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

    @Test
    public void t2() {
        System.out.println(redisTemplate.opsForValue().get("7a8587cb2c2c42cab2a6fcf4e8d2e53a"));
    }
}
