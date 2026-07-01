package org.user.dao.mongo.repository;


import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import org.user.dao.mongo.entity.User;
import reactor.core.publisher.Mono;


@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

  @DeleteQuery("{ '_id' : ?0 } }")
  Mono<Void> deleleUserById(String id);

}
