package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CrudMapper;
import com.example.demo.dto.CrudAddRequest;
import com.example.demo.dto.CrudSearchRequest;
import com.example.demo.dto.CrudUpdateRequest;
import com.example.demo.entity.CrudInfo;

@Service
public class CrudService{
	
    
    @Autowired
    private CrudMapper crudMapper;
    
    
    public List<CrudInfo> findAll() {
        return crudMapper.findAll();
    }
    
    
    public CrudInfo findById(String id) {
        return crudMapper.findById(id);
    }
    
    
    public List<CrudInfo> search(CrudSearchRequest crudSearchRequest) {
        return crudMapper.search(crudSearchRequest);
    }
	
    
    public void save(CrudAddRequest crudAddRequest) {
        crudMapper.save(crudAddRequest);
    }

    
    public void update(CrudUpdateRequest crudUpdateRequest) {
        crudMapper.update(crudUpdateRequest);
    }
    
    
    public void delete(String user_id) {
        crudMapper.delete(user_id);
    }
    
    
}
