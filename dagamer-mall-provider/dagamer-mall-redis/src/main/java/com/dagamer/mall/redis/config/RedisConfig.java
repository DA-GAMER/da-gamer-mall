package com.dagamer.mall.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 处理在Redis Desktop Manager显示乱码问题以及incr自增失败问题
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        template.setConnectionFactory(factory);

        template.setKeySerializer(redisSerializer);
        template.setValueSerializer(redisSerializer);

        template.setHashKeySerializer(redisSerializer);
        template.setHashValueSerializer(redisSerializer);
        return template;
    }

}
