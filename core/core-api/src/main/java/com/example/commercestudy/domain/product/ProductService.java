package com.example.commercestudy.domain.product;

import com.example.commercestudy.domain.vo.Product;
import com.example.commercestudy.common.OffsetLimit;
import com.example.commercestudy.common.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductFinder productFinder;

    public PageResponse<Product> findProducts(Long categoryId, OffsetLimit offsetLimit) {
        return productFinder.findByCategory(categoryId, offsetLimit);
    }
}
