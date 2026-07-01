package org.user.busisness;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.RabbitMQ.RabbitMqConfig;

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
    log.debug("Mensaje Enviado {} ",message);
  }

}
