package com.app.hero.application.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspect {
    private final Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspect.class);
    @Around("@annotation(com.app.hero.application.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        final Object proceed = joinPoint.proceed();
        final long executionTime = System.currentTimeMillis() - start;
        logger.info("{} executed in {} ms", joinPoint.getSignature().getName(), executionTime);
        return proceed;
    }
}
