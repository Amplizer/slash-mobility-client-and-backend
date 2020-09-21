package com.backendsm.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table( name = "products" )
@Data
public class Product {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	@Column( name = "name" )
	private String name;
	
	@JsonProperty("countryCurrency")
	@JoinColumn( name = "countryCurrency" )
	@OneToOne
	private CountryPrice countryCurrency;
	
	@JsonProperty("productView")
	@JoinColumn( name = "img_src_type" )
	@OneToOne
	private ProductImage productImage;
	
	@Column( name = "img_file" )
	private String imgFile;
	
	@Column( name = "active" )
	private boolean active;
	
	@Column( name = "price" )
	private float price;
	
	public Product() {}
	
}
