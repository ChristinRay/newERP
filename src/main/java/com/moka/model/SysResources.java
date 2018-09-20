package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 权限表
 * modle
 */
@Setter
@Getter
public class SysResources extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer  id;
	private String  userName;
	private String  resUrl;
	private Integer  userType;
	private Integer  userSort;



	
}
