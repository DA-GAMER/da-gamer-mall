package com.dagamer.mall.redis.service;

public interface RedisService {

    void put(String key, String val, long sec);

    Object get(String key);

}
