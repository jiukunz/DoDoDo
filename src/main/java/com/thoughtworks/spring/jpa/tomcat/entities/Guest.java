package com.thoughtworks.spring.jpa.tomcat.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by dwwang on 1/22/15.
 */
@Entity
public class Guest implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="GUEST_ID_GENERATOR")
    Long id;

    private String name;

    public String getName() {
        return name;
    }
    private Date signingDate;

    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return name + " (signed on " + signingDate + ")";
    }
}
