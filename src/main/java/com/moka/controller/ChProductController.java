package com.moka.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChProductData;
import com.moka.dto.ChProductDto;
import com.moka.model.ChProduct;
import com.moka.req.ChProductReq;
import com.moka.result.Result;
import com.moka.service.ChProductService;
import com.moka.service.CommonService;
import com.moka.utils.ParamPreconditions;

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
	@Autowired
	private ChProductData chProductData;
	
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
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("list")
	public Result<?> list(@RequestBody ChProduct product) throws UnsupportedEncodingException{
		if(commonService.paginationSupport(product.getPageIndex(), product.getPageSize())) {
			int count = chProductService.selectChProductByCount(product);
			int[] page = commonService.getLimit(product.getPageIndex(), product.getPageSize());
			product.setLimit(page[0]);
			product.setLimitLen(page[1]);
			product.setOrderBy("updatetime");
			List<ChProductDto> result = chProductService.selectChProductByLimt(product);
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
	
	/**
	 * 根据id 逻辑删除一个商品信息
	 * @param id
	 * @return
	 */
	@GetMapping("delete")
	public Result<?> delete(Integer id){
		int a= chProductData.deleteByLogic(id);
		if(a==1){
			return Result.create("OK","删除成功");
		}
		return Result.create("ERROR","删除失败");
	}
	/**
	 * 根据id得到一个公司
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("get/one")
	public Result<?> getOne(Integer id) throws UnsupportedEncodingException{
		ParamPreconditions.checkNotNull(id, CodeEnum.FAIL.getCode(), "id不能为空");
		 
		return Result.create(chProductService.selectOne(id));
	}
}










