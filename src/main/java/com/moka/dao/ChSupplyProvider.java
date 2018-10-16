package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChSupply;

/**
 * 供应商表
 * provider
 */
public class ChSupplyProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChSupply(ChSupply entity) {
		SQL sql = new SQL().INSERT_INTO("ch_supply");
		sql.VALUES("accredit_level,accredit_product,accredit_brand,accredit_start_time,accredit_end_time,company_code,cooperation_type,createtime,id,state,supply_account,supply_account_name,supply_address,supply_certificate,supply_code,supply_contact,supply_contact_position,supply_mobile,supply_name,updatetime,user_id", "#{accreditLevel},#{accreditProduct},#{accreditBrand},#{accreditStartTime},#{accreditEndTime},#{companyCode},#{cooperationType},now(),#{id},#{state},#{supplyAccount},#{supplyAccountName},#{supplyAddress},#{supplyCertificate},#{supplyCode},#{supplyContact},#{supplyContactPosition},#{supplyMobile},#{supplyName},now(),#{userId}");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChSupplyByCount(ChSupply entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_supply a inner join ch_company b on (a.company_code=b.company_code)");
			if(!Strings.isNullOrEmpty(entity.getAccreditEndTime())) {sql.WHERE("accredit_end_time = #{accreditEndTime}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.WHERE("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditProduct())) {sql.WHERE("accredit_product = #{accreditProduct}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditBrand())){sql.WHERE("accredit_brand = #{accreditBrand}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditStartTime())) {sql.WHERE("accredit_start_time = #{accreditStartTime}");}
			if(!Strings.isNullOrEmpty(entity.getCooperationType())) {sql.WHERE("cooperation_type = #{cooperationType}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccount())) {sql.WHERE("supply_account = #{supplyAccount}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccountName())) {sql.WHERE("supply_account_name = #{supplyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAddress())) {sql.WHERE("supply_address = #{supplyAddress}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCertificate())) {sql.WHERE("supply_certificate = #{supplyCertificate}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCode())) {sql.WHERE("supply_code = #{supplyCode}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyContact())) {sql.WHERE("supply_contact = #{supplyContact}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyContactPosition())) {sql.WHERE("supply_contact_position = #{supplyContactPosition}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyMobile())) {sql.WHERE("supply_mobile = #{supplyMobile}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyName())) {sql.WHERE("supply_name = #{supplyName}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			sql.WHERE("a.state <> '2'");
			sql.WHERE("b.state <>'2'");
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
	public String selectChSupplyByLimt(ChSupply entity) {
		SQL sql = new SQL().SELECT("a.id, accredit_end_time as accreditEndTime,accredit_level as accreditLevel,accredit_product as accreditProduct,"
				+ " accredit_brand as accreditBrand,accredit_start_time as accreditStartTime,b.company_name as companyName,cooperation_type as cooperationType, "
				+ " supply_account as supplyAccount,supply_account_name as supplyAccountName,supply_address as supplyAddress, "
				+ " supply_certificate as supplyCertificate,supply_code as supplyCode,supply_contact as supplyContact, "
				+ " supply_contact_position as supplyContactPosition,supply_mobile as supplyMobile,supply_name as supplyName,"
				+ " a.user_id as userId").FROM("ch_supply a ");
			sql.INNER_JOIN(" ch_company b on (a.company_code=b.company_code )");
			if(!Strings.isNullOrEmpty(entity.getAccreditEndTime())) {sql.WHERE("accredit_end_time = #{accreditEndTime}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.WHERE("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditProduct())) {sql.WHERE("accredit_product = #{accreditProduct}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditBrand())){sql.WHERE("accredit_brand = #{accreditBrand}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditStartTime())) {sql.WHERE("accredit_start_time = #{accreditStartTime}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyName())) {sql.WHERE("company_name = #{companyName}");}

			if(!Strings.isNullOrEmpty(entity.getCooperationType())) {sql.WHERE("cooperation_type = #{cooperationType}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("a.createtime = #{createtime}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccount())) {sql.WHERE("supply_account = #{supplyAccount}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccountName())) {sql.WHERE("supply_account_name = #{supplyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAddress())) {sql.WHERE("supply_address = #{supplyAddress}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCertificate())) {sql.WHERE("supply_certificate = #{supplyCertificate}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCode())) {sql.WHERE("supply_code = #{supplyCode}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyContact())) {sql.WHERE("supply_contact = #{supplyContact}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyContactPosition())) {sql.WHERE("supply_contact_position = #{supplyContactPosition}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyMobile())) {sql.WHERE("supply_mobile = #{supplyMobile}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyName())) {sql.WHERE("supply_name = #{supplyName}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("a.updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("a.user_id = #{userId}");}
			sql.WHERE("a.state <> '2'");
			sql.WHERE(" b.state <>'2'");
		return sql.toString() + " order by a." + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectChSupply(ChSupply entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_supply");
			if(!Strings.isNullOrEmpty(entity.getAccreditEndTime())) {sql.WHERE("accredit_end_time = #{accreditEndTime}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.WHERE("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditProduct())) {sql.WHERE("accredit_product = #{accreditProduct}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditBrand())){sql.WHERE("accredit_brand = #{accreditBrand}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditStartTime())) {sql.WHERE("accredit_start_time = #{accreditStartTime}");}
			if(!Strings.isNullOrEmpty(entity.getCooperationType())) {sql.WHERE("cooperation_type = #{cooperationType}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccount())) {sql.WHERE("supply_account = #{supplyAccount}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccountName())) {sql.WHERE("supply_account_name = #{supplyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAddress())) {sql.WHERE("supply_address = #{supplyAddress}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCertificate())) {sql.WHERE("supply_certificate = #{supplyCertificate}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCode())) {sql.WHERE("supply_code = #{supplyCode}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyContact())) {sql.WHERE("supply_contact = #{supplyContact}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyContactPosition())) {sql.WHERE("supply_contact_position = #{supplyContactPosition}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyMobile())) {sql.WHERE("supply_mobile = #{supplyMobile}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyName())) {sql.WHERE("supply_name = #{supplyName}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			sql.WHERE("state <> '2'");
		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(@Param("id")int id) {
		SQL sql = new SQL().SELECT("a.id, accredit_end_time as accreditEndTime,accredit_level as accreditLevel,accredit_product as accreditProduct,"
				+ " accredit_brand as accreditBrand,accredit_start_time as accreditStartTime,b.company_name as companyName,cooperation_type as cooperationType, "
				+ " supply_account as supplyAccount,supply_account_name as supplyAccountName,supply_address as supplyAddress, "
				+ " supply_certificate as supplyCertificate,supply_code as supplyCode,supply_contact as supplyContact, "
				+ " supply_contact_position as supplyContactPosition,supply_mobile as supplyMobile,supply_name as supplyName,"
				+ " a.user_id as userId").FROM("ch_supply a");
		sql.INNER_JOIN(" ch_company b on (a.company_code=b.company_code )");
		sql.WHERE("a.id= #{id}");
		System.out.println("aaaaaaa"+sql);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateChSupply(ChSupply entity) {
		SQL sql = new SQL().UPDATE("ch_supply");
		sql.SET("accredit_end_time = #{accreditEndTime}");
		sql.SET("accredit_level = #{accreditLevel}");
		sql.SET("accredit_product = #{accreditProduct}");
		sql.SET("accredit_brand = #{accreditBrand}");
		sql.SET("accredit_start_time = #{accreditStartTime}");
		sql.SET("company_code = #{companyCode}");
		sql.SET("cooperation_type = #{cooperationType}");
		sql.SET("state = #{state}");
		sql.SET("supply_account = #{supplyAccount}");
		sql.SET("supply_account_name = #{supplyAccountName}");
		sql.SET("supply_address = #{supplyAddress}");
		sql.SET("supply_certificate = #{supplyCertificate}");
		sql.SET("supply_code = #{supplyCode}");
		sql.SET("supply_contact = #{supplyContact}");
		sql.SET("supply_contact_position = #{supplyContactPosition}");
		sql.SET("supply_mobile = #{supplyMobile}");
		sql.SET("supply_name = #{supplyName}");
		sql.SET("user_id = #{userId}");
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		System.out.println(sql);
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateChSupplyByNullChk(ChSupply entity) {
		SQL sql = new SQL().UPDATE("ch_supply");
			if(!Strings.isNullOrEmpty(entity.getAccreditEndTime())) {sql.SET("accredit_end_time = #{accreditEndTime}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.SET("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditProduct())) {sql.SET("accredit_product = #{accreditProduct}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditBrand())){sql.WHERE("accredit_brand = #{accreditBrand}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditStartTime())) {sql.SET("accredit_start_time = #{accreditStartTime}");}
			if(!Strings.isNullOrEmpty(entity.getCooperationType())) {sql.SET("cooperation_type = #{cooperationType}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.SET("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccount())) {sql.SET("supply_account = #{supplyAccount}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccountName())) {sql.SET("supply_account_name = #{supplyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAddress())) {sql.SET("supply_address = #{supplyAddress}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCertificate())) {sql.SET("supply_certificate = #{supplyCertificate}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCode())) {sql.SET("supply_code = #{supplyCode}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyContact())) {sql.SET("supply_contact = #{supplyContact}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyContactPosition())) {sql.SET("supply_contact_position = #{supplyContactPosition}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyMobile())) {sql.SET("supply_mobile = #{supplyMobile}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyName())) {sql.SET("supply_name = #{supplyName}");}
			if(!Objects.isNull(entity.getUserId())) {sql.SET("user_id = #{userId}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public String deleteChSupply(int id) {
		SQL sql = new SQL().DELETE_FROM("ch_supply");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(@Param("id")int id) {
		SQL sql = new SQL().UPDATE("ch_supply");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	
	/**
	 * 禁用实体
	 * @param entity
	 * @return
	 */
	public String updateState(@Param("id")int id) {
		SQL sql = new SQL().UPDATE("ch_supply");
		sql.SET("state=3");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
