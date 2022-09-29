package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.CrudAddRequest;
import com.example.demo.dto.CrudSearchRequest;
import com.example.demo.dto.CrudUpdateRequest;
import com.example.demo.entity.CrudInfo;



@Mapper
public interface CrudMapper {
	
	
	List<CrudInfo> findAll();
	
	
	CrudInfo findById(String id);
	
	
	List<CrudInfo> search(CrudSearchRequest crud);
	
	
	void save(CrudAddRequest crudAddRequest);

	
	void update(CrudUpdateRequest crudUpdateRequest);
	
	
	void delete(String id);
}
