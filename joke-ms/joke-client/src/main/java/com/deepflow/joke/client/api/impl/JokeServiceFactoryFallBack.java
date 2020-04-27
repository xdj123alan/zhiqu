package com.deepflow.joke.client.api.impl;

import com.deepflow.joke.client.api.JokeService;

import feign.hystrix.FallbackFactory;

public class JokeServiceFactoryFallBack implements FallbackFactory<JokeService> {
    @Override
    public JokeService create(Throwable throwable) {
        return new JokeService() {
            @Override
            public String getJokes() {
                return "This is a ";
            }

            @Override
            public String getJokeById(String id) {
                return "";
            }

            @Override
            public void deleteJokeById(String id) {}

            @Override
            public String createJoke(String body) {
                return "";
            }

            @Override
            public String printRequest(Integer a, Integer b) {
                return "";
            }
        };
    }
}
