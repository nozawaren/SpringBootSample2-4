package com.example.hello;

import lombok.Data;

//セッター・ゲッターなどのメソッドを自動作成してくれる
@Data
public class Employee {
	private String employeeId;
	private String employeeName;
	private int employeeAge;

}
