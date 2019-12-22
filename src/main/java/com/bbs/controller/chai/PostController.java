package com.bbs.controller.chai;

import com.bbs.entity.Post;
import com.bbs.entity.User;
import com.bbs.result.Result;
import com.bbs.result.ResultFactory;
import com.bbs.service.chai.PostService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService service;

    /**
     * 发布帖子
     * @param title
     * @param userid
     * @param content
     * @param point
     * @return
     */
    @PostMapping(path = "/post")
    public ResponseEntity<Result> submitpost(@RequestParam(value = "post_title")String title,@RequestParam(value = "user_id")int userid,@RequestParam(value = "post_content")String content,@RequestParam(value = "post_point")int point,@RequestParam(value = "have_bonus")int have_bonus){
        int post_top = 0;
        int post_highli = 0;
        int view_number = 0;
        int is_solved = 0;
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Post post  = new Post(userid,title,content,post_top,post_highli,time,view_number,have_bonus,point,is_solved);
        int res = service.saveSubmitPost(userid,title,content,post_top,post_highli,time,view_number,have_bonus,point,is_solved);
        if(res==1){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(post), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }

    }



    /**
     * 根据post_id查询帖子内容
     * @param post_id
     * @return
     */
    @GetMapping(path = "/post/{post_id}")
    public ResponseEntity<Result> findpostByPostid(@PathVariable(value = "post_id")int post_id){
        Post post = service.findByPostId(post_id);
        if(post!=null){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(post), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }

    /**
     * 根据post_title模糊查询
     * @param title
     * @return
     */
    @GetMapping(path = "/posttitle")
    public ResponseEntity<Result> findByTitleLike(@RequestParam(value = "post_title")String title){
        List<Post> list = service.findByTitleLike(title);
        if(list!=null){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(list), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }
    /**
     * 根据时间降序返回所有帖子
     * @return
     */
    @GetMapping(path = "/postAllbytime")
    public ResponseEntity<Result> findAllpostBytime(){
        List<Post> post = service.findAllByPostTime();
        if(post!=null){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(post), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }

    /**
     * 根据时间降序返回所有加精帖子
     * @return
     */
    @GetMapping(path = "/posthighbytime")
    public ResponseEntity<Result> findAllhigh(){
        List<Post> list = service.findAllPostHighLi();
        if(list!=null){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(list), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }

    /**
     * 根据浏览数降序返回帖子
     * @return
     */
    @GetMapping(path = "/postAllbynum")
    public ResponseEntity<Result> findByViewnumber(){
        List<Post> post = service.findAllByViewnumber();
        if(post!=null){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(post), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }



    /**
     * 根据post_id更新帖子内容
     * @param post_id
     * @param content
     * @return
     */
    @PutMapping(path = "/post")
    public ResponseEntity<Result> update(@RequestParam(value = "post_id")int post_id,@RequestParam(value = "post_content")String content){
        int res = service.updatePostContent(post_id,content);
        Post post = new Post(post_id,content);
        if(res==1){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(post), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }

    /**
     * 根据post_id删除帖子(管理员操作)
     * @param post_id
     * @return
     */
    @DeleteMapping(path = "/post")
    public ResponseEntity<Result> delete(@RequestParam(value = "post_id")int post_id){
        int res = service.deleteByPostId(post_id);
        if(res==1){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult("删除成功"), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }

    /**
     * 帖子置顶
     * @param post_id
     * @return
     */
    @PutMapping(path = "/posttop")
    public ResponseEntity<Result> updatetop(@RequestParam(value = "post_id")int post_id){
        Post post = service.findByPostId(post_id);
        int res;
        if(post.getPosttop()==0){
            res = service.updateTop(post_id,1);
        }
        else{
            res = service.updateTop(post_id,0);
        }

        if(res==1){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult("修改成功"), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }

    /**
     * 帖子加精
     * @param post_id
     * @return
     */
    @PutMapping(path = "/posthigh")
    public ResponseEntity<Result> updatehigh(@RequestParam(value = "post_id")int post_id){
        Post post = service.findByPostId(post_id);
        int res;
        if(post.getHighli()==0){
            res = service.updateHighLight(post_id,1);
        }
        else {
            res = service.updateHighLight(post_id,0);
        }
        if(res==1){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult("修改成功"), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }
    @PutMapping(path = "/postview/{post_id}")
    public ResponseEntity<Result> updateview(@PathVariable("post_id")int post_id){
        int res = service.updatePostView(post_id);
        int view = service.findviewByPostid(post_id);
        if(res==1){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(view), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(ResultFactory.buildFailResult("失败"), HttpStatus.OK);
        }
    }



}
