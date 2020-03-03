package com.dagamer.mall.sso.service.consumer.fallback;

import com.dagamer.mall.common.util.Wrapper;
import com.dagamer.mall.common.util.WrapperOperator;
import com.dagamer.mall.sso.service.consumer.RedisService;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceFallback implements RedisService {

    @Override
    public Wrapper<String> put(String key, String val, long sec) {
        return WrapperOperator.error();
    }
}
