package org.user.busisness;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.mongo.entity.User;
import org.user.mongo.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de Service User Todo E Crud de User expuesto en servicio.
 *
 * @author Sergio
 * @version 1.0
 */

@Slf4j
@Service
public class MongoServices {

  private final UserRepository userRepository;

  @Autowired
  public MongoServices(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * Regresa todos los usuarios.
   *
   * @return todos los usuarios.
   */
  public Flux<User> getAllUSers() {
    return userRepository.findAll();
  }

  /**
   * Usuario para registrar
   *
   * @param u Usuario para registrar
   * @return El usuario insertado
   */
  public Mono<User> saveUser(User u) {
    log.info("Creacion Usuario  in DB {} " ,u.getUserId());
    return userRepository.save(u);
  }

  /**
   * Eliminar usuario
   *
   * @param id Usuario para eliminar
   */
  public void deleteUser(String id) {
    userRepository.deleteById(id);
    userRepository.findById(id).flatMap(user -> userRepository.delete(user));
    userRepository.deleleUserById(id);
  }

  /**
   * Usuario para registrar
   *
   * @param userUpdate Usuario para actualizar
   * @return El usuario insertado
   */

  public Mono<User> updateUser(User userUpdate) {

    return userRepository.findById(userUpdate.getUserId()).flatMap(user -> {
      user.setName(userUpdate.getName());
      user.setEmail(userUpdate.getEmail());
      user.setOrders(userUpdate.getOrders());
      return userRepository.save(user);
    });
  }
  /**
   * Usuario para Busqueda por ID
   *
   * @param id del Usuario para Buscar id
   * @return Usuario para Busqueda por ID
   */
  public Mono<User> getUser(String id) {
    log.info("Obtencion Usuario  in DB Id {} ",id);
    return userRepository.findById(id);
  }

}
