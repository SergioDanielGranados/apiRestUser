package org.user.busisness;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.RabbitMQ.RabbitMqConfig;
import org.user.dao.mongo.repository.NeighborRepository;
import org.user.dao.mongo.repository.UserRepository;

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
    System.out.println("Message sent: " + message);
  }

}
