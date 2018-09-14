package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 供应商表
 * modle
 */
@Setter
@Getter
public class ChSupply extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer  id;
	private String  supplyCode;
	private String  brandCode;
	private String  sypplyName;
	private String  accreditLevel;
	private String  accreditStartTime;
	private String  accreditEndTime;
	private String  cooperationType;
	private String  supplyAccount;
	private String  supplyAccountName;
	private String  accreditProduct;
	private String  sypplyAddress;
	private String  sypplyContact;
	private String  sypplyMobile;
	private String  sypplyContactPosition;
	private String  companyName;
	private Integer  userId;
	private String  state;
	private String  createtime;
	private String  updatetime;



	
}
