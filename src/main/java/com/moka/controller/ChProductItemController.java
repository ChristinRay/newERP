package com.moka.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.model.ChProductItem;
import com.moka.req.ChProductItemAddReq;
import com.moka.result.Result;
import com.moka.service.ChproductItemService;

/**
* @author    created by lbq
* @date	     2018年10月17日 下午7:29:16
**/
@RestController
@RequestMapping("/api/erp/v1/product/item")
public class ChProductItemController {
	
	@Autowired
	private ChproductItemService chproductItemService;
	/**
	 * 添加商品供应商信息
	 * @param chProductItemAddReq
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@PostMapping("add")
	public Result<?> add(@RequestBody ChProductItemAddReq chProductItemAddReq) throws IllegalAccessException, InvocationTargetException{
		chProductItemAddReq.check();
		return chproductItemService.add(chProductItemAddReq);
	}
	
	@PostMapping("list")
	public Object list(@RequestBody ChProductItem ChProductItem){
		chproductItemService.list(ChProductItem);
		
		return null;
	}
}











