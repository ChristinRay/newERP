package com.moka.dto;

import java.math.BigDecimal;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年12月11日 下午8:13:47
**/
@Data
public class ChannelItemDto {
	private Integer id;
	private String channelName;
	private String channelProductName;
	private String commission;
	private String integral;
	private String staging;
	private BigDecimal channelPrice;
	private BigDecimal purchasePrice;
	private String sku;
	private String name;
	private String createtime;
}
