package com.example.commercestudy.common.advice;

import com.example.commercestudy.common.error.CustomException;
import com.example.commercestudy.common.error.ErrorType;
import com.example.commercestudy.common.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LogLevel;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public ApiResponse<?> handleCustomEsception(CustomException e) {
        LogLevel logLevel = e.getErrorType().getLogLevel();

        switch (logLevel) {
            case ERROR -> log.error("CoreException : {}", e.getMessage(), e);
            case WARN -> log.warn("CoreException : {}", e.getMessage(), e);
            default -> log.info("CoreException : {}", e.getMessage(), e);
        }
        return ApiResponse.fail(e);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleException(Exception e) {
        log.error("Exception : {}", e.getMessage(), e);
        return ApiResponse.fail(new CustomException(ErrorType.DEFAULT_ERROR));
    }
}
