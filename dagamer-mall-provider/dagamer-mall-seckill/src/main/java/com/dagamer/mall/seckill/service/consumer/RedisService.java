package com.dagamer.mall.seckill.service.consumer;

import com.dagamer.mall.common.util.Wrapper;
import com.dagamer.mall.seckill.service.consumer.fallback.RedisServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dagamer-mall-redis", fallback = RedisServiceFallback.class)
public interface RedisService {

    @RequestMapping(value = "put", method = RequestMethod.POST)
    Wrapper put(@RequestParam("key") String key, @RequestParam("val") String val, @RequestParam("sec") long sec);

    @RequestMapping(value = "get", method = RequestMethod.GET)
    String get(@RequestParam("key") String key);

}
