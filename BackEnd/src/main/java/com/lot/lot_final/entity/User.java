package com.lot.lot_final.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @Column(name="name")
    public String name;
    @Column(name="password")
    public int password;
    @Column(name="type")
    public int type;
    public int getId()
    {
        return id;
    }
}
