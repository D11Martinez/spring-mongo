package com.ejemplo.mvc.aplicacion.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.mvc.negocio.User;
import com.ejemplo.mvc.negocio.servicios.UserServiceImp;
import com.ejemplo.mvc.persistencia.RepositorioImp.UserRepositoryImp;

@Controller
@RequestMapping("/users")
public class UserController {
	//rutas a vistas (html)
	private String listHtml = "users/list";
	private String showHtml = "users/show";
	private String formHtml = "users/form";
	
	private UserServiceImp userServiceImp;
	
	public UserController(UserRepositoryImp userRepositoryImp) {
		this.userServiceImp = new UserServiceImp(userRepositoryImp);
	}		
	
	@GetMapping("")
	public String listUser(Model model) {
		
		model.addAttribute("users", userServiceImp.getList());
		
		return listHtml;
	}
	
	@GetMapping("/showuser/{id}")
	public String showUser(@PathVariable Long id, Model model) {
		
		User usuario = userServiceImp.getUser(id);

		model.addAttribute("usuario", usuario);
		
		return showHtml;
	}
	
	@GetMapping("/adduser")
	public String addUser(Model model) {
		
		User usuario = new User();
		
		model.addAttribute("usuario", usuario);
		
		return formHtml;
	}
	
	@PostMapping("/adduser")
	public String saveUser(User usuario, Model model) {
		//metodo para guardar el usuario
		userServiceImp.saveUser(usuario);

		model.addAttribute("usuario", new User());
		
		return formHtml;
	}
	
}
