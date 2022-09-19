package com.springbootproject.case3.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "Products")
@Data
public class Product {
    @Id
    @GeneratedValue(generator = "product", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product", sequenceName = "PRODUCT_ID_SEQ", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "PRICE", nullable = false, length = 100)
    private Long price;
}
