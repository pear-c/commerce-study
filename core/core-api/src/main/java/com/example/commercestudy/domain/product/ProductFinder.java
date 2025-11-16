package com.example.commercestudy.domain.product;

import com.example.commercestudy.domain.vo.Price;
import com.example.commercestudy.domain.vo.Product;
import com.example.commercestudy.common.response.OffsetLimit;
import com.example.commercestudy.common.response.Page;
import com.example.commercestudy.storage.db.core.entity.ProductCategoryEntity;
import com.example.commercestudy.storage.db.core.repository.ProductCategoryRepository;
import com.example.commercestudy.storage.db.core.repository.ProductRepository;
import enums.EntityStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductFinder {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    public Page<Product> findByCategory(Long categoryId, OffsetLimit offsetLimit) {

        // category 매핑 테이블 조회 (paging)
        Slice<ProductCategoryEntity> categories = productCategoryRepository.findByCategoryIdAndStatus(
                categoryId,
                EntityStatus.ACTIVE,
                offsetLimit.toPageable()
        );

        // 상품 ID 추출
        categories.getContent().stream()
                .map(ProductCategoryEntity::getProductCategoryId)


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