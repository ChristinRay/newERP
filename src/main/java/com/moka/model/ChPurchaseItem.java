package com.moka.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
* @author    created by lbq
* @date	     2018年11月1日 下午2:00:45
**/
@Getter
@Setter
public class ChPurchaseItem {
	private Integer purBillsId;//采购订单编号
	private Integer productItemId;//商品详情id
	private Integer purNumber;//商品数量
	private BigDecimal money;//金额（商品单价*采购数量）
	private String productDepot;//'商品的库存数量
}
