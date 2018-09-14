package com.moka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moka.dao.ChProductData;
import com.moka.model.ChProduct;
import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年9月13日 下午5:42:27
**/
@Service
public class ChProductService {

	@Autowired
	private ChProductData chProductData;
	
	@Transactional
	public Object add(ChProduct entity){
		int a= chProductData.insertChProduct(entity);
		if(a==1) return Result.create("OK", "商品添加成功");
		
		return Result.create("ERROR", "添加失败");
	}
}
