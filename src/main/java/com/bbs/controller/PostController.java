package com.bbs.controller;

import com.bbs.entity.Post;
import com.bbs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "post")
public class PostController {
    @Autowired
    private PostService service;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Post> findAll(){
        return service.findAll();
    }
}
