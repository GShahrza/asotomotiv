package com.demo.controller;

import com.demo.dto.ProductDTO;
import com.demo.entity.Product;
import com.demo.service.inter.ProductServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/product")
public class ProductRestController {

    private final ProductServiceInter productService;

    @Autowired
    public ProductRestController(ProductServiceInter productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public Boolean addProduct(@RequestBody Product product){
        System.out.println(product);
//        product.setId(73);
//        product.getPhoto().setId(68);
        return productService.addAndUpdateProduct(product);
    }

    @GetMapping("/getAll")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getProduct/{id}")
    public ProductDTO getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @DeleteMapping ("/delete/{id}")
    public Boolean deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }

    @DeleteMapping("/delete/detail/{id}")
    public Boolean deleteProductDetail(@PathVariable int id){
        return productService.deleteProductDetail(id);
    }

    @DeleteMapping("/delete/photo/{id}")
    public Boolean deleteProductPhoto(@PathVariable int id){
        return productService.deleteProductPhoto(id);
    }
}
