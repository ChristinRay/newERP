package com.moka.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.model.SysUser;
import com.moka.req.ChSysUserReq;
import com.moka.result.Result;
import com.moka.service.UserService;

/**
* @author    created by lbq
* @date	     2018年11月23日 下午6:25:28
**/
@RestController
@RequestMapping("api/erp/v1/sys")
public class ChSysUserController {
	@Autowired
	private UserService chSysUserService;
	
	
	/**
	 * 新增用户
	 * @param sysUser
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@PostMapping("add")
	public Result<?> add(@RequestBody ChSysUserReq sysUser) throws IllegalAccessException, InvocationTargetException{
		
		return chSysUserService.add(sysUser);
	}
	/**
	 * 查询员工信息
	 * @param sysUser
	 * @return
	 */
	@PostMapping("list")
	public Result<?> list(@RequestBody SysUser sysUser){
		
		
		return chSysUserService.list(sysUser);
	}
	
}
