package com.springbootproject.case3.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue(generator = "user", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user", sequenceName = "USER_ID_SEQ", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "PHONE_NUMBER", nullable = false, length =25)
    private String phoneNumber;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "USER_TYPE", nullable = false, length =20)
    private String usertype;
}
