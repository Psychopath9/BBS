package com.bbs.controller.lai;

import com.bbs.entity.User;
import com.bbs.result.Result;
import com.bbs.result.ResultFactory;
import com.bbs.service.lai.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "用户控制器，包含用户的登录、注册")
@RestController
public class UserController {

    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Result> login(@RequestParam(value = "id")Integer id, @RequestParam(value = "password")String password) {
        int result = userService.verifyUser(id, password);
        if(result == 1) {
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(id), HttpStatus.OK);
        }else if (result == 10) {
            return new ResponseEntity<>(ResultFactory.buildResult(201,"管理员登录", id),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }


    @GetMapping(path = "/user/{id}")
    public ResponseEntity<Result> getUser(@PathVariable("id")Integer id) {
        List<User> list = userService.findByUserid(id);
        User user = list.get(0);
        return new ResponseEntity<>(ResultFactory.buildSuccessResult(user),HttpStatus.OK);
    }

    @PutMapping(path = "/user/{id}")
    public ResponseEntity<Result> updateUser(@RequestBody User user) {
        if(userService.update(user) == 1) {
            return new ResponseEntity<>(ResultFactory.buildSuccessResult("成功"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }


    @PostMapping(path = "/user")
    public ResponseEntity<Result> register(@RequestBody User user) {
        if (userService.registerUser(user)) {
            return new ResponseEntity<>(ResultFactory.buildSuccessResult("注册成功"),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }


}
