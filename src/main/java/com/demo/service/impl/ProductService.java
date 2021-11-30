package com.demo.service.impl;

import com.demo.dto.ProductDTO;
import com.demo.entity.Product;
import com.demo.repository.PhotosRepository;
import com.demo.repository.ProductRepository;
import com.demo.service.inter.ProductServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceInter {

    private final ProductRepository productRepository;

    private final PhotosRepository photosRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,  PhotosRepository photosRepository)
    {
        this.productRepository = productRepository;
        this.photosRepository = photosRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts()
    {
        try
        {
            List<ProductDTO> productDTOList = new ArrayList<>();
            productRepository.findAll().forEach(product -> productDTOList.add(new ProductDTO(product)));
            return productDTOList;
        }catch (Exception ex)
        {
            return new ArrayList<>();
        }
    }

    @Override
    public ProductDTO getProduct(int id)
    {
        try
        {
            return new ProductDTO(productRepository.findById(id).get());
        }catch (Exception ex)
        {
            return new ProductDTO();
        }
    }



    @Modifying
    @Override
    public Boolean addAndUpdateProduct(Product product)
    {
        try
        {
            productRepository.save(product);
            return true;
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean deleteProduct(int id)
    {
        try{
            Product product = productRepository.findById(id).get();
            productRepository.delete(product);

            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Boolean deleteProductDetail(int id)
    {
        try
        {
            Product product = productRepository.findById(id).get();
            product.setProductDetail(null);
            productRepository.save(product);

            return true;
        } catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public Boolean deleteProductPhoto(int id)
    {
        try
        {
            Product product = productRepository.findById(id).get();
            product.getPhoto().setImages(null);
            photosRepository.save(product.getPhoto());

            return true;
        } catch (Exception ex)
        {
            return false;
        }
    }



}
