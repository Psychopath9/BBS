package com.bbs.controller.chai;

import com.bbs.entity.Comment;
import com.bbs.entity.CommentId;
import com.bbs.entity.User;
import com.bbs.result.Result;
import com.bbs.result.ResultFactory;
import com.bbs.service.chai.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;

@RestController
public class CommentController {
    @Autowired
    private CommentService service;

    @PostMapping (path = "/comment")
    public ResponseEntity<Result> addComment(@RequestParam(value = "post_title")int post_id, @RequestParam(value = "post_content")String content, int userid){
//        User user = (User)session.getAttribute("user");
//        if(user==null){
//            return new ResponseEntity<>(ResultFactory.buildResult(2001,"未登录不能进行评论", null),HttpStatus.OK);
//        }
//        int userid = user.getUserid();

        CommentId id = new CommentId();
        id.setPostid(post_id);
        id.setUserid(userid);
//        comment.setId(id);
//        comment.setContent(content);
//        comment.setAccept(0);
        Comment comment = new Comment(id,content,new Timestamp(System.currentTimeMillis()),0);
         int result = service.insert(comment);
         if(result==1){
             return new ResponseEntity<>(ResultFactory.buildSuccessResult(comment), HttpStatus.OK);
         }
         else {
             return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
         }

    }
    @PutMapping(path = "/comment")
    public ResponseEntity<Result> updateAccept(@RequestParam(value = "post_id")int post_id,@RequestParam(value = "user_id")int user_id){
         CommentId id = new CommentId();
         id.setUserid(user_id);
         id.setPostid(post_id);
         Comment comment = new Comment(id);
        int result = service.updateAccept(1,post_id,user_id);
        if(result==1){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(comment), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }

    }


}
