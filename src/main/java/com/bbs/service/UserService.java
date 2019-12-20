package com.bbs.service;

import com.bbs.dao.UserDao;
import com.bbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao dao;
    public List<User>findAll(){
        return dao.findAll();
    }
}
