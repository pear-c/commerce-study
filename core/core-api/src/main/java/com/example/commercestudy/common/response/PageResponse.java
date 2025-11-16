package com.example.commercestudy.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> contents;
    private boolean hasNext;

    public static <T> PageResponse<T> of(List<T> contents, boolean hasNext) {
        return new PageResponse<>(contents, hasNext);
    }
}
