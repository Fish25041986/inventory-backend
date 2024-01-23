package com.complemento.inventory.services;

import org.springframework.http.ResponseEntity;

import com.complemento.inventory.response.CategoryResposeRest;

public interface ICategoryService {
	
	public ResponseEntity<CategoryResposeRest> search();

}
