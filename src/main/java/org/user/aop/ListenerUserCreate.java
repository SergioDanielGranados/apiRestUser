package org.user.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.user.dao.mongo.entity.User;

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
  }

}
