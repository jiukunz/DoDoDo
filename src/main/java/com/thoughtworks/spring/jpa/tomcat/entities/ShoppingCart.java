package com.thoughtworks.spring.jpa.tomcat.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "shopping_car")
public class ShoppingCart {
    @Id
    @GeneratedValue(generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "USER_ID_GENERATOR")
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "pic_id")
    private String picId;
    private Timestamp createDate;
    private Timestamp modifyDate;

    public ShoppingCart withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public ShoppingCart withPicId(String picId) {
        this.picId = picId;
        return this;
    }

    public ShoppingCart withCreateDate(Timestamp createDate) {
        this.createDate = createDate;
        return this;
    }

    public ShoppingCart withModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
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


}
