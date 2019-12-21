package com.bbs.service.chai;

import com.bbs.dao.chai.PostDao;
import com.bbs.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostDao dao;
    /**
     * 上传发布的帖子
     * @param user_id
     * @return
     */
     public int saveSubmitPost(int user_id, String post_title, String post_content, int post_top, int post_highli, Timestamp post_time, int view_number, int have_bonus, int post_point, int is_solved){
        return dao.saveSubmitPost(user_id,post_title,post_content,post_top,post_highli,post_time,view_number,have_bonus,post_point,is_solved);
    }
    /**
     * 根据帖子 id返回帖子信息
     * @param post_id
     * @return
     */
    public Post findByPostId(int post_id) {
        return dao.findByPostid(post_id);
    }
    /**
     * 更新内容
     * @param
     * @param
     * @return
     */
    public int updatePostContent(int post_id , String post_content){
        return dao.updatePostContent(post_id,post_content);
    }


}
