package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class CrudUpdateRequest implements Serializable{
	
	
	@NotNull
	private String id;
	
	
	 @NotEmpty(message = "名前を入力してください")
	 private String name;
	
	 
	 @NotEmpty(message = "読み仮名を入力してください")
	 private String kana;
	 
	 
	 @NotEmpty(message = "password を入力してください")
	 private String password;
	 
	 
	@Email(message = "正しい形式で入力してください")
	@NotEmpty(message = "メールアドレスを入力してください")
	private String mail;
	 
	 

}
