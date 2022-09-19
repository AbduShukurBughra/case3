package com.springbootproject.case3.dao;

import com.springbootproject.case3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
