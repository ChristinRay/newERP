package com.moka.req;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年12月11日 上午10:52:30
**/
@Data
public class ChannelItemReq {
	private Integer  id;
	private String   orderBy;
	private Integer  limit;
	private Integer  limitLen;
	private Integer  pageIndex;//页码
	private Integer  pageSize;//页数
	private String   state;//状态
	private Integer  productId;
	private Integer  channelId;
	private String   channelProductName;//渠道上架名称
	private String   commission;//全额佣金
	private String   integral;//全佣金积分
	private String   staging;//分期佣金
	private Integer  userId;//录入人
	private String   createtime;
	private String   updatetime;
	
	
}
