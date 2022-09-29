package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "crud")
public class CrudInfo implements Serializable{

	@Id
	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "kana")
	private String kana;
	
	
	@Column(name = "password")
	private String password;
	
	
	@Column(name = "mail")
	private String mail;
	
	
}
