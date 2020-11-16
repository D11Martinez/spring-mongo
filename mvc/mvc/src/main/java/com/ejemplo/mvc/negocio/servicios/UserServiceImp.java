package com.ejemplo.mvc.negocio.servicios;

import java.util.List;
import java.util.Optional;

import com.ejemplo.mvc.negocio.User;
import com.ejemplo.mvc.negocio.RepositorioInterface.UserRepositoryInterface;

public class UserServiceImp {

	private UserRepositoryInterface userRepositoryInt;
	
	public UserServiceImp(UserRepositoryInterface userRepositoryInt) {
		this.userRepositoryInt =  userRepositoryInt;
	}
	
	//Retorna todos los usuarios
	public List<User> getList() {
		return userRepositoryInt.findAll();	
	}
	
	//Retorna usuario buscado por id
	public User getUser(Long id) {
		Optional<User> optUser = userRepositoryInt.findById(id);
		return optUser.isPresent() ? optUser.get() : null;
	}
	
	//Retorna usuario buscado por nombre
	public User getUser(String name) {
		User user = userRepositoryInt.findByName(name);
		return user;
	}
	
	//Guarda un usuario
	public void saveUser(User user) {
		//manejo de id
		user.setId(userRepositoryInt.generateSequence());
		userRepositoryInt.save(user);
	}
	
	//Actualiza un usuario
	public void updateUser(User user) {
		//manejo de id
		userRepositoryInt.save(user);
	}
	
	//Elimina un usuario
	public void updateUser(Long id) {
		//manejo de id
		userRepositoryInt.deleteById(id);
	}
	
	public int asignarPermisos(List<String> permisos, User user) {
		
		return 0;
	}
}
