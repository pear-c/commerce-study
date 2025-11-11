package com.example.commercestudy.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Page<T> {
    private List<T> content;
    private Boolean hasNext;
}
