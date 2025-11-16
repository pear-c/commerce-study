package com.example.commercestudy.domain.vo;

import com.example.commercestudy.storage.db.core.entity.ProductEntity;
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

    public static Product fromEntity(ProductEntity entity) {
        return new Product(
                entity.getProductId(),
                entity.getProductName(),
                entity.getThumbnailUrl(),
                entity.getDescription(),
                entity.getShortDescription(),
                new Price(
                        entity.getCostPrice(),
                        entity.getSalesPrice(),
                        entity.getDiscountedPrice()
                )
        );
    }
}
