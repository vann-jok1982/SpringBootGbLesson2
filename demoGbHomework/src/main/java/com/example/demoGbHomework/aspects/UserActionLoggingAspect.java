package com.example.demoGbHomework.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserActionLoggingAspect {

    @After("@annotation(TrackUserAction)")
    public void logUserAction(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        // Предположим, что данные о пользователе находятся в сессии или контексте
        String username = "текущий пользователь";

        System.out.println("Метод вызван: " + methodName);
        System.out.println("Параметры: " + Arrays.toString(args));
        System.out.println("Пользователь: " + username);
        System.out.println("----------");
    }
}