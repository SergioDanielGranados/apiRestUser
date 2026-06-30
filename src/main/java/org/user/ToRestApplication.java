package org.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "org.user.dao.mongo.repository")
@EntityScan(basePackages = {"org.user.dao.mongo.entity"})
public class ToRestApplication {

  public static void main(String[] args) {
    SpringApplication
        .run(ToRestApplication.class, args);
  }

}
