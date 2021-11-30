package com.demo.entity;

import com.demo.dto.ProductDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString

@Entity
public class Product {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private String productDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id",referencedColumnName = "id")
    private Photos photo;

    public Product (ProductDTO productDTO)
    {
        this.id = productDTO.getId();
        this.productName = productDTO.getProductName();
        this.productDetail = productDTO.getProductDetail();
        this.photo = new Photos(productDTO.getPhotosDTO());

    }



}
