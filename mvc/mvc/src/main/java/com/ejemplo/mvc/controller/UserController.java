package com.ejemplo.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.mvc.models.User;
import com.ejemplo.mvc.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	//rutas a vistas (html)
	private String listHtml = "users/list";
	private String showHtml = "users/show";
	private String formHtml = "users/form";
	
    @Autowired
    @Qualifier("userService")
	private UserService userService;	
	
	@GetMapping("")
	public String listUser(Model model) {
		
		model.addAttribute("users", userService.getList());
		
		return listHtml;
	}
	
	@GetMapping("/showuser/{id}")
	public String showUser(@PathVariable Long id, Model model) {
		
		User usuario = userService.getUser(id);

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
		userService.saveUser(usuario);

		model.addAttribute("usuario", new User());
		
		return formHtml;
	}
	
}
