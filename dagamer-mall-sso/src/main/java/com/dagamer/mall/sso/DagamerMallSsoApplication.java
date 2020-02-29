package com.dagamer.mall.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DagamerMallSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DagamerMallSsoApplication.class, args);
    }

}
