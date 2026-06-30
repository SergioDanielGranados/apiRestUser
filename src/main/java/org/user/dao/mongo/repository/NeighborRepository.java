package org.user.dao.mongo.repository;



import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.user.dao.mongo.entity.Neighbor;
import reactor.core.publisher.Mono;


@Repository
public interface NeighborRepository extends ReactiveMongoRepository<Neighbor, String> {

  Mono<Neighbor> findByName(String name);
}
