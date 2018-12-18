package com.moka.model;

import com.moka.Enum.CodeEnum;
import com.moka.utils.ParamPreconditions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChBcmOrderManagement extends BaseModel {

	/**
	 *交行订单管理
	 */
	private static final long serialVersionUID = 1L;
	private Long orderNumber;
	private String orderTime;
	private String consigneeName;
	private String consigneeContact;
	private String consigneeAddress;
	private String goodsNumber;
	private String goodsName;
	private String buyType;
	private String goodsStatus;
	private String distributorName;
	private Long distributorNumber;
	private String deliveryTime;
	private String orderType;
	private String paymentType;
	private Integer userId;
	private String state;
	private String createtime;
	private String updatetime;
	private String orderPlatform;
	
	
	
	public void check(){
//		ParamPreconditions.checkNotEmpty(CodeEnum.FAIL.getCode(), "必要字段不能为空", "必要字段不能为空", orderNumber,orderTime,consigneeName
//				,consigneeContact,consigneeAddress,goodsNumber,goodsName,buyType
//				,goodsStatus,distributorName,distributorNumber,deliveryTime
//				,orderType,paymentType);
		ParamPreconditions.checkNotNull(userId, CodeEnum.FAIL.getCode(), "录入人id不能为空");
	}
	


}
