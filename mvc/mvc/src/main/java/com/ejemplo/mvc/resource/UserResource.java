package com.ejemplo.mvc.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.mvc.models.User;
import com.ejemplo.mvc.repository.UserRepository;

@RestController
@RequestMapping("/rest/users")
public class UserResource {
	
	private UserRepository userRepository;
	
	public UserResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}		
	
	@GetMapping("/all")
	public List<User> getAll() {		
		return userRepository.findAll();
	}
}