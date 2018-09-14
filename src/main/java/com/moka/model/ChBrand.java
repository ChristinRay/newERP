package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 品牌表
 * modle
 */
@Setter
@Getter
public class ChBrand extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer  id;
	private String  brandName;
	private String  brandCode;
	private Integer  userId;
	private String  state;
	private String  createtime;
	private String  updatetime;



	
}
