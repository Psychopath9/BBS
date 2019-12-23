package com.bbs.dao.shen;

import com.bbs.entity.PostTag;
import com.bbs.entity.PostTagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface PostTagDao extends JpaRepository<PostTag, PostTagId> {
//    @Query(value = "select * from post_tag where post_id = ?1",nativeQuery = true)
    public List<PostTag> findByPostTagIdPostid(Integer postid);
    public List<PostTag> findByPostTagIdTagid(Integer tagid);
    @Transactional
    public void deleteByPostTagIdPostid(Integer postid);
    @Transactional
    public void deleteByPostTagIdPostidAndPostTagIdTagid(Integer postid,Integer tagid);
}
