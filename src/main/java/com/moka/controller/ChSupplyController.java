package com.moka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChSupplyData;
import com.moka.model.ChSupply;
import com.moka.result.Result;
import com.moka.service.ChSupplyService;
import com.moka.utils.ParamPreconditions;

/**
* @author    created by lbq
* @date	     2018年10月10日 上午11:44:08
**/
@RestController
@RequestMapping("/api/erp/v1/sypply")
public class ChSupplyController {
	@Autowired
	private ChSupplyService chSupplyService;
	
	
	@PostMapping("add")
	public Result<?> add (@RequestBody ChSupply chSupply){
		chSupplyService.add(chSupply);
	

		return Result.create("添加成功");
	}
}
