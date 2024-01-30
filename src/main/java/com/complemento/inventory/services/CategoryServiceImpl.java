package com.complemento.inventory.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.complemento.inventory.dao.ICategoryDao;
import com.complemento.inventory.model.Category;
import com.complemento.inventory.response.CategoryResposeRest;



@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly=true)
	public ResponseEntity<CategoryResposeRest> search() {
		CategoryResposeRest response= new CategoryResposeRest();
	
		try {
			List<Category> category = (List<Category>) categoryDao.findAll();
			response.getCategoryResponse().setCategoria(category);
			response.setDatos("ok", "00", "exitosa");
		}catch (Exception e) {
			response.setDatos(" no ok", "-0", "error al consultar");
			e.getStackTrace();
			return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResposeRest> searchById(Long id) {
		
		CategoryResposeRest response= new CategoryResposeRest();
		List<Category> list=new ArrayList<>(); 
		
		try {
			Optional<Category> categoria = categoryDao.findById(id);
			
			if(categoria.isPresent()) {
				list.add(categoria.get());
				response.getCategoryResponse().setCategoria(list);
				response.setDatos(" no ok", "-0", "categoria encontrada");
			}else {
				response.setDatos(" no ok", "-0", "error categoria no encontrada");
				return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			response.setDatos(" no ok", "-0", "error al consultar");
			e.getStackTrace();
			return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResposeRest> save(Category category) {
		
		CategoryResposeRest response= new CategoryResposeRest();
		List<Category> list=new ArrayList<>(); 
		
		try {
			
			Category categorySave = categoryDao.save(category);
			
			if(categorySave !=null) {
				list.add(categorySave);
				response.getCategoryResponse().setCategoria(list);
			}else {
				response.setDatos(" no ok", "-0", "Categoria no guardada");
				return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.BAD_REQUEST);
			}
			
		}catch (Exception e) {
			response.setDatos(" no ok", "-0", "error al guardar");
			e.getStackTrace();
			return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResposeRest> update(Category category, Long id) {

		CategoryResposeRest response= new CategoryResposeRest();
		List<Category> list=new ArrayList<>(); 
		
		try {
			
			Optional<Category> categoriasearch = categoryDao.findById(id);
			
			if(categoriasearch.isPresent()) {
				categoriasearch.get().setName(category.getName());
				categoriasearch.get().setDescription(category.getDescription());
				
				Category categoryToUpdate= categoryDao.save(categoriasearch.get());
				
				if(categoryToUpdate !=null) {
					
				 list.add(categoryToUpdate);
				 response.getCategoryResponse().setCategoria(list);
				 response.setDatos("Respuesta Ok", "00", "Categoria Actulaizada");
				}else {
				 response.setDatos("Respuesta no ok", "-1", "Categoria no actualizada");
				 return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.BAD_REQUEST);
				}
				
			}else {
				response.setDatos(" no ok", "-0", "Categoria no guardada");
				return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.BAD_REQUEST);
			}
			
		}catch (Exception e) {
			response.setDatos(" no ok", "-0", "error al guardar");
			e.getStackTrace();
			return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CategoryResposeRest> deleteByid(Long id) {
		
		CategoryResposeRest response= new CategoryResposeRest();
		
		try {
			categoryDao.deleteById(id);
			response.setDatos("Repuesta ok", "00", "registro eliminado");
			
		}catch (Exception e) {
			response.setDatos(" no ok", "-1", "error al eliminar");
			e.getStackTrace();
			return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CategoryResposeRest>(response, HttpStatus.OK);
	}
	
	

}
