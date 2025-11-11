package com.example.commercestudy.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String thumbnailUrl;
    private String description;
    private String shortDescription;
    private Price price;
}
