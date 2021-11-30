package com.demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "contact")
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String textEmail;
    private String textPhone;
    private String textLocation;
    private String textFacebook;
    private String textTwitter;
    private String textInstagram;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id",referencedColumnName = "id")
    private Photos photo;

}
