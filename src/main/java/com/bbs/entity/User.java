package com.bbs.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private int userid;
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String username;
    /**
     * 用户密码
     */
    @Column(name = "user_passwo")
    private String userpassword;
    /**
     * 用户联系方式
     */
    @Column(name = "user_phone")
    private String userphone;
    /**
     * 用户工作性质
     */
    @Column(name = "user_occu")
    private String useroccu;
    /**
     * 用户工作地点
     */
    @Column(name = "user_org")
    private String userorg;
    /**
     * 标志位，判断用户是否为管理员
     */
    @Column(name = "user_admin")
    private int useradmin;
    /**
     * 用户初始积分
     */
    @Column(name = "user_point")
    private  int userpoint;
    /**
     * 用户邮箱
     */
    @Column(name = "user_email")
    private String useremail;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseroccu() {
        return useroccu;
    }

    public void setUseroccu(String useroccu) {
        this.useroccu = useroccu;
    }

    public String getUserorg() {
        return userorg;
    }

    public void setUserorg(String userorg) {
        this.userorg = userorg;
    }

    public int getUseradmin() {
        return useradmin;
    }

    public void setUseradmin(int useradmin) {
        this.useradmin = useradmin;
    }

    public int getUserpoint() {
        return userpoint;
    }

    public void setUserpoint(int userpoint) {
        this.userpoint = userpoint;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                ", userphone='" + userphone + '\'' +
                ", useroccu='" + useroccu + '\'' +
                ", userorg='" + userorg + '\'' +
                ", useradmin=" + useradmin +
                ", userpoint=" + userpoint +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}
