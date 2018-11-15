package com.moka.model;

import java.lang.Integer;
import java.lang.String;
import java.time.LocalDate;
import java.time.Month;

import com.moka.Enum.CodeEnum;
import com.moka.utils.ParamPreconditions;

import lombok.Getter;
import lombok.Setter;
/**
 * @author 耿长伟
 * @date 2018-11-13
 * 诉单信息表
 * modle
 */
@Setter
@Getter
public class ChComplaintInformation extends BaseModel {
	
	private static final long serialVersionUID = 1L;
	private String  commodityName;//商品名称
	private String  contactInformation;//联系方式
	private String  createtime;//创建时间
	private String  dateComplaint;//日期
	private String  descriptionSituation;//情况说明 {1=收到商品破碎, 2=未收到商品, 3=地址不详}
	private String  exchangeGoods;//退换货
	private String  isNotSolve;//是否解决 1已解决 2未解决
	private String  name;//姓名
	private String  orderNumber;//订单编号
	private String  originalNumber;//原始单号
	private String  reason;//原因   {1=邮政问题, 2=邮政配货问题, 3=邮政物流问题, 4=品质问题, 5=客户, 6=邮政物流问题}
	private String  receivingAddress;//收货地址
	private String  reissueNumber;//补发单号
	private String  remarks;//备注
	private String  solution;//解决方案  {1=邮政问题发错货, 2=邮政问题丢件, 3=邮政问题, 4=给客户退款}
	private String  state;//状态 1.正常2.逻辑删除3.物理删除
	private String  updatetime;//修改时间
	private Integer  userId;//录入人id
	/******************非数据库字段****************************/
	private String  starDate;//查询开始时间
	private String  endDate;//查询结束时间
	
	private String selectFlg;//查询标识
	/******************非数据库字段****************************/
	
	public void check(){
		ParamPreconditions.checkNotNull(dateComplaint, CodeEnum.FAIL.getCode(), "日期不能为空");
		ParamPreconditions.checkNotNull(orderNumber, CodeEnum.FAIL.getCode(), "订单编号不能为空");
		ParamPreconditions.checkNotNull(name, CodeEnum.FAIL.getCode(), "姓名不能为空");
		ParamPreconditions.checkNotNull(contactInformation,CodeEnum.FAIL.getCode(), "联系方式不能为空");
		ParamPreconditions.checkNotNull(receivingAddress,CodeEnum.FAIL.getCode(), "收货地址不能为空");
		ParamPreconditions.checkNotNull(commodityName,CodeEnum.FAIL.getCode(), "商品名称不能为空");
		ParamPreconditions.checkNotNull(originalNumber,CodeEnum.FAIL.getCode(), "原始单号不能为空");
		ParamPreconditions.checkNotNull(descriptionSituation,CodeEnum.FAIL.getCode(), "情况说明不能为空");
		ParamPreconditions.checkNotNull(reason,CodeEnum.FAIL.getCode(), "原因不能为空");
		ParamPreconditions.checkNotNull(solution,CodeEnum.FAIL.getCode(), "解决方案不能为空");
		ParamPreconditions.checkNotNull(exchangeGoods,CodeEnum.FAIL.getCode(), "退换货不能为空");
		ParamPreconditions.checkNotNull(reissueNumber,CodeEnum.FAIL.getCode(), "补发单号不能为空");
		ParamPreconditions.checkNotNull(isNotSolve,CodeEnum.FAIL.getCode(), "是否解决不能为空");
	}
	
}
