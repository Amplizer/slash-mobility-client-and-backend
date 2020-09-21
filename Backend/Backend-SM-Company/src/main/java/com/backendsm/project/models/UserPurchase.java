package com.backendsm.project.models;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table( name = "user_purchases" )
@Data
public class UserPurchase {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	@JoinColumn( name = "product_id" )
	@OneToOne
	private Product product;
	
	@JoinColumn( name = "user_id" )
	@OneToOne
	private User user;
	
	@Column( name = "date_purchase" )
	private GregorianCalendar datePurchase;

	@Column( name = "deleted" )
	private boolean deleted;
	
	public UserPurchase( Product product, User user, boolean deleted ) {
		this.product = product;
		this.user = user;
		this.deleted = deleted;
		this.datePurchase = new GregorianCalendar();
	}
	
}
