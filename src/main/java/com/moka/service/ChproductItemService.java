package com.moka.service;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChProductItemData;
import com.moka.dto.ChProductItemDto;
import com.moka.dto.ChProductItemSupplyDto;
import com.moka.model.ChProductItem;
import com.moka.model.TDataDict;
import com.moka.req.ChProductItemAddReq;
import com.moka.req.ChProductItemSupplyReq;
import com.moka.result.Result;

import lombok.extern.slf4j.Slf4j;

/**
* @author    created by lbq
* @date	     2018年10月17日 下午7:37:40
**/
@Service
@Slf4j
public class ChproductItemService {
	@Autowired
	private ChProductItemData  chProductItemData;
	@Autowired
	private ChCategoryService chCategoryService;
	@Autowired
	private DictionaryService dictionaryService;
	
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
	public List<ChProductItemDto> list(ChProductItem chProductItem) throws UnsupportedEncodingException{
		chProductItem.setState("1");
		List<ChProductItemDto> list= chProductItemData.selectChProductItemByLimt(chProductItem);
		for (ChProductItemDto chProductItemDto : list) {
			String brandName= chProductItemDto.getBrandCode();
			String typeName=  chCategoryService.findNameByCode(chProductItemDto.getProductType());
			chProductItemDto.setBrandName(brandName);
			chProductItemDto.setTypeName(typeName);
		}
		return list;
	}
	/**
	 * 查询总记录数
	 * @param chProductItem
	 * @return
	 */
	public int selectChProductByCount(ChProductItem chProductItem){
		chProductItem.setState("1");
		int a =chProductItemData.selectChProductItemByCount(chProductItem);
		return a;
	}
	
	/**
	 * 根据品牌查供应商信息接口
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public List<ChProductItemSupplyDto> findProductByBrand(ChProductItemSupplyReq req) throws UnsupportedEncodingException{
		List<ChProductItemSupplyDto> list= chProductItemData.findProductByBrand(req); 
		
		for (ChProductItemSupplyDto chProductItemSupplyDto : list) {
			String brandName= chProductItemSupplyDto.getBrandCode();
			chProductItemSupplyDto.setBrandName(brandName);//品牌翻译
			String typeName=chCategoryService.findNameByCode(chProductItemSupplyDto.getProductType());//商品类型翻译
			TDataDict dict= dictionaryService.getValueById(Integer.parseInt(chProductItemSupplyDto.getProductUnit()));
			chProductItemSupplyDto.setProductUnitName(dict.getValue());
			chProductItemSupplyDto.setTypeName(typeName);
		}
		return list;
	}
	/**
	 * 查询一条商品和供应商的信息
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public Result<?> getOne(Integer id) throws UnsupportedEncodingException{
		ChProductItemDto chProductItemDto= chProductItemData.selectOne(id);
		try {
			String brandName= chProductItemDto.getBrandCode();
			String typeName=  chCategoryService.findNameByCode(chProductItemDto.getProductType());
			chProductItemDto.setBrandName(brandName);
			chProductItemDto.setTypeName(typeName);
		} catch (NullPointerException e) {
			log.info("Service错误"+e.getMessage());
			return Result.create(CodeEnum.FAIL.getCode(), "数据错误");
		} catch (Exception e){
			log.info("其他业务异常"+e.getLocalizedMessage());
			return Result.create(CodeEnum.FAIL.getCode(), "未知错误");
		}
		return Result.create(chProductItemDto);
	}
}
