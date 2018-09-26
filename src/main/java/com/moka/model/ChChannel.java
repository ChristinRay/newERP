package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 渠道表
 * modle
 */
@Setter
@Getter
public class ChChannel extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer  productId;
	private String  channelName;
	private String  channelAddress;
	private String  commission;
	private String  integral;
	private Integer  userId;
	private String  state;
	private String  createtime;
	private String  updatetime;


	
	
}
