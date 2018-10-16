package com.moka.service;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.moka.dao.ChProductData;
import com.moka.model.ChProduct;
import com.moka.model.ProductSize;
import com.moka.req.ChProductReq;
import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年9月13日 下午5:42:27
**/
@Service
public class ChProductService {

	@Autowired
	private ChProductData chProductData;
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	@Transactional
	public Result<?> add(ChProductReq entity){
		String productSize= JSON.toJSONString(entity.getProductSize());
		ChProduct chProduct=new ChProduct();
		try {
			BeanUtils.copyProperties(chProduct, entity);
			chProduct.setProductSize(productSize);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		int a= chProductData.insertChProduct(chProduct);
		if(a==0){
			return Result.create("ERROR","添加商品失败");
		}
		return Result.create(chProduct.getId());
	}
}





