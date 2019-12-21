package com.bbs.entity;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "post")
public class Post {
    /**
     * 帖子ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int postid;
    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private int userid;
    /**
     * 帖子标题
     */
    @Column(name = "post_title")
    private String posttitle;
    /**
     * 用户内容
     */
    @Column(name = "post_content")
    private String postcontent;
    /**
     * 标志位，帖子是否置顶
     */
    @Column(name = "post_top")
    private int posttop;
    /**
     * 标志位，帖子是否加精
     */
    @Column(name = "post_highli")
    private int highli;
    /**
     * 帖子发布时间
     */
    @Column(name = "post_time")
    private Date posttime;
    /**
     * 帖子浏览数量
     */
    @Column(name = "view_number")
    private int viewnumber;
    /**
     * 标志位，帖子是否悬赏
     */
    @Column(name = "have_bonus")
    private int bonus;
    /**
     * 帖子积分
     */
    @Column(name = "post_point")
    private int postpoint;
    /**
     * 标志位，需求是否已被解决
     */
    @Column(name = "is_solved")
    private int issolved;

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

    public String getPosttitle() {
        return posttitle;
    }

    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
    }

    public String getPostcontent() {
        return postcontent;
    }

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent;
    }

    public int getPosttop() {
        return posttop;
    }

    public void setPosttop(int posttop) {
        this.posttop = posttop;
    }

    public int getHighli() {
        return highli;
    }

    public void setHighli(int highli) {
        this.highli = highli;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public int getViewnumber() {
        return viewnumber;
    }

    public void setViewnumber(int viewnumber) {
        this.viewnumber = viewnumber;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getPostpoint() {
        return postpoint;
    }

    public void setPostpoint(int postpoint) {
        this.postpoint = postpoint;
    }

    public int getIssolved() {
        return issolved;
    }

    public void setIssolved(int issolved) {
        this.issolved = issolved;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postid +
                ", userid=" + userid +
                ", posttitle='" + posttitle + '\'' +
                ", postcontent='" + postcontent + '\'' +
                ", posttop=" + posttop +
                ", highli=" + highli +
                ", posttime=" + posttime +
                ", viewnumber=" + viewnumber +
                ", bonus=" + bonus +
                ", postpoint=" + postpoint +
                ", issolved=" + issolved +
                '}';
    }
}
