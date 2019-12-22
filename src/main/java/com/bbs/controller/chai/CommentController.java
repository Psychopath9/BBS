package com.bbs.controller.chai;

import com.bbs.entity.Comment;
import com.bbs.entity.CommentId;
import com.bbs.result.Result;
import com.bbs.result.ResultFactory;
import com.bbs.service.chai.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService service;


    @PostMapping(path = "/comment")
    public ResponseEntity<Result> addComment(int post_id, String content, int userid) {


        CommentId id = new CommentId();
        id.setPostid(post_id);
        id.setUserid(userid);
        id.setTime(new Timestamp(System.currentTimeMillis()));
        Comment comment = new Comment(id, content, 0);
        int result = service.insert(comment);
        if (result == 1) {
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(comment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }

    }

    @PutMapping(path = "/comment")
    public ResponseEntity<Result> updateAccept(@RequestParam(value = "post_id") int post_id, @RequestParam(value = "user_id") int user_id) {
        CommentId id = new CommentId();
        id.setUserid(user_id);
        id.setPostid(post_id);
        Comment comment = new Comment(id);
        int result = service.updateAccept(1, post_id, user_id);
        if (result == 1) {
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(comment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }

    }
    @GetMapping(path="/comment/{id}")
    public ResponseEntity<Result> GetComment(@PathVariable("id")int id){
        List<Comment> list = service.findCommentsByPostId(id);
        if (list!=null){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(list), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(ResultFactory.buildFailResult("查找失败"), HttpStatus.OK);
        }
    }
}
