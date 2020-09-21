package com.backendsm.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backendsm.project.controllersRepositories.ProductRepository;
import com.backendsm.project.models.Product;

@RestController
@RequestMapping( value = "/api/products" )
public class ProductController {

	// ------------------------------------------------------------------------------
	// -------------------------- Repositories Initialization------------------------
	// ------------------------------------------------------------------------------
	
	@Autowired
	private ProductRepository productRepository;
	
	public void instanciateProductService(  ProductRepository productRepository ) {
		this.productRepository = productRepository;
	}
	
	// ------------------------------------------------------------------------------
	
	
	// Return all products
	@GetMapping
	public List<Product> getProducts() {
		return this.productRepository.findByActive( true );
	}
	
}
