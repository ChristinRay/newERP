package com.moka.service;


import java.beans.Beans;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.compress.utils.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.moka.dao.SysRoleData;
import com.moka.dao.SysUserData;
import com.moka.dao.SysUserRoleData;
import com.moka.dto.SysUserListDto;
import com.moka.model.SysUser;
import com.moka.model.SysUserRole;
import com.moka.req.ChSysUserReq;
import com.moka.result.Result;

import io.lettuce.core.dynamic.annotation.Param;
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
	@Autowired
	private SysUserRoleData sysUserRoleData;
	@Autowired
	private SysRoleData sysRoleData;
	
	/**
	 * 添加用户
	 * @param sysUser
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@Transactional
	public Result<?> add(ChSysUserReq chSysUserReq) throws IllegalAccessException, InvocationTargetException{
		SysUser sysUser=new SysUser();
		BeanUtils.copyProperties(sysUser, chSysUserReq);
		sysUser.setUserEnable(1);
		sysUser.setState("1");
		sysUserData.insertSysUser(sysUser);
		
		SysUserRole sysUserRole=new SysUserRole();
		sysUserRole.setUserId(chSysUserReq.getUserId());
		Set<Integer> roleList= chSysUserReq.getRoles();
		for (Integer integer : roleList) {
			sysUserRole.setRoleId(integer);
			sysUserRoleData.insertSysUserRole(sysUserRole);
		}
		return Result.create("员工添加成功");
	}
	/**
	 * 查询所有员工信息list
	 * @param sysUser
	 * @return
	 */
	public Result<?> list(SysUser sysUser){
		List<SysUserListDto> sysUserListDto= sysUserData.selectSysUserList(sysUser);
		for (SysUserListDto sysUserDto : sysUserListDto) {
			 Set<Integer> rolesList= sysUserRoleData.findRolesByUserId(sysUserDto);
			 for (Integer id : rolesList) {
				String roleDesc= sysRoleData.findNameById(id);
				Set<String> jkl=new HashSet<>();
				jkl.add(roleDesc);
				sysUserDto.setRoleDesc(jkl);
			}
		}
		return Result.create(sysUserListDto);
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





