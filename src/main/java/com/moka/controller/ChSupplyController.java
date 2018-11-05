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
import com.moka.dao.ChSupplyData;
import com.moka.model.ChSupply;
import com.moka.result.Result;
import com.moka.service.ChBrandService;
import com.moka.service.ChSupplyService;
import com.moka.service.CommonService;
import com.moka.utils.ParamPreconditions;

/**
* @author    created by lbq
* @date	     2018年10月10日 上午11:44:08
**/
@RestController
@RequestMapping("/api/erp/v1/supply")
public class ChSupplyController {
	@Autowired
	private ChSupplyService chSupplyService;
	
	@Autowired
	private ChSupplyData chSupplyData;
	
	@Autowired
	private CommonService commonService;
	@Autowired
	private ChBrandService chBrandService;
	
	/**
	 * 供应商添加
	 * @param chSupply
	 * @return
	 */
	@PostMapping("add")
	public Result<?> add (@RequestBody ChSupply chSupply){
		chSupplyService.add(chSupply);
		return Result.create("添加成功");
	}
	/**
	 * 供应商列表接口
	 * @param chSupply
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("list")
	public Result<?> list(@RequestBody ChSupply chSupply) throws UnsupportedEncodingException {
		if(commonService.paginationSupport(chSupply.getPageIndex(), chSupply.getPageSize())) {
			int count = chSupplyData.selectChSupplyByCount(chSupply);
			int[] page = commonService.getLimit(chSupply.getPageIndex(), chSupply.getPageSize());
			chSupply.setLimit(page[0]);
			chSupply.setLimitLen(page[1]);
			chSupply.setOrderBy("updatetime");
			List<ChSupply> result = chSupplyData.selectChSupplyByLimt(chSupply);
			for (ChSupply chSupply2 : result) {
				String brandName= chBrandService.findNameByCode(chSupply2.getAccreditBrand());
				chSupply2.setAccreditBrandName(brandName);
			}
			return Result.createPage(result,(long)count);
		}
		return Result.create("未传分页");
	}
	/**
	 * 修改接口
	 * @param chSupply
	 * @return
	 */
	@PostMapping("update")
	public Result<?> update(@RequestBody ChSupply chSupply){
		int a= chSupplyService.update(chSupply);
		if(a==1){
			return Result.create("OK", "修改成功");
		}
		return Result.create("ERROR", "修改失败");
	}
	/**
	 * 得到一个供应商
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("get/one")
	public Result<?> getOne(Integer id) throws UnsupportedEncodingException{
		ParamPreconditions.checkNotNull(id, CodeEnum.FAIL.getCode(), "id不能为空");
		return Result.create(chSupplyService.getOne(id));
	}
	/**
	 * 删除一条供应商信息
	 * @param id
	 * @return
	 */
	@GetMapping("delete")
	public Result<?> delete(Integer id){
		int a= chSupplyData.deleteByLogic(id);
		if(a==1){
			return Result.create("OK","操作成功");
		}
		return Result.create("ERROR","操作失败");
	}
	/**
	 * 禁用一条供应商信息
	 * @param id
	 * @return
	 */
	@GetMapping("state")
	public Result<?> updateState(Integer id){
		int a= chSupplyData.updateState(id);
		if(a==1){
			return Result.create("OK","操作成功");
		}
		return Result.create("ERROR","操作失败");
	}
}













