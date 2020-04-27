package com.deepflow.joke.client.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients({"com.deepflow.joke.client.api"})
public class EnableFeignClientConfiguration {
    public EnableFeignClientConfiguration() {}
}
