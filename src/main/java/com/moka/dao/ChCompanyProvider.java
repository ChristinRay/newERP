package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChCompany;

/**
 * 我司信息表
 * provider
 */
public class ChCompanyProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChCompany(ChCompany entity) {
		SQL sql = new SQL().INSERT_INTO("ch_company");
		sql.VALUES("company_code,company_name,company_deputy,company_account_name,account_bank,account_no,user_id,state,createtime,updatetime", "#{companyCode},#{companyName},#{companyDeputy},#{companyAccountName},#{accountBank},#{accountNo},#{userId},'1',now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChCompanyByCount(ChCompany entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_company");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyCode())) {sql.WHERE("company_code = #{companyCode}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyName())) {sql.WHERE("company_name = #{companyName}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyDeputy())) {sql.WHERE("company_deputy = #{companyDeputy}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyAccountName())) {sql.WHERE("company_account_name = #{companyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getAccountBank())) {sql.WHERE("account_bank = #{accountBank}");}
			if(!Strings.isNullOrEmpty(entity.getAccountNo())) {sql.WHERE("account_no = #{accountNo}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}

		return sql.toString();
	}
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	public String selectChCompanyByLimt(ChCompany entity) {
		SQL sql = new SQL().SELECT("id, company_code as companyCode,company_name as companyName,company_deputy as companyDeputy,company_account_name as companyAccountName,account_bank as accountBank,account_no as accountNo,user_id as userId,state,createtime,updatetime ").FROM("ch_company");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyCode())) {sql.WHERE("company_code = #{companyCode}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyName())) {sql.WHERE("company_name = #{companyName}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyDeputy())) {sql.WHERE("company_deputy = #{companyDeputy}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyAccountName())) {sql.WHERE("company_account_name = #{companyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getAccountBank())) {sql.WHERE("account_bank = #{accountBank}");}
			if(!Strings.isNullOrEmpty(entity.getAccountNo())) {sql.WHERE("account_no = #{accountNo}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}

		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectChCompany(ChCompany entity) {
		SQL sql = new SQL().SELECT("id, company_code as companyCode,company_name as companyName,company_deputy as companyDeputy,company_account_name as companyAccountName,account_bank as accountBank,account_no as accountNo,user_id as userId,state,createtime,updatetime ").FROM("ch_company");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyCode())) {sql.WHERE("company_code = #{companyCode} ");}
			if(!Strings.isNullOrEmpty(entity.getCompanyName())) {sql.WHERE("company_name = #{companyName} ");}
			if(!Strings.isNullOrEmpty(entity.getCompanyDeputy())) {sql.WHERE("company_deputy = #{companyDeputy} ");}
			if(!Strings.isNullOrEmpty(entity.getCompanyAccountName())) {sql.WHERE("company_account_name = #{companyAccountName} ");}
			if(!Strings.isNullOrEmpty(entity.getAccountBank())) {sql.WHERE("account_bank = #{accountBank} ");}
			if(!Strings.isNullOrEmpty(entity.getAccountNo())) {sql.WHERE("account_no  = #{accountNo}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}

		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(@Param("id")int id) {
		SQL sql = new SQL().SELECT("id, company_code as companyCode,company_name as companyName,company_deputy as companyDeputy,company_account_name as companyAccountName,account_bank as accountBank,account_no as accountNo,user_id as userId,state,createtime,updatetime").FROM("ch_company");
		sql.WHERE("id=#{id}");
		System.out.println(sql);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateChCompany(ChCompany entity) {
		SQL sql = new SQL().UPDATE("ch_company");
				sql.SET("company_code = #{companyCode}");
		sql.SET("company_name = #{companyName}");
		sql.SET("company_deputy = #{companyDeputy}");
		sql.SET("company_account_name = #{companyAccountName}");
		sql.SET("account_bank = #{accountBank}");
		sql.SET("account_no = #{accountNo}");
		sql.SET("user_id = #{userId}");
		sql.SET("state = #{state}");
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateChCompanyByNullChk(ChCompany entity) {
		SQL sql = new SQL().UPDATE("ch_company");
					if(!Strings.isNullOrEmpty(entity.getCompanyCode())) {sql.SET("company_code = #{companyCode}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyName())) {sql.SET("company_name = #{companyName}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyDeputy())) {sql.SET("company_deputy = #{companyDeputy}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyAccountName())) {sql.SET("company_account_name = #{companyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getAccountBank())) {sql.SET("account_bank = #{accountBank}");}
			if(!Strings.isNullOrEmpty(entity.getAccountNo())) {sql.SET("account_no = #{accountNo}");}
			if(!Objects.isNull(entity.getUserId())) {sql.SET("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.SET("state = #{state}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public String deleteChCompany(int id) {
		SQL sql = new SQL().DELETE_FROM("ch_company");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(@Param("id")int id) {
		SQL sql = new SQL().UPDATE("ch_company");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
