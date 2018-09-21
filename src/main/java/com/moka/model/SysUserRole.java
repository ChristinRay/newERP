package com.moka.model;

import java.lang.Integer;

import lombok.Getter;
import lombok.Setter;
/**
 * 用户角色中间表
 * modle
 */
@Setter
@Getter
public class SysUserRole extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer  id;
	private Integer  userId;
	private Integer  roleId;



	
}
