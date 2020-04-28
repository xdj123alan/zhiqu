package com.deepflow.zuul.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ZhiQuWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http//
        .authorizeRequests()//
        .antMatchers("/login","/client/**")//
        .permitAll()//
        .anyRequest()//
        .authenticated()//
        .and()//
        .csrf()//
        .disable();
    }
}
