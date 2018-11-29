package com.moka.shiro_redis_config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;
import com.moka.dao.SysUserRoleData;

/**
* @author    created by lbq
* @date	     2018年9月20日 上午11:25:01
**/
@Service
public class SysRoleServices {
	
	@Autowired
	private SysUserRoleData sysUserRoleData;
	
	/**
	 * 根据登录人id查找登录人角色
	 * @param id
	 * @return
	 */
	public Set<String> findRoleNameByUserId(Integer id) {
		Set<String>  set=Sets.newHashSet();
//		Set<Integer> sett= sysUserRoleData.findRolesByUserId(id);
		
		set.add("1");
		
		return set;
	}

}
