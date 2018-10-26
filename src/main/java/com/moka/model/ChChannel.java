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
public class ChChannel extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  channelAddress;
	private String  channelContact;
	private String  channelMobile;
	private String  channelName;
	private String  createtime;
	private String  updatetime;
	private Integer  userId;



	
}
