package com.complemento.inventory.services;

import org.springframework.http.ResponseEntity;

import com.complemento.inventory.model.Category;
import com.complemento.inventory.response.CategoryResposeRest;

public interface ICategoryService {
	
	public ResponseEntity<CategoryResposeRest> search();
	
	public ResponseEntity<CategoryResposeRest> searchById(Long id);
	
	public ResponseEntity<CategoryResposeRest> save(Category category);
	
	public ResponseEntity<CategoryResposeRest> update(Category category, Long id);
	
	public ResponseEntity<CategoryResposeRest> deleteByid(Long Id);
	
}
