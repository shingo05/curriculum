package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CrudAddRequest implements Serializable{
	
	
	@Size(max = 8, message = "IDは８桁以内で入力してください")
	@NotEmpty(message = "IDを入力してください")
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
