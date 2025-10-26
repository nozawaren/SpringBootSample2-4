package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AdminController { 
	/** アドミン権限専用画面に遷移 */ 
	@GetMapping("/admin") 
	public String getAdmin() { 
		return "admin/admin"; 
	} 
}
