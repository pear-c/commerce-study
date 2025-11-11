package com.example.commercestudy.common.error;

import lombok.Getter;

@Getter
public class ExceptionDto {

    private final ErrorCode code;
    private final String message;

    public ExceptionDto(ErrorType errorType) {
        this.code = errorType.getCode();
        this.message = errorType.getMessage();
    }

    public static ExceptionDto of(ErrorType errorType) {
        return new ExceptionDto(errorType);
    }
}
