package com.moka.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.dao.SysUserData;
import com.moka.model.SysUser;
import com.moka.req.ChSysUserReq;
import com.moka.result.Result;
import com.moka.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
* @author    created by lbq
* @date	     2018年11月23日 下午6:25:28
**/
@RestController
@RequestMapping("api/erp/v1/sys")
@Slf4j
public class ChSysUserController {
	@Autowired
	private UserService chSysUserService;
	@Autowired
	private SysUserData sysUserData;
	
	
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
	/**
	 * 删除用户数据
	 * @param id
	 * @return
	 */
	@GetMapping("delete")
	public Result<?> delete(Integer id){
		int a = sysUserData.deleteByLogic(id);
		if(a==1){
			log.info("删除成功");
		}
		return Result.create("删除成功");
	}
	
	
	
	
}
