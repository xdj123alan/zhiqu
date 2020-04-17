package com.deepflow.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.HystrixCommands;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepflow.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/comments")
@Slf4j
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{id}")
    public String getComments(@PathVariable("id") String id) {
        log.debug("Get comment by id [{}]", id);
        return commentService.getComment(id);
    }

    @GetMapping("/ports")
    public String getJokePort(Integer a, Integer b) {
        log.debug("Get joke port a [{}] b [{}]", a, b);
        return commentService.getJokePort(a, b);
    }

    @HystrixCommand(fallbackMethod = "defaultUser")
    @GetMapping("/user/{name}")
    public String getUser(@PathVariable("name") String username) throws Exception{
        if("spring".equals(username)){
            return "spring";
        } else{
            throw new Exception();
        }
    }

    public String defaultUser(String username){
        return "This user doesn't exist";
    }
}
