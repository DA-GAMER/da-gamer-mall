package com.dagamer.mall.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DagamerMallRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DagamerMallRedisApplication.class, args);
    }

}
