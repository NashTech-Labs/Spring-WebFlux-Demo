package com.knoldus.webflux.entity;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Employee {

    @Id
    private Long id;
    private String name;
    private String address;
}
