package com.moka.service;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;

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
	 * 商品添加逻辑
	 * @param entity
	 * @return
	 */
	@Transactional
	public Result<?> add(ChProductReq entity){
		String productSize= JSON.toJSONString(entity.getProductSize());
		ProductSize size=entity.getProductSize();
		String  sku="";
		//商品sku名称组合（空格分隔）：品牌+系列英文名+系列中文名+风格+材质+男士/女士+名称+容积+尺寸+厚度+颜色+型号
		
		sku=entity.getBrandCode()+size.getEnglish()+size.getChinese()+size.getStyle()
		+size.getMaterial()+size.getSex()+entity.getProductName()+size.getVolume()
		+size.getSize()+size.getThickness()+size.getColor()+size.getModel();
		
		
		ChProduct chProduct=new ChProduct();
		try {
			BeanUtils.copyProperties(chProduct, entity);
			chProduct.setProductSize(productSize);
			chProduct.setSku(sku);
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
	/**
	 * 记录数
	 * @param product
	 * @return
	 */
	public int selectChProductByCount(ChProduct product){
		product.setState("1");
		return  chProductData.selectChProductByCount(product);
	}
	
	 /** 分页查询
	 * @param product
	 * @return
	 */
	public List<ChProduct> selectChProductByLimt(ChProduct product){
		product.setState("1");
		
		return  chProductData.selectChProductByLimt(product);
	}
}





