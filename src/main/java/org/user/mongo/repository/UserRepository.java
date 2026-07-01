package org.user.mongo.repository;


import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.user.mongo.entity.User;
import reactor.core.publisher.Mono;


@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

  @DeleteQuery("{ '_id' : ?0 } }")
  Mono<Void> deleleUserById(String id);

}
