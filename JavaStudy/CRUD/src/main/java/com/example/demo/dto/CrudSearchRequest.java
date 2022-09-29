package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;


@Data
public class CrudSearchRequest implements Serializable{
	
	
	private String id;
	
	
	private String name;

}
