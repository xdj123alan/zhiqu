package com.deepflow.joke.client.api.impl;

import org.springframework.stereotype.Component;

import com.deepflow.joke.client.api.JokeService;

@Component
public class JokeServiceFallBack implements JokeService {
    @Override
    public String getJokes() {
        return "This is a joke";
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
}
