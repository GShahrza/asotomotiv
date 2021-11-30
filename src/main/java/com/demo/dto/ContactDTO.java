package com.demo.dto;

import com.demo.entity.Contact;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ContactDTO {

    private Integer id;
    private String textEmail;
    private String textPhone;
    private String textLocation;
    private String textFacebook;
    private String textTwitter;
    private String textInstagram;
    private PhotosDTO photosDTO;

    public ContactDTO(Contact contact){
        this.id = contact.getId();
        this.textEmail = contact.getTextEmail();
        this.textPhone = contact.getTextPhone();
        this.textLocation = contact.getTextLocation();
        this.textFacebook = contact.getTextFacebook();
        this.textTwitter = contact.getTextTwitter();
        this.textInstagram = contact.getTextInstagram();
        this.photosDTO = new PhotosDTO(contact.getPhoto());
    }

}
