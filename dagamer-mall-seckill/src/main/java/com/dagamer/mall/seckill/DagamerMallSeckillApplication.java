package com.dagamer.mall.seckill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DagamerMallSeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(DagamerMallSeckillApplication.class, args);
    }

}
