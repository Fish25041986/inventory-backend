package com.complemento.inventory.services;

import java.util.List;

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

}
