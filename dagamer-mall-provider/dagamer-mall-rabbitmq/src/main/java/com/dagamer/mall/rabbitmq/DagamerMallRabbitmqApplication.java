package com.dagamer.mall.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DagamerMallRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(DagamerMallRabbitmqApplication.class, args);
    }

}
