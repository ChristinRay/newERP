package com.moka.req;

import com.moka.model.BaseModel;
import com.moka.model.ProductSize;

import lombok.Getter;
import lombok.Setter;

/**
* @author    created by lbq
* @date	     2018年9月25日 下午2:26:51
**/
@Setter
@Getter
public class ChProductReq extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  productCode;//商品编码
	private String  brandCode;//品牌编码
	private String  productName;//商品名称
	private String  productEnglishName;//商品英文名
	private ProductSize  productSize;//商品属性,规格
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
	
}
