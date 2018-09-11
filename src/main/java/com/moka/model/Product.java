package com.moka.model;

import java.lang.Long;
import java.lang.String;

/**
 * 
 * modle
 */
public class Product extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String product_no;


	public Long getId() {return id;}
public void setId(Long id) {this.id = id;}
public String getProduct_no() {return product_no;}
public void setProduct_no(String product_no) {this.product_no = product_no;}

	
}
