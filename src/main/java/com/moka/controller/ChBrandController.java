package com.moka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.model.ChBrand;
import com.moka.result.Result;
import com.moka.result.ResultFul;
import com.moka.service.ChBrandService;

/**
* @author    created by lbq
* @date	     2018年9月17日 下午4:37:43
**/
@RestController
@RequestMapping("/api/erp/v1/brand")
public class ChBrandController {
	
	@Autowired
	private ChBrandService chBrandService;

	@PostMapping("add")
	public  ResultFul add (@RequestBody ChBrand entity){
		entity.check();
		return chBrandService.add(entity);
	}
	
}
