package com.example.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {

	//ValidGroup1→ValidGroup2の順でバリテーションを実行するように設定する

	//ブランクでないことをチェックする
	@NotBlank(groups = ValidGroup1.class)
	//メールアドレスであるかをチェックする
	@Email(groups = ValidGroup2.class)
	private String userId;

	//ブランクでないことをチェックする	
	@NotBlank(groups = ValidGroup1.class)
	//入力内容の長さが4文字以上100文字以下であることをチェックする
	@Length(min = 4, max = 100, groups = ValidGroup2.class)
	//入力内容が英字（大文字、小文字）と数字であることをチェックする
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)
	private String password;

	//ブランクでないことをチェックする	
	@NotBlank(groups = ValidGroup1.class)
	private String userName;

	//入力された内容をyyyy/MM/ddの形に変換する
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	//nullでないことをチェックする	
	@NotNull(groups = ValidGroup1.class)
	private Date birthday;

	//入力内容が20文字以上であることをチェックする
	@Min(value = 20, groups = ValidGroup2.class)
	//入力内容が100文字以下であることをチェックする
	@Max(value = 100, groups = ValidGroup2.class)
	private Integer age;

	//nullでないことをチェックする	
	@NotNull(groups = ValidGroup1.class)
	private Integer gender;

}
