package com.bbs.dao.chai;

import com.bbs.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends JpaRepository<Post,Integer> {
    @Query(value = "select * from post order by post_time desc ",nativeQuery = true)
    List<Post> findAllByPostTime();

    @Query(value = "select * from post order by view_number desc ",nativeQuery = true)
    List<Post> findAllByViewnumber();
}
