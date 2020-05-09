package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value = "/")
	public String dashboard() {
		return "dashboard";
	}
	
	
	@GetMapping(value = "/about")
	public String about() {
		return "about";
	}
	
	@GetMapping(value = "/contact")
	public String contact() {
		return "contact";
	}
}