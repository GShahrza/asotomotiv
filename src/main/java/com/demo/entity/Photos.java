package com.demo.entity;

import com.demo.dto.PhotosDTO;
import lombok.*;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
public class Photos {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private byte[] images;

    @OneToMany(mappedBy = "photo")
    private List<Users> userList;

    @OneToOne( mappedBy = "photo")
    private Product product;
    @OneToOne(mappedBy = "photo")
    private Maintenance maintenance;
    @OneToOne( mappedBy = "photo")
    private About about;
    @OneToOne( mappedBy = "photo")
    private Contact contact;

    public Photos (PhotosDTO photosDTO){
        this.id = photosDTO.getId();
        this.images = photosDTO.getImages();
    }
    public Photos(Integer id,byte[]images){
        this.id=id;
        this.images=images;
    }
}
