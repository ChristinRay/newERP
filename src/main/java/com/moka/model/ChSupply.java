package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import com.moka.Enum.CodeEnum;
import com.moka.utils.ParamPreconditions;

import lombok.Getter;
import lombok.Setter;
/**
 * 供应商表
 * modle
 */
@Setter
@Getter
public class ChSupply extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private String	accreditBrand;//授权品牌
	private String  companyName;
	private String  companyCode;
	private String  cooperationType;
	private String  createtime;
	private String  supplyAccount;//供应商开户行
	private String  supplyAccountName;//供应商开户行名称
	private String  supplyAddress;//供应商地址
	private String  supplyCertificate;//供应商三证
	private String  supplyCode;//供应商编码
	private String  supplyContact;//供应商联系人
	private String  supplyContactPosition;//联系人职位
	private String  supplyMobile;//联系人手机号
	private String  supplyName;
	private String  updatetime;
	private Integer  userId;
	private String	accreditBrandName;

	public void check(){
		ParamPreconditions.checkNotEmpty(CodeEnum.FAIL.getCode(), "必要参数不能为空", "必要参数不能为空",
				supplyCode,supplyName,supplyAccount,supplyAccountName,supplyContact,supplyMobile );
	}
	
}
