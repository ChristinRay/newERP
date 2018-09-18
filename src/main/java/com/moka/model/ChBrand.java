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
	private Integer  userId;
	private String  createtime;
	private String  updatetime;


	public void check(){
		ParamPreconditions.checkNotEmpty(brandName, CodeEnum.FAIL.getCode(), "品牌名称不能为空", "品牌名称不能为空");
		ParamPreconditions.checkNotEmpty(brandCode, CodeEnum.FAIL.getCode(), "品牌编码不能为空", "品牌编码不能为空");
	}
	
}
