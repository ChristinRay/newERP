package com.moka.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
* @author    created by lbq
* @date	     2018年11月7日 下午5:05:40
**/
@Getter
@Setter
public class ChProductListDto {
	private Integer id;
	private Integer  companyId;
	private String companyName;
	private Integer supplyId;
	private String supplyName;
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
	private String  state;
	private String  memo;
	private String  createtime;
	private String  updatetime;
}
