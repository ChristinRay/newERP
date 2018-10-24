package com.moka.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.dto.ChProductItemDto;
import com.moka.dto.ChProductItemSupplyDto;
import com.moka.model.ChProductItem;
import com.moka.req.ChProductItemAddReq;
import com.moka.req.ChProductItemSupplyReq;
import com.moka.result.Result;
import com.moka.service.ChproductItemService;
import com.moka.service.CommonService;

/**
* @author    created by lbq
* @date	     2018年10月17日 下午7:29:16
**/
@RestController
@RequestMapping("/api/erp/v1/product/item")
public class ChProductItemController {
	
	@Autowired
	private ChproductItemService chproductItemService;
	@Autowired
	private CommonService commonService;
	
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
	/**
	 * 查询商品供应商详情Controller
	 * @param ChProductItem
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("list")
	public Object list(@RequestBody ChProductItem chProductItem) throws UnsupportedEncodingException{
		if(commonService.paginationSupport(chProductItem.getPageIndex(), chProductItem.getPageSize())) {
			int count = chproductItemService.selectChProductByCount(chProductItem);
			int[] page = commonService.getLimit(chProductItem.getPageIndex(), chProductItem.getPageSize());
			chProductItem.setLimit(page[0]);
			chProductItem.setLimitLen(page[1]);
			chProductItem.setOrderBy("updatetime");
			List<ChProductItemDto> result = chproductItemService.list(chProductItem);
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
	/**
	 * 查询已授权品牌信息和供应商下商品基本信息
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("get/supply")
	public Result<?> findSupplyByBrand(@RequestBody ChProductItemSupplyReq req) throws UnsupportedEncodingException{
		
		
		return Result.create(chproductItemService.findSupplyByBrand(req));
	}
	
}











