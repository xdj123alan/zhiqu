package com.deepflow.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UaaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UaaServerApplication.class, args);
    }
}
