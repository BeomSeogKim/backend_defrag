package com.tommykim.aspectj.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class AspectV1 {

    @Around("execution(* *..*ControllerV1.*(..))")
    public Object controllerLog(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("[controller] {} {} 실행", joinPoint.getSignature().getDeclaringType().getSimpleName(), joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

    @Around("execution(* *..*ServiceV1.*(..))")
    public Object serviceLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[service] {} {} 실행", joinPoint.getSignature().getDeclaringType().getSimpleName(), joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

    @Around("execution(* *..*RepositoryV1.*(..))")
    public Object repositoryLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[repository] {} {} 실행", joinPoint.getSignature().getDeclaringType().getSimpleName(), joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }
}
