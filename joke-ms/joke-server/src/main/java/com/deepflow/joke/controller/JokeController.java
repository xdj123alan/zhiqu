package com.deepflow.joke.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/jokes")
@Slf4j
public class JokeController {

    @ApiOperation(value = "获取笑话列表", notes = "获取笑话列表")
    @GetMapping("/list")
    public String getJokes() {
        log.debug("Get jokes");
        return "jokes";
    }

    @ApiOperation(value = "根据笑话id获取笑话", notes = "根据笑话id获取笑话")
    @ApiParam("笑话id")
    @GetMapping("/{id}")
    public String getJokeById(@PathVariable(name = "id") String id) {
        log.debug("Get joke by id [{}]", id);
        return "joke";
    }

    @ApiOperation(value = "根据笑话id删除笑话", notes = "根据笑话id删除笑话")
    @ApiParam("笑话id")
    @DeleteMapping("/{id}")
    public void deleteJokeById(@PathVariable(name = "id") String id) {
        log.debug("Delete joke by id [{}]", id);
    }

    @ApiOperation(value = "创建笑话", notes = "创建笑话")
    @PostMapping
    public String createJoke(@RequestBody String body) {
        log.debug("Create joke [{}]", body);
        return body;
    }

    @ApiOperation(value = "获取 joke 服务端口", notes = "获取服务端口")
    @GetMapping("/port")
    public String printRequest(@RequestParam("a") Integer a, @RequestParam("b") Integer b, HttpServletRequest request) {
        log.debug("print request info [{}]", request);
        StringBuilder result = new StringBuilder();
        result.append("From port:").append(request.getServerPort()).append(", a and b is ").append(a).append("-")
            .append(b);
        return result.toString();
    }
}
