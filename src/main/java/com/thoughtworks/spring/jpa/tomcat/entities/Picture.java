package com.thoughtworks.spring.jpa.tomcat.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by qnxu on 1/27/15.
 */
@Entity
@Table(name = "picture")
public class Picture implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Column(name = "user_id")
    private Long user_id;
    private String caption;
    private String location;
    private String keyword;
    private Integer price;
    private Boolean visibility;
    private Timestamp createDate;
    private Timestamp modifyDate;

    public Picture(){}

    public Picture(String id, Long user_id, String caption, String location, String keyword, Integer price){
        this.id = id;
        this.user_id = user_id;
        this.caption = caption;
        this.location = location;
        this.keyword = keyword;
        this.price = price;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getVisibility() {
        return visibility;
    }

    public void setVisibility(Boolean visibility) {
        this.visibility = visibility;
    }
}
