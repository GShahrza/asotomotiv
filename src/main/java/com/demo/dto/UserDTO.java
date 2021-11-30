package com.demo.dto;

import com.demo.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;
    private String name;
    private String userName;
    private String password;
    private String email;
    private  PhotosDTO photosDTO;

    public UserDTO(Users users)
    {
        this.id = users.getId();
        this.name = users.getName();
        this.userName = users.getUserName();
        this.password = users.getPassword();
        this.email = users.getEmail();
        this.photosDTO = new PhotosDTO(users.getPhoto());
    }
}
