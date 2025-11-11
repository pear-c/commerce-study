package com.example.commercestudy.storage.db.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "products")
public class ProductEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    private String thumbnailUrl;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String shortDescription;

    @Column(nullable = false)
    private BigDecimal costPrice;

    @Column(nullable = false)
    private BigDecimal salesPrice;

    @Column(nullable = false)
    private BigDecimal discountedPrice;
}
