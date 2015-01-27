package com.thoughtworks.spring.jpa.tomcat.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by qnxu on 1/27/15.
 */
@Entity
@Table(name = "picture")
public class Picture implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="user_seq_gen")
    @SequenceGenerator(name="user_seq_gen", sequenceName="USER_ID_GENERATOR")
    private Long id;
    private String pictureName;
    private String pictureDescription;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getPictureName(){
        return pictureName;
    }
    public void setPictureName(String pictureName){
        this.pictureName = pictureName;
    }
    public String getPictureDescription(){
        return pictureDescription;
    }
    public void setPictureDescription(String pictureDescription){
        this.pictureDescription = pictureDescription;
    }

}
