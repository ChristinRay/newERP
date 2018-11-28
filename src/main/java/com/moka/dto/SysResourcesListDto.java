package com.moka.dto;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年11月28日 下午3:09:54
**/
@Data
public class SysResourcesListDto {
	private Integer id;
	private String  name;
	private String  resUrl;
	private Integer userType;
	private Integer userSort;

}
