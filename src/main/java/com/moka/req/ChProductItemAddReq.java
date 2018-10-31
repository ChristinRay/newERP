package com.moka.req;

import java.math.BigDecimal;

import com.moka.Enum.CodeEnum;
import com.moka.model.BaseModel;
import com.moka.utils.ParamPreconditions;

import lombok.Getter;
import lombok.Setter;

/**
* @author    created by lbq
* @date	     2018年10月17日 下午7:52:16
**/
@Setter
@Getter
public class ChProductItemAddReq {
	/**
	 * 
	 */
	private Integer  productId;//商品id
	private Integer  supplyId;//供应商id
	private String  brandCode;//品牌编码
	private String  supplyProductNo;//供应商商品编码
	private BigDecimal  purchasePrice;//进货价
	private BigDecimal  packPrice;//包装费
	private BigDecimal  freightPrice;//运费
	private String freightway;//运费方式
	private Integer  userId;
	
	public void check(){
		ParamPreconditions.checkNotNull(productId, CodeEnum.FAIL.getCode(), "商品id不能为空");
		ParamPreconditions.checkNotNull(supplyId, CodeEnum.FAIL.getCode(), "供应商id不能为空");
		ParamPreconditions.checkNotEmpty(brandCode, CodeEnum.FAIL.getCode(), "品牌编码不能为空");
		ParamPreconditions.checkNotEmpty(supplyProductNo,CodeEnum.FAIL.getCode(), "供应商商品编码不能为空");
		ParamPreconditions.checkNumberByDecimals(purchasePrice, 2, CodeEnum.FAIL.getCode(), "进货价金额必须大于0");
//		ParamPreconditions.checkNumberByDecimals(packPrice, 2, CodeEnum.FAIL.getCode(), "包装费金额必须大于0");
//		ParamPreconditions.checkNumberByDecimals(freightPrice, 2, CodeEnum.FAIL.getCode(), "运费金额必须大于0");
	}
}




