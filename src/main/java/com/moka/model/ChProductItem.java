package com.moka.model;

import java.lang.Integer;
import java.math.BigDecimal;

import com.moka.Enum.CodeEnum;
import com.moka.utils.ParamPreconditions;

import java.lang.String;

import lombok.Getter;
import lombok.Setter;
/**
 * 商品供应商详情表
 * modle
 */
@Setter
@Getter
public class ChProductItem extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer  productId;//商品id
	private Integer  supplyId;//供应商id
	private String  brandCode;//品牌编码
	private String  supplyProductNo;//供应商商品编码
	private BigDecimal  purchasePrice;//进货价
	private BigDecimal  packPrice;//包装费
	private BigDecimal  freightPrice;//运费
	private Integer  userId;
	private String  createtime;
	private String  updatetime;
	
	public void check(){
		ParamPreconditions.checkNotNull(productId, CodeEnum.FAIL.getCode(), "商品id不能为空");
		ParamPreconditions.checkNotNull(supplyId, CodeEnum.FAIL.getCode(), "供应商id不能为空");
		ParamPreconditions.checkNotEmpty(brandCode, CodeEnum.FAIL.getCode(), "品牌id不能为空");
		ParamPreconditions.checkNotEmpty(supplyProductNo,CodeEnum.FAIL.getCode(), "供应商商品编码不能为空");
		ParamPreconditions.checkNumberByDecimals(purchasePrice, 0, CodeEnum.FAIL.getCode(), "进货价金额必须大于0");
		ParamPreconditions.checkNumberByDecimals(purchasePrice, 0, CodeEnum.FAIL.getCode(), "包装费金额必须大于0");
		ParamPreconditions.checkNumberByDecimals(purchasePrice, 0, CodeEnum.FAIL.getCode(), "运费金额必须大于0");
	}

	
}
