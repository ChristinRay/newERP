package com.moka.dao;

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
		sql.VALUES("supply_code,brand_code,sypply_name,accredit_level,accredit_start_time,accredit_end_time,cooperation_type,supply_account,supply_account_name,accredit_product,sypply_address,sypply_contact,sypply_mobile,sypply_contact_position,company_name,user_id,state,createtime,updatetime", "#{supplyCode},#{brandCode},#{sypplyName},#{accreditLevel},#{accreditStartTime},#{accreditEndTime},#{cooperationType},#{supplyAccount},#{supplyAccountName},#{accreditProduct},#{sypplyAddress},#{sypplyContact},#{sypplyMobile},#{sypplyContactPosition},#{companyName},#{userId},#{state},now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChSupplyByCount(ChSupply entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_supply");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCode())) {sql.WHERE("supply_code = #{supplyCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyName())) {sql.WHERE("sypply_name = #{sypplyName}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.WHERE("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditStartTime())) {sql.WHERE("accredit_start_time = #{accreditStartTime}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditEndTime())) {sql.WHERE("accredit_end_time = #{accreditEndTime}");}
			if(!Strings.isNullOrEmpty(entity.getCooperationType())) {sql.WHERE("cooperation_type = #{cooperationType}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccount())) {sql.WHERE("supply_account = #{supplyAccount}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccountName())) {sql.WHERE("supply_account_name = #{supplyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditProduct())) {sql.WHERE("accredit_product = #{accreditProduct}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyAddress())) {sql.WHERE("sypply_address = #{sypplyAddress}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyContact())) {sql.WHERE("sypply_contact = #{sypplyContact}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyMobile())) {sql.WHERE("sypply_mobile = #{sypplyMobile}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyContactPosition())) {sql.WHERE("sypply_contact_position = #{sypplyContactPosition}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyName())) {sql.WHERE("company_name = #{companyName}");}
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
	public String selectChSupplyByLimt(ChSupply entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_supply");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCode())) {sql.WHERE("supply_code = #{supplyCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyName())) {sql.WHERE("sypply_name = #{sypplyName}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.WHERE("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditStartTime())) {sql.WHERE("accredit_start_time = #{accreditStartTime}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditEndTime())) {sql.WHERE("accredit_end_time = #{accreditEndTime}");}
			if(!Strings.isNullOrEmpty(entity.getCooperationType())) {sql.WHERE("cooperation_type = #{cooperationType}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccount())) {sql.WHERE("supply_account = #{supplyAccount}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccountName())) {sql.WHERE("supply_account_name = #{supplyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditProduct())) {sql.WHERE("accredit_product = #{accreditProduct}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyAddress())) {sql.WHERE("sypply_address = #{sypplyAddress}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyContact())) {sql.WHERE("sypply_contact = #{sypplyContact}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyMobile())) {sql.WHERE("sypply_mobile = #{sypplyMobile}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyContactPosition())) {sql.WHERE("sypply_contact_position = #{sypplyContactPosition}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyName())) {sql.WHERE("company_name = #{companyName}");}
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
	public String selectChSupply(ChSupply entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_supply");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyCode())) {sql.WHERE("supply_code = #{supplyCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyName())) {sql.WHERE("sypply_name = #{sypplyName}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.WHERE("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditStartTime())) {sql.WHERE("accredit_start_time = #{accreditStartTime}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditEndTime())) {sql.WHERE("accredit_end_time = #{accreditEndTime}");}
			if(!Strings.isNullOrEmpty(entity.getCooperationType())) {sql.WHERE("cooperation_type = #{cooperationType}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccount())) {sql.WHERE("supply_account = #{supplyAccount}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccountName())) {sql.WHERE("supply_account_name = #{supplyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditProduct())) {sql.WHERE("accredit_product = #{accreditProduct}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyAddress())) {sql.WHERE("sypply_address = #{sypplyAddress}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyContact())) {sql.WHERE("sypply_contact = #{sypplyContact}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyMobile())) {sql.WHERE("sypply_mobile = #{sypplyMobile}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyContactPosition())) {sql.WHERE("sypply_contact_position = #{sypplyContactPosition}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyName())) {sql.WHERE("company_name = #{companyName}");}
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
	public String selectOne(long id) {
		SQL sql = new SQL().SELECT("*").FROM("ch_supply");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateChSupply(ChSupply entity) {
		SQL sql = new SQL().UPDATE("ch_supply");
				sql.SET("supply_code = #{supplyCode}");
		sql.SET("brand_code = #{brandCode}");
		sql.SET("sypply_name = #{sypplyName}");
		sql.SET("accredit_level = #{accreditLevel}");
		sql.SET("accredit_start_time = #{accreditStartTime}");
		sql.SET("accredit_end_time = #{accreditEndTime}");
		sql.SET("cooperation_type = #{cooperationType}");
		sql.SET("supply_account = #{supplyAccount}");
		sql.SET("supply_account_name = #{supplyAccountName}");
		sql.SET("accredit_product = #{accreditProduct}");
		sql.SET("sypply_address = #{sypplyAddress}");
		sql.SET("sypply_contact = #{sypplyContact}");
		sql.SET("sypply_mobile = #{sypplyMobile}");
		sql.SET("sypply_contact_position = #{sypplyContactPosition}");
		sql.SET("company_name = #{companyName}");
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
	public String updateChSupplyByNullChk(ChSupply entity) {
		SQL sql = new SQL().UPDATE("ch_supply");
					if(!Strings.isNullOrEmpty(entity.getSupplyCode())) {sql.SET("supply_code = #{supplyCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.SET("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyName())) {sql.SET("sypply_name = #{sypplyName}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.SET("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditStartTime())) {sql.SET("accredit_start_time = #{accreditStartTime}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditEndTime())) {sql.SET("accredit_end_time = #{accreditEndTime}");}
			if(!Strings.isNullOrEmpty(entity.getCooperationType())) {sql.SET("cooperation_type = #{cooperationType}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccount())) {sql.SET("supply_account = #{supplyAccount}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyAccountName())) {sql.SET("supply_account_name = #{supplyAccountName}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditProduct())) {sql.SET("accredit_product = #{accreditProduct}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyAddress())) {sql.SET("sypply_address = #{sypplyAddress}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyContact())) {sql.SET("sypply_contact = #{sypplyContact}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyMobile())) {sql.SET("sypply_mobile = #{sypplyMobile}");}
			if(!Strings.isNullOrEmpty(entity.getSypplyContactPosition())) {sql.SET("sypply_contact_position = #{sypplyContactPosition}");}
			if(!Strings.isNullOrEmpty(entity.getCompanyName())) {sql.SET("company_name = #{companyName}");}
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
	public String deleteChSupply(long id) {
		SQL sql = new SQL().DELETE_FROM("ch_supply");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("ch_supply");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
