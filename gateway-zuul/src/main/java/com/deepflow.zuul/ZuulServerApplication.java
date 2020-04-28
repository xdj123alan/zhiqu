package com.deepflow.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableZuulProxy
@EnableOAuth2Sso
public class ZuulServerApplication {
    public static void main(String[] args){
        SpringApplication.run(ZuulServerApplication.class,args);
    }
}
