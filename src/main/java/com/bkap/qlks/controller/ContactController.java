package com.bkap.qlks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

	@GetMapping("/contact")
	public String lh() {
		return "lienhe";
	}
	
	@GetMapping("/blog")
	public String tt() {
		return "tintuc";
	}
}

