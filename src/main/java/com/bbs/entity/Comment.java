package com.bbs.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private static final long serialVersionUID=15;
    /**
     * 帖子ID
     */
    @Id
    @JoinColumn(name = "post_id")
    private int postid;
    /**
     * 用户ID
     */
    @Id
    @JoinColumn(name = "user_id")
    private int userid;
    /**
     * 评论内容
     */
    @Column(name = "comment_con")
    private String content;
    /**
     * 评论时间
     */
    @Column(name = "comment_time")
    private String time;
    /**
     * 标志位，评论是否被采纳
     */
    @Column(name = "comment_acc")
    private int accept;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "postid=" + postid +
                ", userid=" + userid +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", accept=" + accept +
                '}';
    }
}
