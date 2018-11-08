package com.moka.req;

import java.math.BigDecimal;
import java.util.List;

import com.moka.Enum.CodeEnum;
import com.moka.model.ChPurchaseItem;
import com.moka.utils.ParamPreconditions;

import lombok.Data;

/**
* @author    created by lbq
* @date	     2018年11月1日 上午11:51:13
**/
@Data
public class ChPurchaseAddReq {
	private Integer  companyId;//公司id
	private Integer  depotId;//仓库id
	private Integer supplyId;//供应商id
	private String  memo;//备注
	private String  picture;//图片
	private String  predictTime;//预计到货时间
	private BigDecimal  price;
	private String  purBillsDate;//采购单据日期
	private String  purBillsId;//订单编号
	private String  purBillsType;//单据状态
	private String  purOrderType;//采购订单类型
	private String  realityTime;//实际到货时间
	private String  supplyCode;//供应商编码
	private List<ChPurchaseItem>  purchaseList;//采购商品详情
	private Integer  userId;
	private String  state;
	private String  updatetime;
	private String  createtime;
	
	public void check (){
		ParamPreconditions.checkNotEmpty(CodeEnum.FAIL.getCode(), "必要字段不能为空", "必要字段不能为空",
				purBillsDate,purOrderType,predictTime,supplyCode );
		ParamPreconditions.checkNotNull(purchaseList, CodeEnum.FAIL.getCode(), "没有商品不能下单");
		ParamPreconditions.checkNotNull(companyId, CodeEnum.FAIL.getCode(), "公司id不能为空");
		ParamPreconditions.checkNotNull(depotId, CodeEnum.FAIL.getCode(), "仓库id不能为空");
		ParamPreconditions.checkNotNull(userId, CodeEnum.FAIL.getCode(), "采购订单申请人不能为空");
	}
}







