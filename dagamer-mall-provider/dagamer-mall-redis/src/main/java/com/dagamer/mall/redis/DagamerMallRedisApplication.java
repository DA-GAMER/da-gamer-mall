package com.dagamer.mall.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DagamerMallRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DagamerMallRedisApplication.class, args);
    }

}
