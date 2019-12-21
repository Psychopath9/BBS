package com.bbs.controller.chai;

import com.bbs.entity.Comment;
import com.bbs.entity.User;
import com.bbs.result.Result;
import com.bbs.result.ResultFactory;
import com.bbs.service.chai.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@RestController
public class CommentController {
    @Autowired
    private CommentService service;

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public ResponseEntity<Result> insert(Comment comment, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if(user==null){
            return new ResponseEntity<>(ResultFactory.buildResult(2001,"未登录不能进行评论", null),HttpStatus.OK);
        }
         int result = service.insert(comment);
         if(result==1){
             return new ResponseEntity<>(ResultFactory.buildSuccessResult(comment), HttpStatus.OK);
         }
         else {
             return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
         }

    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ResponseEntity<Result> updateAccept(int accept, int postid, int userid,HttpServletRequest request){
        // postid = Integer.parseInt(request.getParameter("post_id"));
         //userid= Integer.parseInt(request.getParameter("user_id"));
         int result = service.updateAccept(1,postid,userid);
        if(result==1){
            return new ResponseEntity<>(ResultFactory.buildResult(2012,"采纳成功", userid),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }

    }


}
