package com.moka.model;

import lombok.Data;
/**
 * 权限表
 * modle
 */
@Data
public class SysResources  {
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private Integer  id;
	private String  name;
	private String  resUrl;
	private Integer  userType;
	private Integer  userSort;
	private Integer  parentId;



	
}
