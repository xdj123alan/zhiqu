package com.deepflow.clients.api.impl;

import com.deepflow.clients.api.JokeService;
import org.springframework.stereotype.Component;

@Component
public class JokeServiceFallBack implements JokeService {
    @Override
    public String getJokes() {
        return "This jokes doesn't exist";
    }

    @Override
    public String getJokeById(String id) {
        return "This joke doesn't exist";
    }

    @Override
    public void deleteJokeById(String id) {

    }

    @Override
    public String createJoke(String body) {
        return null;
    }

    @Override
    public String printRequest(Integer a, Integer b) {
        return null;
    }
}
