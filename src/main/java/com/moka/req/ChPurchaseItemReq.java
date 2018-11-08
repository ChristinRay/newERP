package com.moka.req;

import com.moka.Enum.CodeEnum;
import com.moka.utils.ParamPreconditions;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年11月8日 上午11:01:00
**/
@Data
public class ChPurchaseItemReq {
	private String purBillsId;
	
	public void check(){
		ParamPreconditions.checkNotEmpty(purBillsId, CodeEnum.FAIL.getCode(), "订单id不能为空", "订单id不能为空");
	}
}
