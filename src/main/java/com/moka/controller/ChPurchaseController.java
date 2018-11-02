package com.moka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.Enum.CodeEnum;
import com.moka.req.ChPurchaseAddReq;
import com.moka.req.ChPurchaseAllReq;
import com.moka.req.ChPurchaseSupplyReq;
import com.moka.result.Result;
import com.moka.service.ChPurchaseService;
import com.moka.utils.ParamPreconditions;

/**
* @author    created by lbq
* @date	     2018年10月31日 下午3:50:48
**/
@RestController
@RequestMapping("/api/erp/v1/pur/")
public class ChPurchaseController {
	@Autowired
	private ChPurchaseService chPurchaseService;
	/**
	 * 查找商品接口
	 * @param 
	 * @return
	 */
	@PostMapping("all")
	public Result<?> selectChPurchaseAll(@RequestBody ChPurchaseAllReq req){
		
		return chPurchaseService.selectChPurchaseAll(req);
	}
	/**
	 * 下单接口
	 * @return
	 */
	@PostMapping("add")
	public Result<?> addChPurchase(@RequestBody ChPurchaseAddReq req){
		req.check();
		
		
		return chPurchaseService.add(req);
	}
	
	/**
	 * 根据采购公司的品牌编码查询供应商信息
	 * @param req
	 * @return
	 */
	@PostMapping("findSupplyByCompany")
	public Result<?> findSupplyByCompany(@RequestBody ChPurchaseSupplyReq req){
		ParamPreconditions.checkNotNull(req.getCompanyId(), CodeEnum.FAIL.getCode(), "公司Id不能为空");
		return chPurchaseService.findSupplyByCompany(req);
	}
}
