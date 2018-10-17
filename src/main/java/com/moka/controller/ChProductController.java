package com.moka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.model.ChProduct;
import com.moka.req.ChProductReq;
import com.moka.result.Result;
import com.moka.service.ChProductService;
import com.moka.service.CommonService;

/**
* @author    created by lbq
* @date	     2018年9月13日 下午5:25:19
**/
@RestController
@RequestMapping("/api/erp/v1/product")
public class ChProductController {
	
	@Autowired
	private ChProductService chProductService;
	@Autowired
	private CommonService commonService;
	
	/**
	 * 商品添加
	 * @return
	 */
	@PostMapping("add")
	public Result<?> add(@RequestBody ChProductReq chProduct){
		chProduct.check();
		return chProductService.add(chProduct);
	}
	/**
	 * 商品查询接口
	 * @param product
	 * @return
	 */
	@PostMapping("list")
	public Result<?> list(@RequestBody ChProduct product){
		if(commonService.paginationSupport(product.getPageIndex(), product.getPageSize())) {
			int count = chProductService.selectChProductByCount(product);
			int[] page = commonService.getLimit(product.getPageIndex(), product.getPageSize());
			product.setLimit(page[0]);
			product.setLimitLen(page[1]);
			product.setOrderBy("updatetime");
			List<ChProduct> result = chProductService.selectChProductByLimt(product);
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
	
}










