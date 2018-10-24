package com.moka.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
* @author    created by lbq
* @date	     2018年10月17日 下午8:25:40
**/
@Setter
@Getter
public class ChProductItemDto {
	private Integer  productId;//商品id
	private Integer  supplyId;//供应商id
	private String  brandCode;//品牌编码
	private String  brandName;//品牌名称
	private String  productCode;//商品编码
	private String  productType;//商品类型
	private String  productUnit;//商品单位
	private String  productWeight;//商品重量
	private String  sku;//商品sku名称
	private String  supplyProductNo;//供应商商品编码
	private BigDecimal  purchasePrice;//进货价
	private BigDecimal  packPrice;//包装费
	private BigDecimal  freightPrice;//运费
	private String freightway;//运费类型
	private Integer  userId;
	private String  createtime;
	private String  updatetime;
	
}
