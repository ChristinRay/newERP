package com.moka.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moka.dao.ChPurchaseOrderData;
import com.moka.dto.ChProductListDto;
import com.moka.dto.ChPurchaseDto;
import com.moka.model.ChPurchaseItem;
import com.moka.model.ChPurchaseOrder;
import com.moka.req.ChPurchaseAddReq;
import com.moka.req.ChPurchaseAllReq;
import com.moka.req.ChPurchaseItemReq;
import com.moka.req.ChPurchaseSupplyReq;
import com.moka.result.Result;
import com.moka.utils.DateTimes;

import lombok.extern.slf4j.Slf4j;

/**
* @author    created by lbq
* @date	     2018年10月31日 下午4:04:23
**/
@Service
@Slf4j
public class ChPurchaseService {
	@Autowired
	private ChPurchaseOrderData chPurchaseOrderData;
	@Autowired
	private ChCompanyService chCompanyService;
	
	
	
	/**
	 * 查询采购订单列表
	 * @param purchaseDto
	 * @return
	 */
	public Result<?> selectChPurchaseAll(ChPurchaseAllReq req){
		List<ChPurchaseDto> dtos= chPurchaseOrderData.selectChPurchaseAll(req);
		
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
	@Transactional
	public Result<?> add(ChPurchaseAddReq req){
		ChPurchaseOrder entity=new ChPurchaseOrder();
		String supplyCode = req.getSupplyCode();
		String purBillsId =supplyCode+"-"+DateTimes.nowDateTimetrim();
		entity.setPurBillsId(purBillsId);//订单id
		entity.setPurBillsDate(req.getPurBillsDate());//采购单据日期
		entity.setPurOrderType(req.getPurOrderType());//采购订单类型
		entity.setPurBillsType("1");//单据状态(新下的采购订单为1)
		entity.setPredictTime(req.getPredictTime());//预计到货日期
		entity.setCompanyId(req.getCompanyId());//我司ID
		entity.setSupplyId(req.getSupplyId());
		entity.setState("1");//数据状态 1正常
		entity.setUserId(req.getUserId());
		entity.setDepotId(req.getDepotId());//仓库id
		List<ChPurchaseItem> list=  req.getPurchaseList();
		//订单金额
		BigDecimal price=list.stream().map(ChPurchaseItem::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);//lambda表达式
		
		BigDecimal elsePrice=new BigDecimal("0");
		for (ChPurchaseItem chPurchaseItem : list) {
			if(Objects.isNull(chPurchaseItem.getElsePrice())){
			}else{
				elsePrice= elsePrice.add(chPurchaseItem.getElsePrice());
			}
		}
		entity.setPrice(price.add(elsePrice));
		int aa= chPurchaseOrderData.insertChPurchaseOrder(entity);//订单表
		if(aa==1){
			log.info("订单表添加成功");
		}else{
			return Result.create("ERROR", "添加失败");
		}
		for (ChPurchaseItem chPurchaseItem : list) {
			chPurchaseItem.setPurBillsId(purBillsId);
		 	int a= chPurchaseOrderData.insertChPurchaseOrderItem(chPurchaseItem);//订单详情表
		 	if(a==1){
		 		log.info("订单详情添加成功");
		 	}else{
		 		return Result.create("ERROR", "订单详情添加失败");
		 	}
		}
		return Result.create(entity.getId());
	}
	
	/**
	 * 查询订单列表
	 * @param order
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public List<ChProductListDto> list (ChPurchaseOrder order) throws UnsupportedEncodingException{
		List<ChProductListDto> list=chPurchaseOrderData.selectChPurchaseOrderByLimt(order);
		for (ChProductListDto chProductListDto : list) {
			String companyName= chCompanyService.findNameById(chProductListDto.getCompanyId());
			chProductListDto.setCompanyName(companyName);
		}
		return list;
	}
	/**
	 * 查询订单详情列表
	 * @param req
	 * @return
	 */
	public Result<?> listItem(ChPurchaseItemReq req){
		List<ChPurchaseItem> list=chPurchaseOrderData.listItem(req);
		
		return Result.create(list);
	}
}













