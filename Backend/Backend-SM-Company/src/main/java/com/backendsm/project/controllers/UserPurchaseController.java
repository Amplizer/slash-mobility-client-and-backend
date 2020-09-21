package com.backendsm.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backendsm.project.controllersRepositories.ProductRepository;
import com.backendsm.project.controllersRepositories.UserPurchaseRepository;
import com.backendsm.project.controllersRepositories.UserRepository;
import com.backendsm.project.models.Product;
import com.backendsm.project.models.User;
import com.backendsm.project.models.UserPurchase;

@RestController
@RequestMapping( value = "/api/user/purchase" )
public class UserPurchaseController {
	
	// ------------------------------------------------------------------------------
	// -------------------------- Repositories Initialization------------------------
	// ------------------------------------------------------------------------------
	
	@Autowired
	private UserPurchaseRepository userPurchaseRepository;
	
	public void instanciateProductService(  UserPurchaseRepository userPurchaseRepository ) {
		this.userPurchaseRepository = userPurchaseRepository;
	}
	
	@Autowired
	private UserRepository userRepository;
	
	public void instanciateUserRepository(  UserRepository userRepository ) {
		this.userRepository = userRepository;
	}
	
	@Autowired
	private ProductRepository productRepository;
	
	public void instanciateUserRepository(  ProductRepository productRepository ) {
		this.productRepository = productRepository;
	}
	
	// ------------------------------------------------------------------------------
	
	// This method creates new purchases to users, and if an user doesn't exists is created too
	@PostMapping
	public void clientPurchaseProduct( @RequestParam(name = "email") String email, @RequestParam(name = "product_id") int product_id ) {
		User user = userRepository.findByEmail(email);
		if(  user == null ) {
			user = new User( email );
			userRepository.save( user );
		}
		user = userRepository.findByEmail(email);
		Product product = productRepository.findById(product_id);
		
		this.userPurchaseRepository.save( new UserPurchase( product, user, false ) );
	}
	
}
