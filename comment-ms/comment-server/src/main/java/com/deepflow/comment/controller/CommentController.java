package com.deepflow.comment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deepflow.comment.service.CommentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/comments")
@Slf4j
@Api("comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "获取评论详情", notes = "根据评论 id 获取详情")
    @ApiParam(value = "评论id")
    @GetMapping("/detail/{id}")
    public String getCommentDetails(@PathVariable("id") String id) {
        log.debug("Get comment by id [{}]", id);
        return id;
    }

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
