package com.bbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {
    /**
     * 标签ID
     */
    @Id
    @Column(name = "tag_id")
    private int tagid;
    /**
     * 标签名
     */
    @Column(name = "tag_name")
    private String tagname;

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagid=" + tagid +
                ", tagname='" + tagname + '\'' +
                '}';
    }
}
