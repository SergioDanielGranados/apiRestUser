package org.user.dao.mongo.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.user.dao.mongo.entity.User;


@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
