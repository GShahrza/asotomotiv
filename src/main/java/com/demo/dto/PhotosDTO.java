package com.demo.dto;

import com.demo.entity.Photos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PhotosDTO {

    private Integer id;
    private byte[] images;

    public PhotosDTO(Photos photo){
        this.id = photo.getId();
        this.images = photo.getImages();
    }
}
