package com.thoughtworks.spring.jpa.tomcat.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "user_basic")
public class User implements Serializable{

    @Id
    @GeneratedValue(generator="user_seq_gen")
    @SequenceGenerator(name="user_seq_gen", sequenceName="USER_ID_GENERATOR")
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Timestamp createDate;
    private Timestamp modifyDate;
    private String status = "inactive";

    public User(){

    }

    public User(Long userId, String firstName, String lastName) {
        id = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public User withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User withCreateDate(Timestamp createDate) {
        this.createDate = createDate;
        return this;
    }

    public User withModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }

    public User withStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
