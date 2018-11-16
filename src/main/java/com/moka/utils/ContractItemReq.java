package com.moka.utils;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年11月15日 下午4:00:00
**/
@Data
public class ContractItemReq {
	private String productName;//商品名称
	private String purNumber;//数量
	private String productUnit;//单位
	private String productPrice;//单价
	private String pack;
	private String money;//金额
	private String memo;//备注
	
}
