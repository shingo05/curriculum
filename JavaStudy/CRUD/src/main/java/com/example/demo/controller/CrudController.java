package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.CrudAddRequest;
import com.example.demo.dto.CrudSearchRequest;
import com.example.demo.dto.CrudUpdateRequest;
import com.example.demo.entity.CrudInfo;
import com.example.demo.service.CrudService;

@Controller
public class CrudController {
	
	@Autowired
	private CrudService crudService; 
	
	
	@GetMapping(value = "/html/list")
	public String displayList(Model model) {
		List<CrudInfo> crudList = crudService.findAll();
		 model.addAttribute("crudlist", crudList);
	     model.addAttribute("crudSearchRequest", new CrudSearchRequest());
	     return "html/search";
	} 

	
	 @GetMapping(value = "/html/add")
	 public String displayAdd(Model model) {
       model.addAttribute("crudAddRequest", new CrudAddRequest());
       return "html/add";
	 }
	 
	 
	 @GetMapping("/html/{id}/edit")
	 public String displayEdit(@PathVariable String id, Model model) {
		 CrudInfo crud = crudService.findById(id);
		 CrudUpdateRequest crudUpdateRequest = new CrudUpdateRequest();
		 crudUpdateRequest.setId(crud.getId());
		 crudUpdateRequest.setName(crud.getName());
		 crudUpdateRequest.setKana(crud.getKana());
		 crudUpdateRequest.setPassword(crud.getPassword());
		 crudUpdateRequest.setMail(crud.getMail());
		 model.addAttribute("crudUpdateRequest", crudUpdateRequest);
	     return "html/edit";
	 }
	 
	 @RequestMapping(value = "/html/search", method = RequestMethod.POST)
	    public String search(@ModelAttribute CrudSearchRequest crudSearchRequest, Model model) {
	        List<CrudInfo> crudList = crudService.search(crudSearchRequest);
	        model.addAttribute("crudlist", crudList);
	        return "html/search";
	 }
	 
	 @GetMapping("/html/{id}/delete")
	 public String delete(@PathVariable String id, Model model) {
		 crudService.delete(id);
		 return "redirect:/html/list";
	 }

	 @RequestMapping(value = "/html/create", method = RequestMethod.POST)
	 public String create(@Validated @ModelAttribute CrudAddRequest userRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<String> errorList = new ArrayList<String>();
	        for (ObjectError error : result.getAllErrors()) {
	                errorList.add(error.getDefaultMessage());
	        }
	        model.addAttribute("validationError", errorList);
	            return "html/add";
	        }
        
        	crudService.save(userRequest);
	        return "redirect:/html/list";
	    }

	    @RequestMapping(value = "/html/update", method = RequestMethod.POST)
	    public String update(@Validated @ModelAttribute CrudUpdateRequest crudUpdateRequest, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            List<String> errorList = new ArrayList<String>();
	            for (ObjectError error : result.getAllErrors()) {
	                errorList.add(error.getDefaultMessage());
	            }
	            model.addAttribute("validationError", errorList);
	            return "html/edit";
	        }
	        // ユーザー情報の更新
	        crudService.update(crudUpdateRequest);
	        return "redirect:/html/list";
	    }
	
}
