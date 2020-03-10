package com.dagamer.mall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@MapperScan("com.dagamer.mall.user.mapper")
public class DagamerMallUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(DagamerMallUserApplication.class, args);
    }
}
