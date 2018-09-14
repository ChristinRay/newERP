package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import com.moka.Enum.CodeEnum;
import com.moka.utils.ParamPreconditions;

import lombok.Getter;
import lombok.Setter;
/**
 * 商品表
 * modle
 */
@Setter
@Getter
public class ChProduct extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  productCode;//商品编码
	private String  brandCode;//品牌编码
	private String  productName;//商品名称
	private String  productEnglishName;//商品英文名称
	private String  productSize;//商品规格
	private String  productType;//商品类型
	private String  productUnit;//商品单位
	private String  productWeight;//商品重量
	private String  picture;//商品图片
	private Integer  userId;//录入人id
	private String  createtime;
	private String  updatetime;
	
	public void check(){
		ParamPreconditions.checkNotEmpty(CodeEnum.FAIL.getCode(), "必要参数不能为空", "必要参数不能为空",
				productCode,brandCode,productName,productSize,productType,productUnit,productWeight );
	}


	
}
