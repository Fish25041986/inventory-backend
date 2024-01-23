package com.complemento.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complemento.inventory.response.CategoryResposeRest;
import com.complemento.inventory.services.ICategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	
	@Autowired
	private ICategoryService service;

	@GetMapping("/categories")
	public ResponseEntity<CategoryResposeRest> searchCategories(){
		
		ResponseEntity<CategoryResposeRest> response = service.search();
		return response;
		
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryResposeRest> searchCategoriesById(@PathVariable Long id){
		
		ResponseEntity<CategoryResposeRest> response = service.searchById(id);
		return response;
		
	}
}
