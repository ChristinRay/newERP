package com.moka.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.SysUserData;
import com.moka.model.SysUser;
import com.moka.result.Result;

import lombok.extern.slf4j.Slf4j;

/**
* @author    created by lbq
* @date	     2018年11月27日 上午10:33:38
**/
@Service
@Slf4j
public class UserService {
	@Autowired
	private SysUserData sysUserData;
	
	/**
	 * 添加用户
	 * @param sysUser
	 * @return
	 */
	public Result<?> add(SysUser sysUser){
		
		return Result.create(sysUserData.insertSysUser(sysUser));
	}
	/**
	 * 查询用户
	 * @param sysUser
	 * @return
	 */
	public Result<?> list(SysUser sysUser){
		
		return Result.create(sysUserData.selectSysUser(sysUser));
	}
	
	
	/**
	 * 得到这个用户
	 * @param user
	 * @return
	 */
	public SysUser getUser(SysUser user) {
		SysUser sysUsers= sysUserData.selectSysUser(user);
		log.info("登录的用户信息"+sysUsers);
		return sysUsers;
	}
	/**
	 * 根据用户id找到用户的角色对应的权限
	 * @param id
	 * @return
	 */
	public Set<String> findPermissionsByUserId(Integer id) {
		Set<String> set =sysUserData.findPermissionsByUserId(id);
		set.add("1");
		return set;
	}
	
}





