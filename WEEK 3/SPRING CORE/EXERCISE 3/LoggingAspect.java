package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.library..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object returnValue = joinPoint.proceed();
        long duration = System.currentTimeMillis() - startTime;

        System.out.println("Method [" + joinPoint.getSignature() + "] executed in " + duration + " ms");
        return returnValue;
    }
}

