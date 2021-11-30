package com.demo.service.inter;

import com.demo.dto.ProductDTO;
import com.demo.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductServiceInter {

    List<ProductDTO> getAllProducts();

    ProductDTO getProduct(int id);

    Boolean deleteProduct(int id);

    Boolean deleteProductDetail(int id);
    @Transactional
    Boolean addAndUpdateProduct(Product product);

    Boolean deleteProductPhoto(int id);
}
