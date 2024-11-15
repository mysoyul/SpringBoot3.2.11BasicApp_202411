package com.basic.myspringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    //Primary Key
    @Id  
    //PK의 sequential 한 값 자동 증가 전략
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "cust_id")
    private String customerId;

    @Column(nullable = false, name = "cust_name")
    private String customerName;
}
