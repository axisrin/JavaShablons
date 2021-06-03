package com.example.practice14.models;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("within(com.example.practice14.services.UserService)")
    public void userMethods() {
    };

    @After("userMethods()")
    public void logMethodCall(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        LOGGER.info("Method's name is: " + methodName);
    }


    @AfterReturning(pointcut = "execution(public String com.example.practice14.services.UserService.*(..))"
            , returning = "result")
    public void logAfterReturning(JoinPoint jp, Object result) {
        LOGGER.info("Returning values are: " + result.toString());
    }

    @Around("@annotation(com.example.practice14.loggingAspect.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        long executionTime = System.currentTimeMillis() - start;
        LOGGER.info("Method " + pjp.getSignature() + " resulting for " + executionTime + " ms.");
        return proceed;
    }

}
