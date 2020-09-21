package com.backendsm.project.controllersRepositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.backendsm.project.models.User;

// Repository used for manipulate users
public interface UserRepository extends CrudRepository<User, Serializable>{
	User findByEmail( String email );
}
