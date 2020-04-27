package com.deepflow.joke.client.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.deepflow.joke.client.api.impl.JokeServiceFallBack;
import com.deepflow.joke.client.configuration.EnableFeignClientConfiguration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({EnableFeignClientConfiguration.class, JokeServiceFallBack.class})
public @interface JokeClientStarter {}
