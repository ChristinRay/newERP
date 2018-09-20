package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 用户user表
 * modle
 */
@Setter
@Getter
public class SysUser extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer  id;
	private String  userName;
	private String  passWord;
	private Integer  userEnable;



	
}
