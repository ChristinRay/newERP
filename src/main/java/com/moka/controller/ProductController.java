package com.moka.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @author    created by lbq
* @date	     2018年9月10日 下午7:34:33
**/
@RestController
@RequestMapping(value = "/erp/v1/product/")
@Transactional(rollbackFor = Exception.class)
public class ProductController {
	@PostMapping("ceshi11")
	public String ceshi (){
		return "测试";
	}
}
