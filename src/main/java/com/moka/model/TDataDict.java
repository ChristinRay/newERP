package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 系统字典表
 * modle
 */
@Setter
@Getter
public class TDataDict {
	/**
	 * 
	 */
	private Integer  id;
	private String  sysCode;
	private String  fieldCode;
	private String  code;
	private String  value;



	
}
