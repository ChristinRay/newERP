package com.moka.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.ChProductItemData;
import com.moka.dto.ChProductItemDto;
import com.moka.model.ChProductItem;
import com.moka.req.ChProductItemAddReq;
import com.moka.req.ChProductItemListReq;
import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年10月17日 下午7:37:40
**/
@Service
public class ChproductItemService {
	@Autowired
	private ChProductItemData  chProductItemData;
	/**
	 * 添加商品供应商详情
	 * @param chProductItemAddReq
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Result<?> add(ChProductItemAddReq chProductItemAddReq) throws IllegalAccessException, InvocationTargetException{
		ChProductItem  chProductItem=new ChProductItem();
		BeanUtils.copyProperties(chProductItem, chProductItemAddReq);
		
		chProductItem.setState("1");
		int a= chProductItemData.insertChProductItem(chProductItem);
		if(a==1){
			return Result.create(chProductItem.getId());
		}
		
		
		return Result.create("ERROR","添加失败");
	}
	/**
	 * 
	 * @param ChProductItem
	 * @return
	 */
	public Result<?> list(ChProductItem ChProductItem){
		List<ChProductItemDto> list= chProductItemData.selectChProductItemByLimt(ChProductItem);
		return null;
	}
	
}
