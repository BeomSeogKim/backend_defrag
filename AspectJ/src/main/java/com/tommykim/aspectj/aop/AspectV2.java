package com.tommykim.aspectj.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class AspectV2 {

    @Pointcut("execution(* *..*ControllerV2.*(..))")
    public void Controller() { }

    @Pointcut("execution(* *..*ServiceV2.*(..))")
    public void Service(){ }

    @Pointcut("execution(* *..*RepositoryV2.*(..))")
    public void Repository(){}

    @Around("Controller()")
    public Object controllerLog(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("[controller] {} {} 실행", joinPoint.getSignature().getDeclaringType().getSimpleName(), joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

    @Around("Service()")
    public Object serviceLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[service] {} {} 실행", joinPoint.getSignature().getDeclaringType().getSimpleName(), joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }

    @Around("Repository()")
    public Object repositoryLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[repository] {} {} 실행", joinPoint.getSignature().getDeclaringType().getSimpleName(), joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }
}
