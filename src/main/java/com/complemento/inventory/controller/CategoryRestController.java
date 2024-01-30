package com.complemento.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complemento.inventory.model.Category;
import com.complemento.inventory.response.CategoryResposeRest;
import com.complemento.inventory.services.ICategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	
	@Autowired
	private ICategoryService service;

	/**
	 * get search category
	 * */
	@GetMapping("/categories")
	public ResponseEntity<CategoryResposeRest> searchCategories(){
		
		ResponseEntity<CategoryResposeRest> response = service.search();
		return response;
		
	}
	
	/**
	 *get categories by id
	 *@param id
	 *@return
	 */
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryResposeRest> searchCategoriesById(@PathVariable Long id){
		
		ResponseEntity<CategoryResposeRest> response = service.searchById(id);
		return response;
		
	}
	
	/**
	 *save categories
	 *@param id
	 *@return
	 */
	@PostMapping("/categories")
	public ResponseEntity<CategoryResposeRest> save(@RequestBody Category category){
		
		ResponseEntity<CategoryResposeRest> response = service.save(category);
		return response;
		
	}
	
	/**
	 * update categories
	 *@param id
	 *@return
	 */
	@PutMapping("/categories/{id}")
	public ResponseEntity<CategoryResposeRest> update(@RequestBody Category category, @PathVariable Long id){
		
		ResponseEntity<CategoryResposeRest> response = service.update(category,id);
		return response;
		
	}
	/**
	 * Delete Categories
	 * @param id
	 * @return
	 */
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<CategoryResposeRest> delete(@PathVariable Long id){
		
		ResponseEntity<CategoryResposeRest> response = service.deleteByid(id);
		return response;
		
	}
	
}
