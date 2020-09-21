package com.backendsm.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table( name = "users" )
@Data
public class User {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	@Column( name = "email" )
	private String email;
	
	public User( String email ) {
		this.email = email;
	}
	
	public User( int id, String email ) {
		this.id = id;
		this.email = email;
	}
	
	public User() {}
	
}
