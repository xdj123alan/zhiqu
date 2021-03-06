package com.deepflow.joke.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.deepflow.joke.client.api.impl.JokeServiceFallBack;

@FeignClient(name = "joke-server", url = "${custom.feign.url}", path = "/jokes", fallback = JokeServiceFallBack.class)
public interface JokeService {

    @GetMapping(value = "/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    String getJokes();

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    String getJokeById(@PathVariable(name = "id") String id);

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteJokeById(@PathVariable(name = "id") String id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    String createJoke(@RequestBody String body);

    @GetMapping(value = "/port", consumes = MediaType.APPLICATION_JSON_VALUE)
    String printRequest(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
