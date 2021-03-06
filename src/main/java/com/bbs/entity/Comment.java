package com.bbs.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private static final long serialVersionUID=15;
    /**
     * 复合主键
     */
    @EmbeddedId
    private  CommentId id;

    /**
     * 评论内容
     */
    @Column(name = "comment_con")
    private String content;
//    /**
//     * 评论时间
//     */
//    @Column(name = "comment_time")
//    private Timestamp time;
    /**
     * 标志位，评论是否被采纳
     */
    @Column(name = "comment_acc")
    private int accept;

    public Comment() {

    }
    public Comment(CommentId id,String content,int accept){
        this.id=id;
        this.content=content;
        this.accept =accept;

    }
    public Comment(CommentId id){
        this.id =id;
    }
    public CommentId getId() {
        return id;
    }

    public void setId(CommentId id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public Timestamp getTime() {
//        return time;
//    }
//
//    public void setTime(Timestamp time) {
//        this.time = time;
//    }

    public int getAccept() {
        return accept;
    }

    public void setAccept(int accept) {
        this.accept = accept;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", accept=" + accept +
                '}';
    }
}
