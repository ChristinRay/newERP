package com.moka.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author created by lbq
 * @date 2018年10月23日 下午3:47:45
 **/
@Getter
@Setter
public class ChProductItemSupplyReq {
	private Integer supplyId;// 供应商ID
	private Integer productId;// 商品ID
	private String  brandCode;// 品牌名称
	private String  productName;// 商品名称
	private String  productType;// 商品类型
}
