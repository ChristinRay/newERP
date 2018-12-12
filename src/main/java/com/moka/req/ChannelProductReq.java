package com.moka.req;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年12月7日 下午3:12:01
**/
@Data
public class ChannelProductReq {
	private Integer productItemId;
	private Integer channelId;
	private String  channelProductName;//渠道上架名称
	private String  commission;//全额佣金
	private String  integral;//全佣金积分
	private String  staging;//分期佣金
	
}
