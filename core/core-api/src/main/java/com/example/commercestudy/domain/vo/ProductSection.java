package com.example.commercestudy.domain.vo;

import enums.ProductSectionType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductSection {
    private ProductSectionType type;
    private String content;
}
