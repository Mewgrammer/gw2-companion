package com.gw2companion.repositories;

import com.gw2companion.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByApiKey(String apiKey);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}