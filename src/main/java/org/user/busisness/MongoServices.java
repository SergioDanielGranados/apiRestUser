package org.user.busisness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.user.dao.mongo.entity.Neighbor;
import org.user.dao.mongo.entity.User;
import org.user.dao.mongo.repository.NeighborRepository;
import org.user.dao.mongo.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Clase de Service User Todo E Crud de User expuesto en servicio.
 *
 * @author Sergio
 * @version 1.0
 */

@Service
public class MongoServices {

  private final NeighborRepository neighborRepository;
  private final UserRepository userRepository;

  @Autowired
  public MongoServices(NeighborRepository neighborRepository, UserRepository userRepository) {
    this.neighborRepository = neighborRepository;
    this.userRepository = userRepository;
  }

  public Flux<Neighbor> getAllNeighbor() {
    // Fetch all records
    return neighborRepository.findAll();
  }
  /**
   * Suma dos números enteros.
   *
   * @param n El segundo número a sumar.
   * @return La suma de ambos números.
   */
  public Mono<Neighbor> save(Neighbor n) {
    // Fetch all records
    return neighborRepository.save(n);
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
    return userRepository.save(u);
  }

  /**
   * Eliminar usuario
   *
   * @param id Usuario para eliminar
   */
  public void deleteUser(String id) {
    userRepository.findById(id).flatMap(user -> userRepository.delete(user));
  }

  /**
   * Usuario para registrar
   *
   * @param id del Usuario para actualizar
   * @param userUpdate Usuario para actualizar
   * @return El usuario insertado
   */

  public Mono<User> updateUser(String id, User userUpdate) {

    return userRepository.findById(id).flatMap(user -> {
      user.setName(userUpdate.getName());
      user.setEmail(userUpdate.getEmail());
      user.setOrders(userUpdate.getOrders());
      return userRepository.save(user); });
  }

  /**
   * Usuario para Busqueda por ID
   *
   * @param id del Usuario para Buscar id
   * @return Usuario para Busqueda por ID
   */
  public Mono<User> getUser(String id) {
    return userRepository.findById(id);
  }

}
