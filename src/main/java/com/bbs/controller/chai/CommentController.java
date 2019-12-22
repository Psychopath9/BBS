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
import java.sql.Date;

@RestController
public class CommentController {
    @Autowired
    private CommentService service;

    @RequestMapping(value = "comment",method = RequestMethod.POST)
    public ResponseEntity<Result> addComment(HttpServletRequest request){
        int postid = Integer.parseInt(request.getParameter("post_id"));
        String content = request.getParameter("post__con");
        User user = (User)request.getSession().getAttribute("user");
        if(user==null){
            return new ResponseEntity<>(ResultFactory.buildResult(2001,"未登录不能进行评论", null),HttpStatus.OK);
        }
        int userid = user.getUserid();
        Comment comment = new Comment();
        CommentId id = new CommentId();
        id.setPostid(postid);
        id.setUserid(userid);
        comment.setId(id);
        comment.setContent(content);
        comment.setAccept(0);
         int result = service.insert(comment);
         if(result==1){
             return new ResponseEntity<>(ResultFactory.buildSuccessResult(comment), HttpStatus.OK);
         }
         else {
             return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
         }

    }
    @RequestMapping(value = "accept",method = RequestMethod.POST)
    public ResponseEntity<Result> updateAccept(HttpServletRequest request){
         int postid = Integer.parseInt(request.getParameter("post_id"));
         int userid= Integer.parseInt(request.getParameter("user_id"));
         int result = service.updateAccept(1,postid,userid);
        if(result==1){
            return new ResponseEntity<>(ResultFactory.buildResult(2012,"采纳成功", userid),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }

    }


}
