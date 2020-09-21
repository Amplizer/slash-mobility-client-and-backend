package com.backendsm.project.controllersRepositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.backendsm.project.models.Product;


// Repository used for manipulate products 
public interface ProductRepository extends CrudRepository<Product, Serializable>{
	List<Product> findByActive( boolean active );
	Product findById( int id );
}
