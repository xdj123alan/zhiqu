package com.deepflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepflow.clients.api.JokeClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommentService {

    @Autowired
    private JokeClient jokeClient;

    public String getComment(String id) {
        log.debug("Get Comment by id [{}]", id);
        String joke = jokeClient.getJokeById(id);
        return joke;
    }

    public String getJokePort(Integer a, Integer b) {
        log.debug("Get joke port a [{}] b [{}]", a, b);
        return jokeClient.printRequest(a, b);
    }
}
