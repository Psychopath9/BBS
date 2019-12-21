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
    public void sava(PostTag postTag){
        postTagDao.save(postTag);
    }

    public void deleteByPostTagPostid(Integer postid){
        postTagDao.deleteByPostTagIdPostid(postid);
    }
}