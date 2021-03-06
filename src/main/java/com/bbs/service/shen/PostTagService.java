package com.bbs.service.shen;

import com.bbs.dao.shen.PostTagDao;
import com.bbs.entity.PostTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostTagService {
    @Autowired
    private PostTagDao postTagDao;

    public List<PostTag> findByPostTagIdPostid(Integer postid){
        return postTagDao.findByPostTagIdPostid(postid);
    }
    public List<PostTag> findByPostTagIdTagid(Integer tagid){
        return postTagDao.findByPostTagIdTagid(tagid);
    }
    public void sava(PostTag postTag){
        postTagDao.save(postTag);
    }

    public void deleteByPostTagPostid(Integer postid){
        postTagDao.deleteByPostTagIdPostid(postid);
    }

    public void deleteByPostTagIdPostidAndPostTagIdTagid(Integer postid,Integer tagid){
        postTagDao.deleteByPostTagIdPostidAndPostTagIdTagid(postid,tagid);
    }
}