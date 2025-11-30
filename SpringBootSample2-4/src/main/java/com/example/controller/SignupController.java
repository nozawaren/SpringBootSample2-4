package com.example.controller;

import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;
import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.GroupOrder;
import com.example.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
//()内にHTMLのパスを記載することで記載したHTMLのactionタグに記載している同名のパスと連携してGETのリクエストを受けられるようになる
@RequestMapping("/user")
//簡単にログ出力をできるようになる
@Slf4j
public class SignupController {

	@Autowired
	private UserApplicationService userApplicationService;
	
	//インスタンスの生成を省略することができる
	//また、同名インターフェースを別クラスで作成した際にインスタンスの切替が簡単になる
	@Autowired
	private UserService userService;

	@Autowired
	//インスタンスの生成を省略することができる
	//また、同名インターフェースを別クラスで作成した際にインスタンスの切替が簡単になる
	private ModelMapper modelMapper;

	/** ユーザー登録画面を表示 */
	@GetMapping("/signup")
	//getSignupにて引数に設定された値を自動でインスタンスを登録する
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		// 性別を取得
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);

		//ユーザー登録画面に遷移
		return "user/signup";

	}

	/** ユーザー登録処理 */
	@PostMapping("/signup")
	//postSignupにて引数に設定された値を自動でインスタンスを登録する
	//BindingResultにてバインドエラーやバリテーションエラーの発生を確認できる
	//@Validatedにてバリテーションを実行する
	//GroupOrder.classを呼び出すことでバリデーションを実行する順番を反映する
	public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {

		// 入力チェック結果
		//エラーが発生している場合trueが取得される
		if (bindingResult.hasErrors()) {
			// NG:ユーザー登録画面に戻ります
			return getSignup(model, locale, form);
		}


		//コンソールにform.toString()の内容を出力する
		log.info(form.toString());

		//form を MUser クラスに変換
		MUser user = modelMapper.map(form, MUser.class);

		//ユーザー登録
		userService.signup(user);

		// ログイン画面にリダイレクト
		return "redirect:/login";

	}
	
	/** データベース関連の例外処理 */ 
	/** DataAccessExceptionにてデータベース処理にて例外が発生した際の処理を実装する */
	@ExceptionHandler(DataAccessException.class) 
	public String dataAccessExceptionHandler(DataAccessException e, Model model) { 
		
		// 空文字をセット 
		model.addAttribute("error", ""); 
		
		// メッセージをModelに登録 
		model.addAttribute("message", "SignupControllerで例外が発生しました"); 
		
		// HTTPのエラーコード（500）をModelに登録 
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR); return "error"; 
	} 
		
	/** その他の例外処理 */ 
	/** Exceptionにて作成していない例外が発生した際の処理を実装する */
	@ExceptionHandler(Exception.class) 
	public String exceptionHandler(Exception e, Model model) { 
		
		// 空文字をセット 
		model.addAttribute("error", ""); 
		
		// メッセージをModelに登録 
		model.addAttribute("message", "SignupControllerで例外が発生しました"); 
		
		// HTTPのエラーコード（500）をModelに登録 
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR); return "error"; 
	}

}
