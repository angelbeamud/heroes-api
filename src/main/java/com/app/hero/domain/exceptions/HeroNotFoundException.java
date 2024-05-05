package com.app.hero.domain.exceptions;

public class HeroNotFoundException extends HeroException {
    public HeroNotFoundException(String errorCode, String message) {
        super(errorCode, message);
    }

    public HeroNotFoundException(String message, String errorCode, Throwable cause) {
        super(message, errorCode, cause);
    }
}
