package com.moka.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
* @author    created by lbq
* @date	     2018年10月31日 下午4:52:49
**/
@Getter
@Setter
public class ChPurchaseDto {
	private Integer id;
	private Integer supplyId;//供应商id
	private Integer companyId;//公司id
	private String brandCode;//品牌id
	private String productCode;//商品编码
	private String productName;//商品名称
	private String productSize;//商品
	private String productType;//商品类型
	private String productUnit;//商品单位
	private String productWeight;//商品重量
	private BigDecimal purchasePrice;//商品单价
	private String supplyProductNo;//供应商商品编号
	private String supplyCode;//供应商编码
	private String supplyName;//供应商名称
	private String companyName;//公司名称
	
}
