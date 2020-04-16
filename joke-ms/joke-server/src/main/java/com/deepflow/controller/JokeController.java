package com.deepflow.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/jokes")
@Slf4j
public class JokeController {

    @GetMapping("/list")
    public String getJokes() {
        log.debug("Get jokes");
        return "jokes";
    }

    @GetMapping("/{id}")
    public String getJokeById(@PathVariable(name = "id") String id) {
        log.debug("Get joke by id [{}]", id);
        return "joke";
    }

    @DeleteMapping("/{id}")
    public void deleteJokeById(@PathVariable(name = "id") String id) {
        log.debug("Delete joke by id [{}]", id);
    }

    @PostMapping
    public String createJoke(@RequestBody String body) {
        log.debug("Create joke [{}]", body);
        return body;
    }

    @GetMapping("/port")
    public String printRequest(@RequestParam("a") Integer a, @RequestParam("b") Integer b, HttpServletRequest request) {
        log.debug("print request info [{}]", request);
        StringBuilder result = new StringBuilder();
        result.append("From port:").append(request.getServerPort()).append(", a and b is ").append(a).append("-")
            .append(b);
        return result.toString();
    }
}
