package com.moka.dto;

import lombok.Getter;
import lombok.Setter;

/**
* @author    created by lbq
* @date	     2018年10月23日 下午3:36:45
**/
@Getter
@Setter
public class ChProductItemSupplyDto {
	private Integer supplyId;//供应商id
	private Integer productId;//商品id
	private String supplyName;//供应商名称
	private String brandCode;//品牌Code
	private String productCode;//商品Code
	private String productUnit;//单位
	private String productWeight;//重量
	private String productName;//商品名称
	private String sku;//商品的sku
	private String brandName;//品牌名称
	private String typeName;//种类名称
	private String productType;//种类
	
}
