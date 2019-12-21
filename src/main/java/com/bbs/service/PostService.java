package com.bbs.service;

import com.bbs.dao.chai.PostDao;
import com.bbs.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostDao dao;
    public List<Post> findAll(){
        return dao.findAll();
    }
}
