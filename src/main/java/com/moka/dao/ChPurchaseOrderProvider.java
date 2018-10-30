package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChPurchaseOrder;

/**
 * 
 * provider
 */
public class ChPurchaseOrderProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChPurchaseOrder(ChPurchaseOrder entity) {
		SQL sql = new SQL().INSERT_INTO("ch_purchase_order");
		sql.VALUES("company_id,createtime,depot_id,id,memo,predict_time,pur_bills_date,pur_bills_id,pur_bills_type,pur_order_type,reality_time,state,updatetime,user_id", "#{companyId},now(),#{depotId},#{id},#{memo},#{predictTime},#{purBillsDate},#{purBillsId},#{purBillsType},#{purOrderType},#{realityTime},#{state},now(),#{userId}");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChPurchaseOrderByCount(ChPurchaseOrder entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_purchase_order");
					if(!Objects.isNull(entity.getApproverId())) {sql.WHERE("approver_id = #{approverId}");}
			if(!Objects.isNull(entity.getCompanyId())) {sql.WHERE("company_id = #{companyId}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Objects.isNull(entity.getDepotId())) {sql.WHERE("depot_id = #{depotId}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getMemo())) {sql.WHERE("memo = #{memo}");}
			if(!Strings.isNullOrEmpty(entity.getPredictTime())) {sql.WHERE("predict_time = #{predictTime}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsDate())) {sql.WHERE("pur_bills_date = #{purBillsDate}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsId())) {sql.WHERE("pur_bills_id = #{purBillsId}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsType())) {sql.WHERE("pur_bills_type = #{purBillsType}");}
			if(!Strings.isNullOrEmpty(entity.getPurOrderType())) {sql.WHERE("pur_order_type = #{purOrderType}");}
			if(!Strings.isNullOrEmpty(entity.getRealityTime())) {sql.WHERE("reality_time = #{realityTime}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}

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
	public String selectChPurchaseOrderByLimt(ChPurchaseOrder entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_purchase_order");
					if(!Objects.isNull(entity.getApproverId())) {sql.WHERE("approver_id = #{approverId}");}
			if(!Objects.isNull(entity.getCompanyId())) {sql.WHERE("company_id = #{companyId}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Objects.isNull(entity.getDepotId())) {sql.WHERE("depot_id = #{depotId}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getMemo())) {sql.WHERE("memo = #{memo}");}
			if(!Strings.isNullOrEmpty(entity.getPredictTime())) {sql.WHERE("predict_time = #{predictTime}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsDate())) {sql.WHERE("pur_bills_date = #{purBillsDate}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsId())) {sql.WHERE("pur_bills_id = #{purBillsId}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsType())) {sql.WHERE("pur_bills_type = #{purBillsType}");}
			if(!Strings.isNullOrEmpty(entity.getPurOrderType())) {sql.WHERE("pur_order_type = #{purOrderType}");}
			if(!Strings.isNullOrEmpty(entity.getRealityTime())) {sql.WHERE("reality_time = #{realityTime}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}

		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectChPurchaseOrder(ChPurchaseOrder entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_purchase_order");
					if(!Objects.isNull(entity.getApproverId())) {sql.WHERE("approver_id = #{approverId}");}
			if(!Objects.isNull(entity.getCompanyId())) {sql.WHERE("company_id = #{companyId}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Objects.isNull(entity.getDepotId())) {sql.WHERE("depot_id = #{depotId}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getMemo())) {sql.WHERE("memo = #{memo}");}
			if(!Strings.isNullOrEmpty(entity.getPredictTime())) {sql.WHERE("predict_time = #{predictTime}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsDate())) {sql.WHERE("pur_bills_date = #{purBillsDate}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsId())) {sql.WHERE("pur_bills_id = #{purBillsId}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsType())) {sql.WHERE("pur_bills_type = #{purBillsType}");}
			if(!Strings.isNullOrEmpty(entity.getPurOrderType())) {sql.WHERE("pur_order_type = #{purOrderType}");}
			if(!Strings.isNullOrEmpty(entity.getRealityTime())) {sql.WHERE("reality_time = #{realityTime}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}

		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(@Param("id")int id) {
		SQL sql = new SQL().SELECT("*").FROM("ch_purchase_order");
		sql.WHERE("id=#{id}");
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateChPurchaseOrderByNullChk(ChPurchaseOrder entity) {
		SQL sql = new SQL().UPDATE("ch_purchase_order");
					if(!Objects.isNull(entity.getApproverId())) {sql.SET("approver_id = #{approverId}");}
			if(!Objects.isNull(entity.getCompanyId())) {sql.SET("company_id = #{companyId}");}
			if(!Objects.isNull(entity.getDepotId())) {sql.SET("depot_id = #{depotId}");}
			if(!Strings.isNullOrEmpty(entity.getMemo())) {sql.SET("memo = #{memo}");}
			if(!Strings.isNullOrEmpty(entity.getPredictTime())) {sql.SET("predict_time = #{predictTime}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsDate())) {sql.SET("pur_bills_date = #{purBillsDate}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsId())) {sql.SET("pur_bills_id = #{purBillsId}");}
			if(!Strings.isNullOrEmpty(entity.getPurBillsType())) {sql.SET("pur_bills_type = #{purBillsType}");}
			if(!Strings.isNullOrEmpty(entity.getPurOrderType())) {sql.SET("pur_order_type = #{purOrderType}");}
			if(!Strings.isNullOrEmpty(entity.getRealityTime())) {sql.SET("reality_time = #{realityTime}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.SET("state = #{state}");}
			if(!Objects.isNull(entity.getUserId())) {sql.SET("user_id = #{userId}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}

	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(@Param("id")int id) {
		SQL sql = new SQL().UPDATE("ch_purchase_order");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
