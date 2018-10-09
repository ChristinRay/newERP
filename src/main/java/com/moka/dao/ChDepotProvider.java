package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChDepot;

/**
 * 仓库表
 * provider
 */
public class ChDepotProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChDepot(ChDepot entity) {
		SQL sql = new SQL().INSERT_INTO("ch_depot");
		sql.VALUES("depot_code,depot_name,depot_address,depot_type,depot_person,depot_phone,pay_type,depot_state,user_id,state,createtime,updatetime", "#{depotCode},#{depotName},#{depotAddress},#{depotType},#{depotPerson},#{depotPhone},#{payType},#{depotState},#{userId},'1',now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChDepotByCount(ChDepot entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_depot");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getDepotCode())) {sql.WHERE("depot_code = #{depotCode}");}
			if(!Strings.isNullOrEmpty(entity.getDepotName())) {sql.WHERE("depot_name = #{depotName}");}
			if(!Strings.isNullOrEmpty(entity.getDepotAddress())) {sql.WHERE("depot_address = #{depotAddress}");}
			if(!Strings.isNullOrEmpty(entity.getDepotType())) {sql.WHERE("depot_type = #{depotType}");}
			if(!Strings.isNullOrEmpty(entity.getDepotPerson())) {sql.WHERE("depot_person = #{depotPerson}");}
			if(!Strings.isNullOrEmpty(entity.getDepotPhone())) {sql.WHERE("depot_phone = #{depotPhone}");}
			if(!Strings.isNullOrEmpty(entity.getPayType())) {sql.WHERE("pay_type = #{payType}");}
			if(!Strings.isNullOrEmpty(entity.getDepotState())) {sql.WHERE("depot_state = #{depotState}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			sql.WHERE("state='1'");
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
	public String selectChDepotByLimt(ChDepot entity) {
		SQL sql = new SQL().SELECT(" id as id,depot_code as depotCode,depot_name as depotName,depot_address as depotAddress, "
				+ " depot_type as depotType,depot_person as depotPerson,depot_phone as depotPhone,pay_type as payType, "
				+ " depot_state as depotState,user_id as userId,state as state,createtime as createtime,updatetime as updatetime").FROM("ch_depot");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getDepotCode())) {sql.WHERE("depot_code = #{depotCode}");}
			if(!Strings.isNullOrEmpty(entity.getDepotName())) {sql.WHERE("depot_name = #{depotName}");}
			if(!Strings.isNullOrEmpty(entity.getDepotAddress())) {sql.WHERE("depot_address = #{depotAddress}");}
			if(!Strings.isNullOrEmpty(entity.getDepotType())) {sql.WHERE("depot_type = #{depotType}");}
			if(!Strings.isNullOrEmpty(entity.getDepotPerson())) {sql.WHERE("depot_person = #{depotPerson}");}
			if(!Strings.isNullOrEmpty(entity.getDepotPhone())) {sql.WHERE("depot_phone = #{depotPhone}");}
			if(!Strings.isNullOrEmpty(entity.getPayType())) {sql.WHERE("pay_type = #{payType}");}
			if(!Strings.isNullOrEmpty(entity.getDepotState())) {sql.WHERE("depot_state = #{depotState}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			sql.WHERE("state='1'");
		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectChDepot(ChDepot entity) {
		SQL sql = new SQL().SELECT(" id as id,depot_code as depotCode,depot_name as depotName,depot_address as depotAddress, "
				+ " depot_type as depotType,depot_person as depotPerson,depot_phone as depotPhone,pay_type as payType, "
				+ " depot_state as depotState,user_id as userId,state as state,createtime as createtime,updatetime as updatetime").FROM("ch_depot");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getDepotCode())) {sql.WHERE("depot_code = #{depotCode}");}
			if(!Strings.isNullOrEmpty(entity.getDepotName())) {sql.WHERE("depot_name = #{depotName}");}
			if(!Strings.isNullOrEmpty(entity.getDepotAddress())) {sql.WHERE("depot_address = #{depotAddress}");}
			if(!Strings.isNullOrEmpty(entity.getDepotType())) {sql.WHERE("depot_type = #{depotType}");}
			if(!Strings.isNullOrEmpty(entity.getDepotPerson())) {sql.WHERE("depot_person = #{depotPerson}");}
			if(!Strings.isNullOrEmpty(entity.getDepotPhone())) {sql.WHERE("depot_phone = #{depotPhone}");}
			if(!Strings.isNullOrEmpty(entity.getPayType())) {sql.WHERE("pay_type = #{payType}");}
			if(!Strings.isNullOrEmpty(entity.getDepotState())) {sql.WHERE("depot_state = #{depotState}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			sql.WHERE("state='1'");
		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(@Param("id") int id) {
		SQL sql = new SQL().SELECT(" id as id,depot_code as depotCode,depot_name as depotName,depot_address as depotAddress, "
				+ " depot_type as depotType,depot_person as depotPerson,depot_phone as depotPhone,pay_type as payType, "
				+ " depot_state as depotState,user_id as userId,state as state,createtime as createtime,updatetime as updatetime").FROM("ch_depot");
		sql.WHERE("id=#{id}");
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateChDepot(ChDepot entity) {
		SQL sql = new SQL().UPDATE("ch_depot");
				sql.SET("depot_code = #{depotCode}");
		sql.SET("depot_name = #{depotName}");
		sql.SET("depot_address = #{depotAddress}");
		sql.SET("depot_type = #{depotType}");
		sql.SET("depot_person = #{depotPerson}");
		sql.SET("depot_phone = #{depotPhone}");
		sql.SET("pay_type = #{payType}");
		sql.SET("depot_state = #{depotState}");
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
	public String updateChDepotByNullChk(ChDepot entity) {
		SQL sql = new SQL().UPDATE("ch_depot");
			if(!Strings.isNullOrEmpty(entity.getDepotCode())) {sql.SET("depot_code = #{depotCode}");}
			if(!Strings.isNullOrEmpty(entity.getDepotName())) {sql.SET("depot_name = #{depotName}");}
			if(!Strings.isNullOrEmpty(entity.getDepotAddress())) {sql.SET("depot_address = #{depotAddress}");}
			if(!Strings.isNullOrEmpty(entity.getDepotType())) {sql.SET("depot_type = #{depotType}");}
			if(!Strings.isNullOrEmpty(entity.getDepotPerson())) {sql.SET("depot_person = #{depotPerson}");}
			if(!Strings.isNullOrEmpty(entity.getDepotPhone())) {sql.SET("depot_phone = #{depotPhone}");}
			if(!Strings.isNullOrEmpty(entity.getPayType())) {sql.SET("pay_type = #{payType}");}
			if(!Strings.isNullOrEmpty(entity.getDepotState())) {sql.SET("depot_state = #{depotState}");}
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
	public String deleteChDepot(int id) {
		SQL sql = new SQL().DELETE_FROM("ch_depot");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(@Param("id")int id) {
		SQL sql = new SQL().UPDATE("ch_depot");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
