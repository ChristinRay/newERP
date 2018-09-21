package com.moka.model;

import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
/**
 * 商品供应商关联表
 * modle
 */
@Setter
@Getter
public class ChSupplyProduct extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer  id;
	private Integer  supplyId;
	private Integer  productId;
	private BigDecimal  productPrice;
	private BigDecimal  productFreightPrice;
	private Integer  userId;
	private String  state;
	private String  createtime;
	private String  updatetime;



	
}
