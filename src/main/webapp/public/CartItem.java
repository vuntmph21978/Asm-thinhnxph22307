package com.spring.entity;

import lombok.*;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartItem {

    private Integer id;
    private String name;
    private double price;
    private String image;
    private int qty;

}