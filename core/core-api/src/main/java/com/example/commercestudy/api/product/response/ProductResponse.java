package com.example.commercestudy.api.product.response;

import com.example.commercestudy.domain.vo.Product;
import com.example.commercestudy.storage.db.core.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class ProductResponse {
    private String name;
    private String thumbnailUrl;
    private String description;
    private String shortDescription;
    private BigDecimal costPrice;
    private BigDecimal salesPrice;
    private BigDecimal discountedPrice;

    public static List<ProductResponse> of(List<Product> products) {
        return products.stream()
                .map(product -> new ProductResponse(
                        product.getName(),
                        product.getThumbnailUrl(),
                        product.getDescription(),
                        product.getShortDescription(),
                        product.getPrice().getCostPrice(),
                        product.getPrice().getSalesPrice(),
                        product.getPrice().getDiscountedPrice()
                ))
                .collect(Collectors.toList());
    }
}
