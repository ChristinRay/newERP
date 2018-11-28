package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 角色表
 * modle
 */
@Setter
@Getter
public class SysRole extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer  id;
	private String  roleDesc;



	
}
