package com.moka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.model.ChPurchaseDto;
import com.moka.result.Result;
import com.moka.service.ChPurchaseService;

/**
* @author    created by lbq
* @date	     2018年10月31日 下午3:50:48
**/
@RestController
@RequestMapping("/api/erp/v1/pur/")
public class ChPurchaseController {
	@Autowired
	private ChPurchaseService chPurchaseService;
	
	@PostMapping("all")
	public Result<?> selectChPurchaseAll(@RequestBody ChPurchaseDto purchaseDto){
		
		return chPurchaseService.selectChPurchaseAll(purchaseDto);
	}
	
	
	
	
	
	
	
}
