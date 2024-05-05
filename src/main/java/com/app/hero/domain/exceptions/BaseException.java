package com.app.hero.domain.exceptions;

import lombok.Getter;

import java.util.Map;

@Getter
abstract class BaseException extends RuntimeException {
    private final String errorCode;

    protected BaseException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    protected BaseException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    abstract Map<String, String> getErrorMessage();
}
