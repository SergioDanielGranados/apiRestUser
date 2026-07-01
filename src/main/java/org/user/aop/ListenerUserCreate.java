package org.user.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.user.busisness.ProducerService;
import org.user.mongo.entity.User;

/**
 * Clase Aspect que esta Escuchando la ejecucion del metodo de creacion de usuario en Mongo
 *
 * @author SDGA
 * @version 1.0
 */

@Slf4j
@Aspect
@Component
public class ListenerUserCreate {


  private final ProducerService producerService;

  @Autowired
  public ListenerUserCreate(ProducerService producerService) {
    this.producerService = producerService;
  }

  /**
   * Suma dos números enteros.
   *
   * @param joinPoint metodos name  and parameter in.
   * @param result response of method.

   */
  @AfterReturning(
      pointcut = "execution(* org.user.busisness.MongoServices.saveUser(..))",
      returning = "result"
  )
  public void logAfterExecution(JoinPoint joinPoint,Object result) {
    Object[] args = joinPoint.getArgs();
    User u = (User) args[0];
    log.info("Se inicia Envio de Id de usuario {}", u.getUserId());
    producerService.sendIdUserToUpdateOrders(u.getUserId());
    log.info("usuario Id enviado {}", u.getUserId());
  }

}
