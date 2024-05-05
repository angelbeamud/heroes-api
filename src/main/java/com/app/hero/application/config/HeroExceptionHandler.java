package com.app.hero.application.config;

import com.app.hero.domain.exceptions.HeroException;
import com.app.hero.domain.exceptions.HeroNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HeroExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({HeroNotFoundException.class})
    public ResponseEntity<Object> handleHeroNotFoundException(HeroNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getErrorMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({HeroException.class})
    public ResponseEntity<Object> handleHeroException(HeroException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getErrorMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
