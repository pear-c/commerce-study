package com.example.commercestudy.domain.product;

import com.example.commercestudy.domain.vo.Price;
import com.example.commercestudy.domain.vo.Product;
import com.example.commercestudy.common.OffsetLimit;
import com.example.commercestudy.common.Page;
import com.example.commercestudy.storage.db.core.entity.ProductSectionEntity;
import com.example.commercestudy.storage.db.core.repository.ProductCategoryRepository;
import com.example.commercestudy.storage.db.core.repository.ProductRepository;
import com.example.commercestudy.storage.db.core.repository.ProductSectionRepository;
import enums.EntityStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductFinder {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public Page<Product> findByCategory(Long categoryId, OffsetLimit offsetLimit) {
        var categories = productCategoryRepository.findByCategoryIdAndStatus(categoryId, EntityStatus.ACTIVE, offsetLimit.toPageable());
        var products = productRepository.findAllById(
                categories.getContent().stream()
                        .map(category -> category.getProductId())
                        .toList()).stream()
                .map(entity -> new Product(
                        entity.getId(),
                        entity.getName(),
                        entity.getThumbnailUrl(),
                        entity.getDescription(),
                        entity.getShortDescription(),
                        new Price(
                                entity.getCostPrice(),
                                entity.getSalesPrice(),
                                entity.getDiscountedPrice()
                        )
                )).collect(Collectors.toList());

        return new Page<>(products, categories.hasNext());
    }
}