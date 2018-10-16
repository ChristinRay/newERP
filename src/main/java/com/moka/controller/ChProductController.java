package com.moka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.req.ChProductReq;
import com.moka.result.Result;
import com.moka.service.ChProductService;

/**
* @author    created by lbq
* @date	     2018年9月13日 下午5:25:19
**/
@RestController
@RequestMapping("/api/erp/v1/product")
public class ChProductController {
	
	@Autowired
	private ChProductService chProductService;
	
	
	/**
	 * 商品添加
	 * @return
	 */
	@PostMapping("add")
	public Result<?> add(@RequestBody ChProductReq chProduct){
		
		return chProductService.add(chProduct);
	}
}










