package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	//** ログイン画面を表示 */
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}
	/** login.html内のactionタグに記載している/loginと連携してpostrequestを受け取り処理を行う */
	/** ユーザー一覧画面にリダイレクト */
	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/user/list";
	}

}
