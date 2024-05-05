package com.app.hero.domain.exceptions;

import java.util.HashMap;
import java.util.Map;

public class HeroException extends BaseException {
    public HeroException(String errorCode, String message) {
        super(errorCode, message);
    }

    public HeroException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }

    @Override
    public Map<String, String> getErrorMessage() {
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("errorCode", this.getErrorCode());
        errorMessage.put("message", getMessage());
        return errorMessage;
    }
}