package com.moka.req;

import lombok.Getter;
import lombok.Setter;

/**
* @author    created by lbq
* @date	     2018年10月23日 下午3:47:45
**/
@Getter
@Setter
public class ChProductItemSupplyReq {
	private Integer supplyId;
	private Integer productId;
	private String brandCode;
	private String productName;
}
