package com.moka.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moka.Enum.CodeEnum;
import com.moka.dao.SysRoleData;
import com.moka.dao.SysRoleResourcesData;
import com.moka.model.SysRole;
import com.moka.model.SysRoleResources;
import com.moka.req.SysRoleReq;
import com.moka.result.Result;
import com.moka.utils.ParamPreconditions;

/**
* @author    created by lbq
* @date	     2018年11月28日 下午3:25:24
**/
@Service
public class SysRoleService {
	@Autowired
	private SysRoleData sysRoleData;
	@Autowired
	private SysRoleResourcesData sysRoleResourcesData;
	
	/**
	 * 添加角色
	 * @param sysRoleReq
	 * @return
	 */
	@Transactional
	public Object add(SysRoleReq sysRoleReq){
		ParamPreconditions.checkNotEmpty(CodeEnum.FAIL.getCode(),"角色名称不能为空", "角色名称不能为空",sysRoleReq.getRoleDesc());
		ParamPreconditions.checkNotNull(sysRoleReq.getResources(), CodeEnum.FAIL.getCode(), "角色对应的权限不能为空");
		SysRole sysRole=new SysRole();
		sysRole.setRoleDesc(sysRoleReq.getRoleDesc());
	    int a=sysRoleData.insertSysRole(sysRole);
	    if(a==1){
	    	Set<Integer> set=sysRoleReq.getResources();//得到权限集合
	    	SysRoleResources sysRoleResources=new SysRoleResources();
	    	sysRoleResources.setRoleId(sysRole.getId());//得到角色id
	    	for (Integer resourceId : set) {
	    		sysRoleResources.setResourcesId(resourceId);
	    		sysRoleResourcesData.insertSysRoleResources(sysRoleResources);
			}
	    }else{
	    	return Result.create("ERROR", "数据添加失败");
	    }
	    return Result.create("OK","添加成功");
	}

	/**
	 * 查询所有角色和权限对应关系
	 * @return
	 */
	public Result<?> listAll(){
//		Set<Integer> integers= sysRoleResourcesData.selectRoles();
//		for (Integer integer : integers) {
//			
//		}
		return Result.create(sysRoleResourcesData.selectAll());
	}
}













