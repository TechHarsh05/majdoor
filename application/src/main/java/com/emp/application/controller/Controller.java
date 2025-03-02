package com.emp.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.application.dao.Dao;
import com.emp.application.entity.Product;

@RequestMapping("/")
@RestController
@CrossOrigin("http://localhost:5173")
public class Controller {
	@Autowired
	private Dao dao;

	@PostMapping("/insert-products")
	public Product insertProductsController(@RequestBody Product product) {
		return dao.insertProductDao(product);
	}
	
	@GetMapping("/get-products")
	public List<Product> getProductsController() {
		return dao.getProductsDao();
	}
}
