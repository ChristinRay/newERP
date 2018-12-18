package com.moka.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChProductItemData;
import com.moka.dto.ChProductItemDto;
import com.moka.model.ChProductItem;
import com.moka.req.ChProductItemAddReq;
import com.moka.req.ChProductItemSupplyReq;
import com.moka.result.Result;
import com.moka.service.ChproductItemService;
import com.moka.service.CommonService;
import com.moka.utils.ParamPreconditions;

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
	@Autowired
	private ChProductItemData  chProductItemData;
	
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
	 * 查询供应商与商品详情Controller
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
	 * 根据品牌 查商品基本信息
	 *         
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("get/supply")
	public Result<?> findSupplyByBrand(@RequestBody ChProductItemSupplyReq req) throws UnsupportedEncodingException{
		ParamPreconditions.checkNotEmpty(req.getBrandCode(), CodeEnum.FAIL.getCode(), "品牌名称不能为空", "品牌名称不能为空");

		return Result.create(chproductItemService.findProductByBrand(req));
	}
	
	/**
	 * 查询一条商品和供应商的信息
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GetMapping("get/one")
	public Result<?> getOne(Integer id) throws UnsupportedEncodingException{
		ParamPreconditions.checkNotNull(id, CodeEnum.FAIL.getCode(), "id不能为空");
		
		return chproductItemService.getOne(id);
	}
	
	
	/**
	 * 根据id 逻辑删除一个授权合作信息
	 * @param id
	 * @return
	 */
	@GetMapping("delete")
	public Result<?> delete(Integer id){
		ParamPreconditions.checkNotNull(id, CodeEnum.FAIL.getCode(), "id不能为空");
		int a= chProductItemData.deleteByLogic(id);
		if(a==1){
			return Result.create("OK","删除成功");
		}
		return Result.create("ERROR","删除失败");
	}
	
	
	/**
	 * 根据品牌名称查询供应商和商品信息的接口
	 * @return
	 */
	@PostMapping("new/getSupply")
	public Result<?> findSupplyAndProductByBrandName(String brandCode){
		
		return null;
	}
	
	
}











