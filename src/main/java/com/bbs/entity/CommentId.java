package com.bbs.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class CommentId implements Serializable {
    private static final long serialVersionUID = 2606793267849167078L;
    @Column(name = "post_id")
    private int postid;
    @Column(name = "user_id")
    private int userid;


    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
