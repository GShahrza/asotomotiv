package com.demo.dto;

import com.demo.entity.About;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class AboutDTO {

    private Integer id;
    private String text;
    private PhotosDTO photosDTO;

    public AboutDTO(About about){
        this.id = about.getId();
        this.text = about.getTexts();
        this.photosDTO = new PhotosDTO(about.getPhoto());
    }
}
