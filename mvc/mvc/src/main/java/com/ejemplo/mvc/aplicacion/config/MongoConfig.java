package com.ejemplo.mvc.aplicacion.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ejemplo.mvc.negocio.User;
import com.ejemplo.mvc.persistencia.RepositorioMongo.UserRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class MongoConfig {

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		
		return new CommandLineRunner() {
			@Override
			public void run(String...strings) throws Exception{
				userRepository.save(new User(1L,"Peter", "Development", 3000L));
				userRepository.save(new User(2L,"Sam", "Operations", 2000L));
			}
		};
	}
}
