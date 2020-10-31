package com.ejemplo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	//rutas a vistas (html)
	private String homeHtml = "home";
	
	@RequestMapping("")
	public String listUser(Model model) {		
		return homeHtml;
	}
	
}
