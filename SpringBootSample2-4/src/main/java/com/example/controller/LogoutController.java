package com.example.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LogoutController {
	
	/** ログイン画面にリダイレクト */
	public String postLogout() {
		log.info("ログアウト");
		return "redirect:/login";
	}

}
