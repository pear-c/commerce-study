package com.example.commercestudy.api.product.controller;

import com.example.commercestudy.api.product.response.ProductResponse;
import com.example.commercestudy.domain.product.ProductService;
import com.example.commercestudy.common.OffsetLimit;
import com.example.commercestudy.common.response.ApiResponse;
import com.example.commercestudy.common.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ApiResponse<PageResponse<ProductResponse>> findProducts(@RequestParam Long categoryId,
                                                                   @RequestParam int offset,
                                                                   @RequestParam int limit) {

        var result = productService.findProducts(categoryId, new OffsetLimit(offset, limit));

        PageResponse<ProductResponse> pageResponse = new PageResponse<>(
                ProductResponse.of(result.getContents()),
                result.isHasNext()
        );

        return ApiResponse.ok(pageResponse);
    }
}
