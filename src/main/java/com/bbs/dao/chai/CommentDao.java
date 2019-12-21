package com.bbs.dao.chai;

import com.bbs.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment,Integer> {
    @Query(value = "select * from comment where post_id=?1 order by comment_time desc ",nativeQuery = true)
    List<Comment> findCommentsByPostid(int postid);

    @Transactional
    @Modifying
    @Query(value = "delete from comment where post_id=?1",nativeQuery = true)
    int deleteCommentsByPostid(int postid);

    @Transactional
    @Modifying
    @Query(value = "insert into comment values (?1,?2,?3,?4,?5)",nativeQuery = true)
    int insertComments(int postid,int userid,String content,Date time,int accpet);

    @Transactional
    @Modifying
    @Query(value = "update comment set comment_acc =?1 where post_id=?2 and user_id=?3",nativeQuery = true)
    int updateAccept(int accept, int postid, int userid);



}
