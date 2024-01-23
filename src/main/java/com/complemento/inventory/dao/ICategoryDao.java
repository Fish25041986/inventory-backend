package com.complemento.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import com.complemento.inventory.model.Category;

public interface ICategoryDao extends CrudRepository<Category, Long>{
  
}
