package com.complemento.inventory.response;

import java.util.List;

import com.complemento.inventory.model.Category;

import lombok.Data;

@Data
public class CategoryResponse {

	private List<Category> categoria;
	
}
