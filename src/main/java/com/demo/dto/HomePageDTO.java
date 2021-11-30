package com.demo.dto;

import com.demo.entity.HomePage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HomePageDTO {

    private Integer id;
    private String headerName;
    private PhotosDTO photosDTO;

    public HomePageDTO(HomePage homePage)
    {
        this.id = homePage.getId();
        this.headerName = homePage.getHeaderName();
        this.photosDTO = new PhotosDTO(homePage.getPhoto());
    }

}
