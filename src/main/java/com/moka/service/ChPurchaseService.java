package com.moka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.ChPurchaseOrderData;
import com.moka.dto.ChPurchaseDto;
import com.moka.model.ChPurchaseItem;
import com.moka.model.ChPurchaseOrder;
import com.moka.req.ChPurchaseAddReq;
import com.moka.req.ChPurchaseSupplyReq;
import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年10月31日 下午4:04:23
**/
@Service
public class ChPurchaseService {
	@Autowired
	private ChPurchaseOrderData chPurchaseOrderData;
	
	
	/**
	 * 查询采购订单列表
	 * @param purchaseDto
	 * @return
	 */
	public Result<?> selectChPurchaseAll(ChPurchaseDto purchaseDto){
		List<ChPurchaseDto> dtos= chPurchaseOrderData.selectChPurchaseAll(purchaseDto);
		
		return Result.create(dtos);
	}
	/**
	 * 根据采购公司的品牌编码查询供应商信息
	 * @param req
	 * @return
	 */
	public Result<?> findSupplyByCompany(ChPurchaseSupplyReq req){
		
		return Result.create(chPurchaseOrderData.findSupplyByCompany(req));
	}
	
	
	/**
	 * 下单接口
	 * @param req
	 * @return
	 */
	public Result<?> add(ChPurchaseAddReq req){
		ChPurchaseOrder entity=new ChPurchaseOrder();
		String supplyCode = req.getSupplyCode();
		String purBillsId =supplyCode+System.currentTimeMillis()+"";
		entity.setPurBillsId(purBillsId);//订单id
		entity.setPurBillsDate(req.getPurBillsDate());//采购单据日期
		entity.setPurOrderType(req.getPurOrderType());//采购订单类型
		entity.setPurBillsType("1");//单据状态(新下的采购订单为1)
		entity.setPredictTime(req.getPredictTime());//预计到货日期
		entity.setCompanyId(req.getCompanyId());//我司ID
		entity.setState("1");//数据状态 1正常
		
		List<ChPurchaseItem> list=  req.getPurchaseList();
		for (ChPurchaseItem chPurchaseItem : list) {
			chPurchaseItem.getMoney();
		}
		
		
		chPurchaseOrderData.insertChPurchaseOrder(entity);
		
		return Result.create("");
	}
	
	
}













