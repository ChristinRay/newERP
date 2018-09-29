package com.moka.model;

import java.lang.Integer;
import java.lang.String;

import com.moka.Enum.CodeEnum;
import com.moka.utils.ParamPreconditions;

import lombok.Getter;
import lombok.Setter;
/**
 * 仓库表
 * modle
 */
@Setter
@Getter
public class ChDepot extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  depotCode;
	private String  depotName;
	private String  depotAddress;
	private String  depotType;
	private String  depotPerson;
	private String  depotPhone;
	private String  payType;
	private String  depotState;
	private Integer  userId;
	private String  createtime;
	private String  updatetime;


	public void check ()
	{
		ParamPreconditions.checkNotEmpty(CodeEnum.FAIL.getCode(), "必要参数不能为空", "必要参数不能为空", depotCode,depotName,depotAddress,
				depotType,depotPerson,depotPhone,payType);
	}
	
}







