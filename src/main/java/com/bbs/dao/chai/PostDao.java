package com.bbs.dao.chai;

import com.bbs.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PostDao extends JpaRepository<Post,Integer> {
    @Query(value = "select * from post order by post_time desc ",nativeQuery = true)
    List<Post> findAllByPostTime();

    @Query(value = "select * from post order by view_number desc ",nativeQuery = true)
    List<Post> findAllByViewnumber();

    @Query(value = "select * from post where post_id=?1",nativeQuery = true)
    Post findByPostid(int post_id);

    @Query(value = "select * from post where post_highli = 1 order by post_time desc",nativeQuery = true)
    List<Post> findAllPostHighLightOrderByPostTimeDesc();

    @Query(value = "select * from post where post_title like %?1% order by post_time desc ",nativeQuery = true)
    List<Post> findByTitleLike(String title);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update post set post_highli = ?2 where post_id = ?1",nativeQuery = true)
    int updateHighLight(int post_id,int high);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update post set post_top = ?2 where post_id = ?1",nativeQuery = true)
    int updateTop(int post_id,int top);

    @Transactional
    @Modifying
    @Query(value = "delete from post where post_id = ?1",nativeQuery = true)
    int deleteByPostId(int post_id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "insert into post (user_id,post_title,post_content,post_top,post_highli,post_time,view_number,have_bonus,post_point,is_solved) values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10);",nativeQuery = true)
    int saveSubmitPost(int user_id, String post_title,String post_content,int post_top,int post_highli, Timestamp post_time,int view_number,int have_bonus,int post_point,int is_solved);

    @Transactional
    @Modifying
    @Query(value = "update post set post_content = ?2,post_title = ?3 where post_id = ?1",nativeQuery = true)
    int updatePostContent(int post_id , String post_content,String post_title);

    @Transactional
    @Modifying
    @Query(value = "update post set view_number = view_number + 1 where post_id = ?1",nativeQuery = true)
    int updatePostView(int post_id);

    @Query(value = "select view_number from post where post_id= ?1",nativeQuery = true)
    int findviewByPostid(int post_id);


}
