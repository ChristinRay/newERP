package com.moka.dto;

import lombok.Getter;
import lombok.Setter;

/**
* @author    created by lbq
* @date	     2018年10月18日 下午5:30:03
**/
@Setter
@Getter
public class ChProductDto {
	private String  productCode;//商品编码
	private String  brandCode;//品牌编码
	private String  productName;//商品名称
	private String  productEnglishName;//商品英文名
	private String  productSize;//商品属性,规格
	private String  productType;//商品类型
	private String  productUnit;//商品单位
	private String  productWeight;//商品重量
	private String  length;//长
	private String  width;//宽
	private String  height;//高
	private String  picture;//图片
	private String  sku;//sku序号
	private Integer  userId;
	private String  createtime;
	private String  updatetime;
	private Integer id;
	private String orderBy;
	private Integer limit;
	private Integer limitLen;
	private Integer pageIndex;//页码
	private Integer pageSize;//页数
	private String state;//状态
	private String brandName;//品牌名称
	private String productTypeName;//品牌类别名称
}
