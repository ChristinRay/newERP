package com.moka.shiro_redis_config;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;
import com.moka.dao.SysRoleData;

/**
* @author    created by lbq
* @date	     2018年9月20日 上午11:25:01
**/
@Service
public class SysRoleService {
	
	@Autowired
	private SysRoleData sysRoleData;
	

	public Set<String> findRoleNameByUserId(Integer id) {
		Set<String>  set=Sets.newHashSet();
		
		
		return null;
	}

}
