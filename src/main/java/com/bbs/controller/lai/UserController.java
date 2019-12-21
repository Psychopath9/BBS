package com.bbs.controller.lai;

import com.bbs.entity.User;
import com.bbs.result.Result;
import com.bbs.result.ResultFactory;
import com.bbs.service.lai.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Result> login(Integer id, String password) {
        int result = userService.verifyUser(id, password);
        if(result == 1) {
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(id), HttpStatus.OK);
        }else if (result == 10) {
            return new ResponseEntity<>(ResultFactory.buildResult(201,"管理员登录", id),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }

}
