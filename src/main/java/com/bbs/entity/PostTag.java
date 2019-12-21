package com.bbs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "post_tag")
public class PostTag implements Serializable {
    private static final long serialVersionUID = 15;
    /**
     * 复合主键
     */
    @EmbeddedId
    private PostTagId postTagId;
//    @AttributeOverrides({
//            @AttributeOverride(name = "postid", column =  @Column(name = "post_id")),
//            @AttributeOverride(name = "tagid", column =  @Column(name = "tag_id"))
//    })

    public PostTagId getPostTagId() {
        return postTagId;
    }

    public void setPostTagId(PostTagId postTagId) {
        this.postTagId = postTagId;
    }

    public PostTag() {
    }
    public PostTag(PostTagId postTagId) {
        this.postTagId = postTagId;
    }

    @Override
    public String toString() {
        return "PostTag{" +
                "postTagId=" + postTagId +
                '}';
    }
}
/**
//    @Id
//    @Column(name = "post_id")
//    private Integer postid;
//    @Column(name = "tag_id")
//    private Integer tagid;
//
//    public Integer getPostid() {
//        return postid;
//    }
//
//    public void setPostid(Integer postid) {
//        this.postid = postid;
//    }
//
//    public Integer getTagid() {
//        return tagid;
//    }
//
//    public void setTagid(Integer tagid) {
//        this.tagid = tagid;
//    }
//
//    public PostTag() {
//    }
//
//    public PostTag(Integer postid, Integer tagid) {
//        this.postid = postid;
//        this.tagid = tagid;
//    }
//
//    @Override
//    public String toString() {
//        return "PostTag{" +
//                "postid=" + postid +
//                ", tagid=" + tagid +
//                '}';
//    }
**/
