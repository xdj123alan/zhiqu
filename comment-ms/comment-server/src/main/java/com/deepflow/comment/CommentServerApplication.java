package com.deepflow.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import com.deepflow.joke.client.annotation.JokeClientStarter;

@SpringBootApplication
@JokeClientStarter
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
