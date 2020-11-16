package com.ejemplo.mvc.aplicacion.recurso;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.mvc.negocio.User;
import com.ejemplo.mvc.negocio.servicios.UserServiceImp;
import com.ejemplo.mvc.persistencia.RepositorioImp.UserRepositoryImp;

@RestController
@RequestMapping("/rest/users")
public class UserResource {
	
	private UserServiceImp userServiceImp;
	
	public UserResource(UserRepositoryImp userRepositoryImp) {
		this.userServiceImp = new UserServiceImp(userRepositoryImp);
	}		
	
	@GetMapping("/all")
	public List<User> getAll() {		
		return userServiceImp.getList();
	}
}