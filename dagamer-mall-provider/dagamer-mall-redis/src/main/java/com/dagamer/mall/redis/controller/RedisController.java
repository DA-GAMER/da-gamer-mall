package com.dagamer.mall.redis.controller;

import com.dagamer.mall.common.util.Wrapper;
import com.dagamer.mall.common.util.WrapperOperator;
import com.dagamer.mall.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "put", method = RequestMethod.POST)
    public Wrapper put(String key, String val, long sec) {
        redisService.put(key, val, sec);
        return WrapperOperator.ok();
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(String key) {
        return (String) redisService.get(key);
    }

}
