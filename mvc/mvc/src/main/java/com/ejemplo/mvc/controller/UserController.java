package com.ejemplo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.mvc.models.User;
import com.ejemplo.mvc.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}		
	
	@GetMapping("/adduser")
	public String addUser(Model model) {
		User usuario = new User();
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	@PostMapping("/adduser")
	public String saveUser(User usuario, Model model) {
		//metodo para guardar el usuario
		userRepository.save(usuario);
		
		usuario = new User();
		model.addAttribute("usuario", usuario);
		
		return "form";
	}
	
}
