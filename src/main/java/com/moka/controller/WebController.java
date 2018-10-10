package com.moka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.dao.UserMapper;
import com.moka.model.SysUser;
import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年9月25日 下午7:46:56
**/
@RestController
@RequestMapping("/api/erp/v1/web")
public class WebController {
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("add")
	public  Object ceshi (String userName,String passWord){
		userMapper.addUser(userName, passWord);
		return Result.create("OK");
	}
	
	@GetMapping("get/one")
	public  Object ceshi (Integer id ){
		SysUser sysUser= userMapper.findById(id);
		return Result.create(sysUser);
	}
}
