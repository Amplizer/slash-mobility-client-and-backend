package com.backendsm.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table( name = "products_images_sources" )
@Data
public class ProductImage {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	@JsonProperty("httpProtocol")
	@Column( name = "http_protocol" )
	private String httpProtocol;
	
	@JsonProperty("host")
	@Column( name = "ip" )
	private String ip;
	
	@Column( name = "port" )
	private int port;
	
	@JsonProperty("imgSrcFolder")
	@Column( name = "src_folder" )
	private String srcFolder;
	
	public ProductImage() { }
	
}
