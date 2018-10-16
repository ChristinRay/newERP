package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * modle
 */
@Setter
@Getter
public class ChCategory extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  categoryName;
	private Integer  fatherId;



	
}
