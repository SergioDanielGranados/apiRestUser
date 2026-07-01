package org.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.user.busisness.MongoServices;
import org.user.busisness.ProducerService;
import org.user.dao.mongo.entity.User;
import reactor.core.publisher.Mono;

/**
 * Clase de ejemplo para demostración de Javadoc.
 *
 * @author Tu Nombre
 * @version 1.0
 */
@RestController
public class DataBaseTestController {

  private final MongoServices mongoServices;
  private final ProducerService producerService;

  /**
   * Suma dos números enteros.
   *
   * @param mongoServices El segundo número a sumar.
   * @return La suma de ambos números.
   */
  @Autowired
  private DataBaseTestController(MongoServices mongoServices, ProducerService producerService) {
    this.mongoServices =  mongoServices;
    this.producerService = producerService;
  }

  @PostMapping("/create")
  public Mono<User> createUser(@Validated @RequestBody User u) {
    return mongoServices.saveUser(u);
  }

  @GetMapping("/user/{id}")
  public Mono<ResponseEntity<User>> getUserById(@PathVariable(value = "id") String id) {
    return mongoServices.getUser(id)
        .map(user -> ResponseEntity.ok(user))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/userdel")
  public Mono<ResponseEntity<Void>> deleteUser(@RequestBody String id) {
    producerService.sendIdUser(id);
    //mongoServices.deleteUser(id);
    return Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT));

  }

  @PutMapping("/userup")
  public  Mono<ResponseEntity<User>> updateUser(@Validated @RequestBody User u) {
   // mongoServices.updateUser(u);
   return mongoServices.saveUser(u).map(user -> ResponseEntity.ok(user))
       .defaultIfEmpty(ResponseEntity.notFound().build());

  }

}
