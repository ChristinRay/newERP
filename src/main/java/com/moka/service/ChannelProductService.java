package com.moka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.ChProductData;
import com.moka.dao.ChProductItemData;
import com.moka.model.ChProduct;
import com.moka.req.ChannelProductReq;
import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年12月7日 下午3:14:34
**/
@Service
public class ChannelProductService {
	@Autowired
	private ChProductItemData  chProductItemData;
	@Autowired
	private ChProductData chProductData;
	
	
	public Result<?> findProduct(ChannelProductReq req){
		
		return null;
	}
}
