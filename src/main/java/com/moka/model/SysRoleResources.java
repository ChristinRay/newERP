package com.moka.model;

import java.lang.Integer;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * modle
 */
@Setter
@Getter
public class SysRoleResources extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer  id;
	private Integer  roleId;
	private Integer  resourcesId;



	
}
