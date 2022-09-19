package com.springbootproject.case3.entity;

import javax.persistence.*;

@Entity
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(generator = "Comment", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Comment", sequenceName = "COMMENT_ID_SEQ", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "TEXT", nullable = false,length = 2000)
    private String text;

    @Column(name = "USER_ID", nullable = false,length = 50)
    private Long userId;

    @Column(name = "PRODUCT_ID", nullable = false,length = 50)
    private Long productId;
}
