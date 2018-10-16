package com.moka.req;

import lombok.Getter;
import lombok.Setter;

/**
* @author    created by lbq
* @date	     2018年10月12日 下午2:36:50
**/
@Setter
@Getter
public class CompanyReq {
	private static final long serialVersionUID = 1L;
	private String  companyCode;
	private String  companyName;
	private String  companyDeputy;
	private String  companyAccountName;
	private String  tax;
	private String  accountBank;
	private String  accountNo;
	private Integer  userId;
	private String  createtime;
	private String  updatetime;
}
