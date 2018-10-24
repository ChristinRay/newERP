package com.moka.service;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.ChProductItemData;
import com.moka.dto.ChProductItemDto;
import com.moka.dto.ChProductItemSupplyDto;
import com.moka.model.ChProductItem;
import com.moka.req.ChProductItemAddReq;
import com.moka.req.ChProductItemSupplyReq;
import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年10月17日 下午7:37:40
**/
@Service
public class ChproductItemService {
	@Autowired
	private ChProductItemData  chProductItemData;
	
	@Autowired
	private ChBrandService chBrandService;
	
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
			return Result.create("OK","添加成功");
		}
		return Result.create("ERROR","添加失败");
	}
	/**
	 * 查询商品供应商详情Service
	 * @param ChProductItem
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public List<ChProductItemDto> list(ChProductItem ChProductItem) throws UnsupportedEncodingException{
		List<ChProductItemDto> list= chProductItemData.selectChProductItemByLimt(ChProductItem);
		for (ChProductItemDto chProductItemDto : list) {
			String brandName= chBrandService.findNameByCode(chProductItemDto.getBrandCode());
			chProductItemDto.setBrandName(brandName);
		}
		return list;
	}
	/**
	 * 查询总记录数
	 * @param chProductItem
	 * @return
	 */
	public int selectChProductByCount(ChProductItem chProductItem){
		int a =chProductItemData.selectChProductItemByCount(chProductItem);
		return a;
	}
	
	/**
	 * 根据品牌查供应商信息接口
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public List<ChProductItemSupplyDto> findSupplyByBrand(ChProductItemSupplyReq req) throws UnsupportedEncodingException{
		List<ChProductItemSupplyDto> list= chProductItemData.findSupplyByBrand(req); 
		for (ChProductItemSupplyDto chProductItemSupplyDto : list) {
			String brandName= chBrandService.findNameByCode(chProductItemSupplyDto.getAccreditBrand());
			chProductItemSupplyDto.setBrandName(brandName);
		}
		return list;
	}

}
