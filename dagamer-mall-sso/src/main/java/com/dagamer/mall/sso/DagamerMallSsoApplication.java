package com.dagamer.mall.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
@MapperScan("com.dagamer.mall.sso.mapper")
public class DagamerMallSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DagamerMallSsoApplication.class, args);
    }

}
