package com.example.commercestudy.common.response;

import com.example.commercestudy.common.error.CustomException;
import com.example.commercestudy.common.error.ExceptionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private HttpStatus status;
    private ResultType resultType;
    private T data;
    private ExceptionDto error;

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(HttpStatus.OK, ResultType.SUCCESS, data, null);
    }

    public static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(HttpStatus.CREATED, ResultType.SUCCESS, data, null);
    }

    public static <T> ApiResponse<T> fail(CustomException e) {
        return new ApiResponse<>(e.getErrorType().getStatus(), ResultType.ERROR, null, ExceptionDto.of(e.getErrorType()));
    }
}
