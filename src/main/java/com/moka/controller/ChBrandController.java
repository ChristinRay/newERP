package com.moka.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.dao.ChBrandData;
import com.moka.result.Result;
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
	@Autowired
	private ChBrandData chBrandData;
	/**
	 * 品牌查询接口(缓存)
	 * @param entity
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("list")
	public  Result<?> list () {
		return Result.create(chBrandData.selectChBrandAll()); 
	}
	
	
	
}











