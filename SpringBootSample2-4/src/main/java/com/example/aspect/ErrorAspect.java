package com.example.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component 
@Slf4j 
public class ErrorAspect { 
	//@AfterThrowingにて例外発生時に共通して呼び出される処理を実装する
	//また、@AfterThrowingにて実装することで重複したソースの記載が不要になる、共通処理として実装するため修正箇所を１箇所とすることができる。
	@AfterThrowing(value = "execution(* *..*..*(..)) &&" + "(bean(*Controller) || bean(*Service) || bean(*Repository))", throwing = "ex") 
	public void throwingNull(DataAccessException ex) { 
		// 例外処理の内容（ログ出力） 
		log.error("DataAccessExceptionが発生しました");
	}
}