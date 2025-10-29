package com.bkap.qlks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String loginUser() {
		return "login";
	}
	
	@GetMapping("/register")
	public String signinUser() {
		return "signin";
	}
	
}
