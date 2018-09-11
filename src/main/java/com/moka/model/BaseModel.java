package com.moka.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
* @author    created by lbq
* @date	     2018年9月11日 下午1:57:10
**/
public class BaseModel implements Serializable {
	private static final long serialVersionUID = -5176710723548779263L;
	private String orderBy;
	private Integer limit;
	private Integer limitLen;
	private Integer pageIndex;
	private Integer pageSize;
	private String approve_status;
	private Integer state;
	private String unique_flg;
	//@ApiModelProperty(value = "主键ID", name = "id")
	private Long id;
	private String approvalQry;
	
	

	public String getApprovalQry() {
		return approvalQry;
	}
	public void setApprovalQry(String approvalQry) {
		this.approvalQry = approvalQry;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUnique_flg() {
		return unique_flg;
	}
	public void setUnique_flg(String unique_flg) {
		this.unique_flg = unique_flg;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getApprove_status() {
		return approve_status;
	}
	public void setApprove_status(String approve_status) {
		this.approve_status = approve_status;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getLimitLen() {
		return limitLen;
	}
	public void setLimitLen(Integer limitLen) {
		this.limitLen = limitLen;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public BaseModel buildApprove_status(String approve_status) {
		this.approve_status = approve_status;
		return this;
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
	public BaseModel buildState(Integer state) {
		this.state = state;
		return this;
	}
	public BaseModel buildUnique_flg(String unique_flg) {
		this.unique_flg = unique_flg;
		return this;
	}


}
