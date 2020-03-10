package com.dagamer.mall.seckill.service.consumer.fallback;

import com.dagamer.mall.common.util.Wrapper;
import com.dagamer.mall.seckill.service.consumer.RedisService;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceFallback implements RedisService {
    @Override
    public Wrapper put(String key, String val, long sec) {
        System.out.println("put");
        return null;
    }

    @Override
    public String get(String key) {
        System.out.println("get");
        return null;
    }
}
