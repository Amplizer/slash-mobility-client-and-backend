package com.backendsm.project.controllersRepositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.backendsm.project.models.UserPurchase;

//Repository used for manipulate products purchaseds by users 
public interface UserPurchaseRepository extends CrudRepository<UserPurchase, Serializable>{
	UserPurchase save( UserPurchase userPurchase );
}
