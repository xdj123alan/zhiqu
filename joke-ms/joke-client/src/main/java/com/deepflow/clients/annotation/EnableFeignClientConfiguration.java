package com.deepflow.clients.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients({"com.deepflow.clients.api"})
public class EnableFeignClientConfiguration {}
