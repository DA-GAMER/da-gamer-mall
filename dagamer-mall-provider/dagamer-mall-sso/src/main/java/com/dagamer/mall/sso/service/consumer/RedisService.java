package com.dagamer.mall.sso.service.consumer;

import com.dagamer.mall.common.util.Wrapper;
import com.dagamer.mall.sso.service.consumer.fallback.RedisServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dagamer-mall-redis", fallback = RedisServiceFallback.class)
public interface RedisService {

    @RequestMapping(value = "put", method = RequestMethod.POST)
    Wrapper put(@RequestParam("key") String key, @RequestParam("val") String val, @RequestParam("sec") long sec);

}
