package com.ejemplo.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ejemplo.mvc.models.User;
import com.ejemplo.mvc.repository.UserRepository;

@Service("userService")
public class UserService {
	
    @Autowired
    @Qualifier("userRepository")
	private UserRepository userRepository;
    
    @Autowired
	private SequenceGeneratorService sequenceGeneratorService;
    
	
    //Retorna todos los usuarios
	public List<User> getList() {
		return userRepository.findAll();	
	}
	
	//Retorna usuario buscado por id
	public User getUser(Long id) {
		Optional<User> optUser = userRepository.findById(id);
		return optUser.isPresent() ? optUser.get() : null;
	}
	
	//Retorna usuario buscado por nombre
	public User getUser(String name) {
		User user = userRepository.findByName(name);
		return user;
	}
	
	//Guarda un usuario
	public void saveUser(User user) {
		//manejo de id
		user.setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
		userRepository.save(user);
	}
	
	//Actualiza un usuario
	public void updateUser(User user) {
		//manejo de id
		userRepository.save(user);
	}
	
	//Elimina un usuario
	public void updateUser(Long id) {
		//manejo de id
		userRepository.deleteById(id);
	}
	
	public int asignarPermisos(List<String> permisos, User user) {
		
		return 0;
	}
}
