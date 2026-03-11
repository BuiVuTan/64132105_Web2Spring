package vn.edu.nha.HelloSpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	@GetMapping("/")
	public String trangChu() {
		return "index";
	}
}
