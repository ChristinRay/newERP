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
public class ChChannelItem extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer  id;
	private Integer  productId;
	private Integer  channelId;
	private String  channelProductName;
	private String  commission;
	private String  integral;
	private String  staging;
	private Integer  userId;
	private String  state;
	private String  createtime;
	private String  updatetime;



	
}
