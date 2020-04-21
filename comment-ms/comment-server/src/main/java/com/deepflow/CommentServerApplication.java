package com.deepflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deepflow.clients.annotation.JokeServerStarter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@JokeServerStarter
@EnableHystrix
public class CommentServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentServerApplication.class, args);
    }

    // @Bean
    // Logger.Level feignLoggerLevel() {
    // return Logger.Level.FULL;
    // }
}
