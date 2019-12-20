package com.bbs.service;

import com.bbs.dao.PostDao;
import com.bbs.dao.UserDao;
import com.bbs.entity.Post;
import com.bbs.entity.User;
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
