package com.shashank.SpringBootEverything.repository;

import com.shashank.SpringBootEverything.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, Integer> {
    boolean existsByUserName(String userName);

    User findByUserName(String userName);
}
