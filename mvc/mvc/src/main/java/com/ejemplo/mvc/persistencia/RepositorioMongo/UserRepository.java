package com.ejemplo.mvc.persistencia.RepositorioMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ejemplo.mvc.negocio.User;

@Repository("userRepository")
public interface UserRepository extends MongoRepository<User, Long> {
	public abstract User findByName(String name);
}
