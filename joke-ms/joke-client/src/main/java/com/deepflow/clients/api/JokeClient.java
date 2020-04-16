package com.deepflow.clients.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "joke-resource", url = "${custom.feign.url}", path = "/jokes")
public interface JokeClient {

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
