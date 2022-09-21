package com.springbootproject.case3.controller;

import com.springbootproject.case3.dto.ProductDto;
import com.springbootproject.case3.entity.Product;
import com.springbootproject.case3.service.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductEntityService productEntityService;

//  •	Ürün kaydeden bir servis yazınız.
    @PostMapping("/product")
    public void saveProduct(@RequestBody Product product){
        productEntityService.save(product);
    }
//  •	Ürünleri listeleyebilen bir servis yazınız.

//  •	Ürün idsinden ürünü bulan bir servis yazınız.
    @GetMapping("/product/{id}")
    public Optional getProductById(Long id){
        Optional product = productEntityService.getProductById(id);
        return product;
    }

//  •	Ürün silen bir metot yazınız.
    @DeleteMapping("/product/{id}")
    public String deleteProductById(Long id){
        productEntityService.deleteProductById(id);
        return "Product is deleted...";
    }
//  •	Ürün fiyatı güncelleyen bir metot yazınız. (Sadece fiyat)
    @PutMapping("/product/{id}")
    public String updateProductPrice(@PathVariable Long id, @RequestBody ProductDto productDto){
        productEntityService.updateProductPrice(id, productDto );
        return "Product price is updated successfully";
    }

}
