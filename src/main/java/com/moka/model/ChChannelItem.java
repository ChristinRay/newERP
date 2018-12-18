package com.moka.model;

import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;

import com.moka.Enum.CodeEnum;
import com.moka.utils.ParamPreconditions;

import lombok.Getter;
import lombok.Setter;
/**
 * 渠道表
 * modle
 */
@Setter
@Getter
public class ChChannelItem extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer  productId;//授权产品id
	private Integer  channelId;//渠道id
	private String   channelProductName;//渠道上架名称
	private String   channelProductNo;//渠道商品编号
	private BigDecimal   channelPrice;
	private String   commission;//全额佣金
	private String   integral;//全佣金积分
	private String   staging;//分期佣金
	private Integer  userId;//录入人
	private String   createtime;
	private String   updatetime;


	public void check(){
		ParamPreconditions.checkNotEmpty(CodeEnum.FAIL.getCode(), "必要字段不能为空", "必要字段不能为空",commission,integral,staging,channelProductNo );
		ParamPreconditions.checkNotNull(productId, CodeEnum.FAIL.getCode(), "商品id不能为空");
		ParamPreconditions.checkNotNull(channelId, CodeEnum.FAIL.getCode(), "渠道id不能为空");
		ParamPreconditions.checkNotNull(userId, CodeEnum.FAIL.getCode(), "录入人id不能为空");
		ParamPreconditions.checkNumberByDecimals(channelPrice, 0, CodeEnum.FAIL.getCode(), "渠道售价金额必须大于0");
	}
	
}
