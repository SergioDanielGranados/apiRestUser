package org.user.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.user.mongo.entity.User;

@Slf4j
@Aspect
@Component
public class ListenerUserCreate {


  // Intercepts methods inside com.example.service package after a successful return
  @AfterReturning(
      pointcut = "execution(* org.user.busisness.MongoServices.saveUser(..))",
      returning = "result"
  )
  public void logAfterExecution(JoinPoint joinPoint,Object result) {
    // Get the executed method name
    //String methodName = joinPoint.getSignature().getName();
    // 1. Extract Input Parameters
    Object[] args = joinPoint.getArgs();
    User u = (User) args[0];
    System.out.println("Returned value: " + u.getUserId());
    log.info("Se inicia Envio de Id de usuario {}", u.getUserId());
  }

}
