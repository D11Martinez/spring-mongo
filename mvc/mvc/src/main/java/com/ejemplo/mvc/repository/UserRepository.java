package com.ejemplo.mvc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.mvc.models.User;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, Integer> {

}
