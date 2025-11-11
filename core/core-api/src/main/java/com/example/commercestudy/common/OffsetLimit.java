package com.example.commercestudy.common;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public record OffsetLimit(int offset, int limit) {
    public Pageable toPageable() {
        int page = offset / limit;
        return PageRequest.of(page, limit);
    }
}
