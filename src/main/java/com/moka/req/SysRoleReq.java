package com.moka.req;

import java.util.Set;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年11月28日 下午3:21:56
**/
@Data
public class SysRoleReq {
	private Integer  id;//角色id
	private String  roleDesc;//角色名称
	private Set<Integer> resources;//对应的权限集合
}
