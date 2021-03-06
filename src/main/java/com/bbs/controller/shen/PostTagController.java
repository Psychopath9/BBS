package com.bbs.controller.shen;

import com.bbs.entity.Post;
import com.bbs.entity.PostTag;
import com.bbs.entity.PostTagId;
import com.bbs.result.Result;
import com.bbs.result.ResultFactory;
import com.bbs.service.shen.PostTagService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostTagController {
    @Autowired
    private PostTagService postTagService;

    @GetMapping("/PostTag/{id}")
    public ResponseEntity<Result> findByPostTagIdPostid(@PathVariable(value = "id")Integer postid){
        List<PostTag> list = new ArrayList<>();
        list = postTagService.findByPostTagIdPostid(postid);
        if (list!=null){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(list), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(ResultFactory.buildFailResult("查找失败"), HttpStatus.OK);
        }
    }
    @GetMapping("/PostTag_2")
    public ResponseEntity<Result> findByPostTagIdTagid(@RequestParam(value = "tagid")Integer tagid){
        List<PostTag> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list = postTagService.findByPostTagIdTagid(tagid);
        for (PostTag postTag:list){
            list1.add(postTag.getPostTagId().getPostid());
        }
        if (list1.size()!=0){
            return new ResponseEntity<>(ResultFactory.buildSuccessResult(list1), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(ResultFactory.buildFailResult("查找失败"), HttpStatus.OK);
        }
    }
    @PostMapping("/PostTag")
    public ResponseEntity<Result> save(@RequestParam(value = "postid")Integer postid,@RequestParam(value = "tagid")Integer tagid){
        List<PostTag> list = new ArrayList<>();
        list = postTagService.findByPostTagIdPostid(postid);
        for (PostTag postTag:list) {
            if (postTag.getPostTagId().getPostid().equals(postid) && postTag.getPostTagId().getTagid().equals(tagid)){
                return new ResponseEntity<>(ResultFactory.buildFailResult("保存失败"), HttpStatus.OK);
            }
        }
        PostTagId postTagID = new PostTagId(postid,tagid);
        postTagService.sava(new PostTag(postTagID));
        return new ResponseEntity<>(ResultFactory.buildSuccessResult("成功"), HttpStatus.OK);
    }
    @DeleteMapping("/PostTag")
    public ResponseEntity<Result> deleteByPostTagIdPostid(@RequestParam(value = "postid")Integer postid){
        List<PostTag> list = new ArrayList<>();
        list = postTagService.findByPostTagIdPostid(postid);
        if (list!=null){
            postTagService.deleteByPostTagPostid(postid);
            return new ResponseEntity<>(ResultFactory.buildSuccessResult("成功"), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(ResultFactory.buildFailResult("删除失败"), HttpStatus.OK);
        }
    }
    @DeleteMapping("/PostTag_2")
    public ResponseEntity<Result> deleteByPostTagIdPostidAndPostTagIdTagid
            (@RequestParam(value = "postid")Integer postid,@RequestParam(value = "tagid")Integer tagid){
        List<PostTag> list = new ArrayList<>();
        list = postTagService.findByPostTagIdPostid(postid);
        for (PostTag postTag:list) {
            if (postTag.getPostTagId().getPostid().equals(postid) && postTag.getPostTagId().getTagid().equals(tagid)){
                postTagService.deleteByPostTagIdPostidAndPostTagIdTagid(postid, tagid);
                return new ResponseEntity<>(ResultFactory.buildFailResult("成功"), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(ResultFactory.buildFailResult("删除失败"), HttpStatus.OK);

//        if (list!=null){
//            postTagService.deleteByPostTagPostid(postid);
//            return new ResponseEntity<>(ResultFactory.buildSuccessResult("成功"), HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>(ResultFactory.buildFailResult("删除失败"), HttpStatus.OK);
//        }
    }
}
