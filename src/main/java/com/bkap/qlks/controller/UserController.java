package com.bkap.qlks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
@GetMapping("/tcn")
public String tcn() {
	return "trangcanhan";
}

@GetMapping("/histo")
public String histo() {
	return "lichsudatphong";
}

}
