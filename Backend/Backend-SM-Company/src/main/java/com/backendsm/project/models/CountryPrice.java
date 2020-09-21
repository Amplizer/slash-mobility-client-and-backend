package com.backendsm.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table( name = "products_country_prices" )
@Data
public class CountryPrice {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@JsonIgnore
	private int id;
	
	@Column( name = "code" )
	private String code;
	
	@Column( name = "alias" )
	private String alias;
	
	
}
