package com.moka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.ChPurchaseOrderData;
import com.moka.model.ChPurchaseDto;
import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年10月31日 下午4:04:23
**/
@Service
public class ChPurchaseService {
	@Autowired
	private ChPurchaseOrderData chPurchaseOrderData;
	
	public Result<?> selectChPurchaseAll(ChPurchaseDto purchaseDto){
		List<ChPurchaseDto> dtos= chPurchaseOrderData.selectChPurchaseAll(purchaseDto);
		
		return Result.create(dtos);
	}
	
}
