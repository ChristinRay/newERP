package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import com.moka.Enum.CodeEnum;
import com.moka.utils.ParamPreconditions;

import lombok.Getter;
import lombok.Setter;
/**
 * 我司信息表
 * modle
 */
@Setter
@Getter
public class ChCompany extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  companyCode;
	private String  companyName;
	private String  companyDeputy;
	private String  companyAccountName;
	private String  tax;
	private String  accountBank;
	private String  accountNo;
	private Integer  userId;
	private String  createtime;
	private String  updatetime;

	public void check(){
		ParamPreconditions.checkNotEmpty(CodeEnum.FAIL.getCode(), "必要字段不能为空", "必要字段不能为空",tax,companyCode,companyName);
	}

	
}
