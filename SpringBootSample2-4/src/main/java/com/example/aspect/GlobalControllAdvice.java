package com.example.aspect;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** 全てのコントローラーでメソッドを使用できるようになる */
@ControllerAdvice 
public class GlobalControllAdvice { 
	/** データベース関連の例外処理 */ 
	/** DataAccessExceptionにてデータベース処理にて例外が発生した際の処理を実装する */
	@ExceptionHandler(DataAccessException.class) 
	public String dataAccessExceptionHandler(DataAccessException e, Model model) { 
		
		// 空文字をセット 
		model.addAttribute("error", ""); 
		
		// メッセージをModelに登録 
		model.addAttribute("message", "DataAccessExceptionが発生しました"); 
		
		// HTTPのエラーコード（500）をModelに登録 
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR); return "error"; 
	} 
	/** その他の例外処理 */ 
	/** Exceptionにて作成していない例外が発生した際の処理を実装する */
	@ExceptionHandler(Exception.class) 
	public String exceptionHandler(Exception e, Model model) { 
		
		// 空文字をセット 
		model.addAttribute("error", ""); 
		
		// メッセージをModelに登録 
		model.addAttribute("message", "Exceptionが発生しました"); 
		
		// HTTPのエラーコード（500）をModelに登録 
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR); return "error";
	}
}
