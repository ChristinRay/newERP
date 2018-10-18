package com.moka.service;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.moka.dao.ChProductData;
import com.moka.dto.ChProductDto;
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
	
	@Autowired
	private RedisTemplate  redisTemplate;
	
	@Autowired
	private ChBrandService chBrandService;
	
	@Autowired
	private ChCategoryService chCategoryService;
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
	
	 /** 分页查询ListService
	 * @param product
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public List<ChProductDto> selectChProductByLimt(ChProduct product) throws UnsupportedEncodingException{
		product.setState("1");
		List<ChProductDto> list= chProductData.selectChProductByLimt(product);
		
		
		for (ChProductDto chProductDto : list) {
			String brandName= chBrandService.findNameByCode(chProductDto.getBrandCode());
			String typeName=  chCategoryService.findNameByCode(chProductDto.getProductType());
			chProductDto.setBrandName(brandName);
			chProductDto.setProductTypeName(typeName);
		}
		
		return list;
	}
	/**
	 * 得到一个商品信息
	 * @param id
	 * @return
	 */
	public Object selectOne(int id){
		chProductData.selectOne(id);
		return null;
	}
}





