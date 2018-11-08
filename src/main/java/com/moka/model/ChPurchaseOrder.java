package com.moka.model;

import java.lang.Integer;
import java.math.BigDecimal;
import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * modle
 */
@Setter
@Getter
public class ChPurchaseOrder extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer  companyId;
	private Integer supplyId;
	private Integer  depotId;
	private String  picture;
	private String  predictTime;
	private BigDecimal  price;
	private String  purBillsDate;
	private String  purBillsId;
	private String  purBillsType;
	private String  purOrderType;
	private String  realityTime;
	private Integer  approverId;
	private Integer  userId;
	private String  memo;
	private String  createtime;
	private String  updatetime;



	
}
