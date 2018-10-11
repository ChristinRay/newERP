package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;

/**
* @author    created by lbq
* @date	     2018年10月10日 下午2:41:39
**/
public class WebProvider {
	/**
	 * 得到我司信息
	 */
	public String getCompany(){
		SQL sql = new SQL().SELECT("id, company_code as companyCode,company_name as companyName,company_deputy as companyDeputy,"
				+ " company_account_name as companyAccountName,account_bank as accountBank,account_no as accountNo,user_id as userId,"
				+ " state,createtime,updatetime").FROM("ch_company");
		return sql.toString();
	}
}
