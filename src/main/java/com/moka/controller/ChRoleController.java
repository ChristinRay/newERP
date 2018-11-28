package com.moka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.dao.SysRoleData;
import com.moka.model.SysRole;
import com.moka.req.SysRoleReq;
import com.moka.result.Result;
import com.moka.service.SysRoleService;

/**
* @author    created by lbq
* @date	     2018年11月27日 下午5:36:29
**/
@RestController
@RequestMapping("api/erp/v1/role")
public class ChRoleController {
	
	@Autowired
	private SysRoleData roleData;
	@Autowired
	private SysRoleService sysRoleService;
	
	/**
	 * 角色List
	 * @param sysRole
	 * @return
	 */
	@PostMapping("list")
	public Result<?> list(@RequestBody SysRole sysRole){
		return	Result.create(roleData.selectSysRole(sysRole));
	}
	
	
	/**
	 * 角色添加
	 * @return
	 */
	@PostMapping("add")
	public Result<?> add(@RequestBody SysRoleReq roleReq){
		
		return Result.create(sysRoleService.add(roleReq));
	}
	
	/**
	 * 角色权限关系列表
	 * @return
	 */
	@PostMapping("list/all")
	public Result<?> listAll(){
		sysRoleService.listAll();
		return null;
	}
	
}	















