package com.moka.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年9月11日 下午1:57:10
**/
@Data
public class BaseModel implements Serializable {
	private static final long serialVersionUID = -5176710723548779263L;
	//@ApiModelProperty(value = "主键ID", name = "id")
	private Integer id;
	private String orderBy;
	private Integer limit;
	private Integer limitLen;
	private Integer pageIndex;//页码
	private Integer pageSize;//页数
	private String state;//状态
	


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public BaseModel buildLimit(Integer limit) {
		this.limit = limit;
		return this;
	}
	public BaseModel buildLimitLen(Integer limitLen) {
		this.limitLen = limitLen;
		return this;
	}
	public BaseModel buildOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}
	public BaseModel buildPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
		return this;
	}
	public BaseModel buildPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}
	public BaseModel buildState(String state) {
		this.state = state;
		return this;
	}


}
