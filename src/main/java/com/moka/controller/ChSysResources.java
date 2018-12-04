package com.moka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.dao.SysResourcesData;
import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年11月28日 下午3:04:20
**/
@RestController
@RequestMapping("api/erp/v1/resources")
public class ChSysResources {
	
	@Autowired
	private SysResourcesData sysResourcesData;
	
	/**
	 * 获取权限列表接口
	 * @return
	 */
	@GetMapping("list")
	public Result<?> list (){
		List<?> list= sysResourcesData.selectSysResources();
		return Result.create(list);
	}
	
}
