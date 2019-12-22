package com.bbs.service.chai;

import com.bbs.dao.chai.CommentDao;
import com.bbs.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDao dao;


    /**
     * 插入回复
     * @param comment
     * @return
     */
    public int insert(Comment comment){
        return dao.insertComments(comment.getId().getPostid(),comment.getId().getUserid(),comment.getContent(),comment.getId().getTime(),comment.getAccept());
    }
    /**
     * 采纳回复
     */
    public int updateAccept(int accept, int postid,int userid){
        return dao.updateAccept(accept,postid,userid);
    }
    /**
     * 根据 post_id查找评论
     * @param post_id
     * @return
     */
    public List<Comment> findCommentsByPostId(int post_id) {
        return dao.findCommentsByPostid(post_id);
    }
}
