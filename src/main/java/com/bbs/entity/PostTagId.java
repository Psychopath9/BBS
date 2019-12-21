package com.bbs.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class PostTagId implements Serializable {
    private static final long serialVersionUID = 2606793267849167078L;
    @Column(name = "post_id")
    private Integer postid;
    @Column(name = "tag_id")
    private Integer tagid;


    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public PostTagId() {
    }
    public PostTagId(Integer postid,Integer tagid) {
        this.postid = postid;
        this.tagid = tagid;
    }
    @Override
    public String toString() {
        return "PostTagId{" +
                "postid=" + postid +
                ", tagid=" + tagid +
                '}';
    }
}
