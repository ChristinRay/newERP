package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import com.moka.Enum.CodeEnum;
import com.moka.utils.ParamPreconditions;

import lombok.Getter;
import lombok.Setter;
/**
 * 品牌表
 * modle
 */
@Setter
@Getter
public class ChBrand extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  brandName;
	private String  brandCode;
	private String  accreditLevel;
	private String  accreditStartTime;
	private String  accreditEndTime;
	private Integer  companyId;
	private Integer  userId;
	private String  createtime;
	private String  updatetime;
	private String companyName;

	public void check(){
		ParamPreconditions.checkNotEmpty(CodeEnum.FAIL.getCode(), "必要字段不能为空", "必要字段不能为空", brandName,brandCode,accreditLevel
				,accreditEndTime,accreditStartTime);
		ParamPreconditions.checkNotNull(companyId, CodeEnum.FAIL.getCode(), "公司id不能为空");
		ParamPreconditions.checkNotNull(userId, CodeEnum.FAIL.getCode(), "录入人id不能为空");
	}

	
}
