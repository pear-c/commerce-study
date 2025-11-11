package com.example.commercestudy.common.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException {
  private final ErrorType errorType;

  public String getMessage() {
    return errorType.getMessage();
  }
}
