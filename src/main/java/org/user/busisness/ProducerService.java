package org.user.busisness;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.RabbitMQ.RabbitMqConfig;
import org.user.RabbitMQ.UserUpdateOMqConfig;


/**
 * Clase de ejemplo para demostración de Javadoc.
 *
 * @author Tu Nombre
 * @version 1.0
 */
@Slf4j
@Service
public class ProducerService {


  private RabbitTemplate rabbitTemplate;

  @Autowired
  public ProducerService(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendIdUser(String message) {
    rabbitTemplate.convertAndSend(
        RabbitMqConfig.USER_EXCHANGE_NAME,
        RabbitMqConfig.USER_ROUTING_KEY,
        message
    );
    log.info("Mensaje Enviado Eliminacion usuario {} ",message);
  }


  public void sendIdUserToUpdateOrders(String message) {
    rabbitTemplate.convertAndSend(
        UserUpdateOMqConfig.USER_U_O_EXCHANGE_NAME,
        UserUpdateOMqConfig.USER_U_O_ROUTING_KEY,
        message
    );
    log.info("Mensaje Enviado Actualiar Usuario {} ",message);
  }

}
