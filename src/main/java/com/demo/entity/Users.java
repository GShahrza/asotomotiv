package com.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "user_details")
@ToString
public class Users {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private String userName;
    private String password;
    private String email;
    @ManyToOne
    @JoinColumn(name = "photo_id",referencedColumnName = "id")
    private Photos photo;
}
