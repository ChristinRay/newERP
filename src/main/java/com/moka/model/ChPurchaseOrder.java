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
public class ChPurchaseOrder extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer  approverId;
	private Integer  companyId;
	private String  createtime;
	private Integer  depotId;
	private Integer  id;
	private String  memo;
	private String  predictTime;
	private String  purBillsDate;
	private String  purBillsId;
	private String  purBillsType;
	private String  purOrderType;
	private String  realityTime;
	private String  state;
	private String  updatetime;
	private Integer  userId;



	
}
