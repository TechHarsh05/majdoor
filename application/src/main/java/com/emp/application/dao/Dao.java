package com.emp.application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.application.entity.Product;
import com.emp.application.repository.AdminRepo;
import com.emp.application.repository.ProductRepository;
import com.emp.application.repository.UserRepository;

@Repository
public class Dao {
	
	@Autowired
	private UserRepository urepo;
	@Autowired
	private ProductRepository prepo;
	@Autowired
	private AdminRepo rrepo;
	
	public Product insertProductDao(Product product) {
		
		return prepo.save(product);
	}

	public List<Product> getProductsDao() {
		return prepo.findAll();
	}
	
}
