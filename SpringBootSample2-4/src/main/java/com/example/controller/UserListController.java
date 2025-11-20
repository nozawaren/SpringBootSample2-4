package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.UserListForm;

@Controller
@RequestMapping("/user")
public class UserListController {

	//UserService userService = new UserServiceのインスタンスの生成を省略することができる
	//また、同名インターフェースを別クラスで作成した際にインスタンスの切替が簡単になる
	@Autowired
	private UserService userService;

	//ModelMapper modelMapper = new ModelMapperのインスタンスの生成を省略することができる
	//また、同名インターフェースを別クラスで作成した際にインスタンスの切替が簡単になる
	@Autowired 
	private ModelMapper modelMapper;

	/** ユーザー一覧画面を表示 */
	/** list.htmlにてactionが/user/updateの呼び出しが発生した際にユーザ検索処理を実行しユーザ一覧画面を表示する */
	/** getリクエストの場合、userIdの入力がないため全件検索が行われる */
	@GetMapping("/list")
	public String getUserList(@ModelAttribute UserListForm form, Model model) {
		// formをMUserクラスに変換 
		MUser user = modelMapper.map(form, MUser.class); 
		
		// ユーザー検索 
		List<MUser> userList = userService.getUsers(user);

		// Modelに登録
		model.addAttribute("userList", userList);

		// ユーザー一覧画面を表示
		return "user/list";
	}
	
	/** ユーザー検索処理 */ 
	/** list.htmlにてactionが/user/updateの呼び出しが発生した際にユーザ検索処理を実行しユーザ一覧画面を表示する */
	/** postリクエストの場合、userIdの入力がされている場合があるため対象のユーザーのみの検索が行われる */
	@PostMapping("/list") 
	public String postUserList(@ModelAttribute UserListForm form, Model model) { 
		// formをMUserクラスに変換 
		MUser user = modelMapper.map(form, MUser.class); 
		
		// ユーザー検索 
		List<MUser> userList = userService.getUsers(user); 
		
		// Modelに登録 
		model.addAttribute("userList", userList); 
		
		// ユーザー一覧画面を表示 
		return "user/list"; 
	}
}