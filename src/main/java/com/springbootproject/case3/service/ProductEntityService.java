package com.springbootproject.case3.service;

import com.springbootproject.case3.dao.ProductDao;
import com.springbootproject.case3.dto.ProductDto;
import com.springbootproject.case3.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductEntityService {

    private final ProductDao productDao;
    public void save(Product product) {
        productDao.save(product);

    }

    public Optional getProductById(Long id) {
        Optional<Product> product = productDao.findById(id);
        return product;
    }

    public void deleteProductById(Long id) {
      productDao.deleteById(id);
    }

    public void updateProductPrice(Long id, ProductDto productDto) {
        //1. id arkilik product ni tapimiz, buning ismini productFromDb
        Optional<Product> productFromDb = productDao.findById(id);

        if(productFromDb.isPresent()) {
            //2. product diki uchurni elip productFromDb ning ustige saklaymiz
            Product productNew = new Product();
            productNew.setId(id);
            productNew.setName(productFromDb.get().getName());//chushenmidim
            productNew.setPrice(productDto.getPrice());
            productDao.save(productNew);
        }else {
            throw new NotFoundException(" id si"+id+" olan product database ta mevcut degil");
        }
    }
}
