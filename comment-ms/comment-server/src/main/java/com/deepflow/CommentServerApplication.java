package com.deepflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deepflow.clients.annotation.JokeServerStarter;

@SpringBootApplication
@JokeServerStarter
public class CommentServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommentServerApplication.class, args);
    }

    // @Bean
    // Logger.Level feignLoggerLevel() {
    // return Logger.Level.FULL;
    // }
}
