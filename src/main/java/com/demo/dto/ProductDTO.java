package com.demo.dto;

import com.demo.entity.Product;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDTO {

    private Integer id;
    private String productName;
    private String productDetail;
    private PhotosDTO photosDTO;

    public ProductDTO(Product product){
        this.id = product.getId();
        this.productName = product.getProductName();
        this.productDetail = product.getProductDetail();
        this.photosDTO = new PhotosDTO(product.getPhoto());
    }

}
