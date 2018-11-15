package com.moka.dao;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;

import java.util.List;
import java.util.Objects;
import com.moka.model.ChComplaintInformation;

import lombok.extern.slf4j.Slf4j;

/**
 * 诉单信息表
 * provider
 */
@Slf4j
public class ChComplaintInformationProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChComplaintInformation(ChComplaintInformation entity) {
		SQL sql = new SQL().INSERT_INTO("ch_complaint_information");
		sql.VALUES("commodity_name,contact_information,createtime,date_complaint,description_situation,exchange_goods,id,is_not_solve,name,order_number,original_number,reason,receiving_address,reissue_number,remarks,solution,state,updatetime,user_id", "#{commodityName},#{contactInformation},now(),#{dateComplaint},#{descriptionSituation},#{exchangeGoods},#{id},#{isNotSolve},#{name},#{orderNumber},#{originalNumber},#{reason},#{receivingAddress},#{reissueNumber},#{remarks},#{solution},#{state},now(),#{userId}");
		log.info("insertChComplaintInformation---"+sql.toString());
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChComplaintInformationByCount(ChComplaintInformation entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_complaint_information");
			if(!Strings.isNullOrEmpty(entity.getCommodityName())) {sql.WHERE("commodity_name = #{commodityName}");}
			if(!Strings.isNullOrEmpty(entity.getContactInformation())) {sql.WHERE("contact_information like CONCAT ('%',#{contactInformation},'%')");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getStarDate())) {sql.WHERE("date_complaint >= #{starDate}");}
			if(!Strings.isNullOrEmpty(entity.getEndDate())) {sql.WHERE("date_complaint <= #{endDate}");}
			if(!Strings.isNullOrEmpty(entity.getDescriptionSituation())) {sql.WHERE("description_situation = #{descriptionSituation}");}
			if(!Strings.isNullOrEmpty(entity.getExchangeGoods())) {sql.WHERE("exchange_goods = #{exchangeGoods}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getIsNotSolve())) {sql.WHERE("is_not_solve = #{isNotSolve}");}
			if(!Strings.isNullOrEmpty(entity.getName())) {sql.WHERE("name like CONCAT ('%',#{name},'%')");}
			if(!Strings.isNullOrEmpty(entity.getOrderNumber())) {sql.WHERE("order_number like CONCAT ('%',#{orderNumber},'%')");}
			if(!Strings.isNullOrEmpty(entity.getOriginalNumber())) {sql.WHERE("original_number = #{originalNumber}");}
			if(!Strings.isNullOrEmpty(entity.getReason())) {sql.WHERE("reason = #{reason}");}
			if(!Strings.isNullOrEmpty(entity.getReceivingAddress())) {sql.WHERE("receiving_address = #{receivingAddress}");}
			if(!Strings.isNullOrEmpty(entity.getReissueNumber())) {sql.WHERE("reissue_number = #{reissueNumber}");}
			if(!Strings.isNullOrEmpty(entity.getRemarks())) {sql.WHERE("remarks = #{remarks}");}
			if(StringUtils.isNotBlank(entity.getSelectFlg()) && entity.getSelectFlg().equals("1")){
				sql.WHERE("solution in ('2','3') ");
			}else{
				if(!Strings.isNullOrEmpty(entity.getSolution())) {sql.WHERE("solution = #{solution}");}
			}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			sql.WHERE("state ='1'");
			log.info("selectChComplaintInformationByCount---"+sql.toString());
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
	public String selectChComplaintInformationByLimt(ChComplaintInformation entity) {
		SQL sql = new SQL().SELECT("id,commodity_name AS commodityName,contact_information AS contactInformation,"
				+ "createtime AS createtime,date_complaint AS dateComplaint,description_situation AS descriptionSituation,"
				+ "exchange_goods AS exchangeGoods,is_not_solve AS isNotSolve,name AS name,order_number AS orderNumber,"
				+ "original_number AS originalNumber,reason AS reason,receiving_address AS receivingAddress,"
				+ "reissue_number AS reissueNumber,remarks AS remarks,solution AS solution,state AS state,"
				+ "updatetime AS updatetime,user_id AS userId").FROM("ch_complaint_information");
			if(!Strings.isNullOrEmpty(entity.getCommodityName())) {sql.WHERE("commodity_name = #{commodityName}");}
			if(!Strings.isNullOrEmpty(entity.getContactInformation())) {sql.WHERE("contact_information like CONCAT ('%',#{contactInformation},'%')");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getStarDate())) {sql.WHERE("date_complaint >= #{starDate}");}
			if(!Strings.isNullOrEmpty(entity.getEndDate())) {sql.WHERE("date_complaint <= #{endDate}");}
			if(!Strings.isNullOrEmpty(entity.getDescriptionSituation())) {sql.WHERE("description_situation = #{descriptionSituation}");}
			if(!Strings.isNullOrEmpty(entity.getExchangeGoods())) {sql.WHERE("exchange_goods = #{exchangeGoods}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getIsNotSolve())) {sql.WHERE("is_not_solve = #{isNotSolve}");}
			if(!Strings.isNullOrEmpty(entity.getName())) {sql.WHERE("name like CONCAT ('%',#{name},'%')");}
			if(!Strings.isNullOrEmpty(entity.getOrderNumber())) {sql.WHERE("order_number like CONCAT ('%',#{orderNumber},'%')");}
			if(!Strings.isNullOrEmpty(entity.getOriginalNumber())) {sql.WHERE("original_number = #{originalNumber}");}
			if(!Strings.isNullOrEmpty(entity.getReason())) {sql.WHERE("reason = #{reason}");}
			if(!Strings.isNullOrEmpty(entity.getReceivingAddress())) {sql.WHERE("receiving_address = #{receivingAddress}");}
			if(!Strings.isNullOrEmpty(entity.getReissueNumber())) {sql.WHERE("reissue_number = #{reissueNumber}");}
			if(!Strings.isNullOrEmpty(entity.getRemarks())) {sql.WHERE("remarks = #{remarks}");}
			if(StringUtils.isNotBlank(entity.getSelectFlg()) && entity.getSelectFlg().equals("1")){
				sql.WHERE("solution in  ('2','3') ");
			}else{
				if(!Strings.isNullOrEmpty(entity.getSolution())) {sql.WHERE("solution = #{solution}");}
			}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			sql.WHERE("state ='1'");
			log.info("selectChComplaintInformationByLimt---"+sql.toString());
		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectChComplaintInformation(ChComplaintInformation entity) {
		SQL sql = new SQL().SELECT("id,commodity_name AS commodityName,contact_information AS contactInformation,"
				+ "createtime AS createtime,date_complaint AS dateComplaint,description_situation AS descriptionSituation,"
				+ "exchange_goods AS exchangeGoods,is_not_solve AS isNotSolve,name AS name,order_number AS orderNumber,"
				+ "original_number AS originalNumber,reason AS reason,receiving_address AS receivingAddress,"
				+ "reissue_number AS reissueNumber,remarks AS remarks,solution AS solution,state AS state,"
				+ "updatetime AS updatetime,user_id AS userId").FROM("ch_complaint_information");
			if(!Strings.isNullOrEmpty(entity.getCommodityName())) {sql.WHERE("commodity_name = #{commodityName}");}
			if(!Strings.isNullOrEmpty(entity.getContactInformation())) {sql.WHERE("contact_information = #{contactInformation}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getDateComplaint())) {sql.WHERE("date_complaint = #{dateComplaint}");}
			if(!Strings.isNullOrEmpty(entity.getDescriptionSituation())) {sql.WHERE("description_situation = #{descriptionSituation}");}
			if(!Strings.isNullOrEmpty(entity.getExchangeGoods())) {sql.WHERE("exchange_goods = #{exchangeGoods}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getIsNotSolve())) {sql.WHERE("is_not_solve = #{isNotSolve}");}
			if(!Strings.isNullOrEmpty(entity.getName())) {sql.WHERE("name = #{name}");}
			if(!Strings.isNullOrEmpty(entity.getOrderNumber())) {sql.WHERE("order_number = #{orderNumber}");}
			if(!Strings.isNullOrEmpty(entity.getOriginalNumber())) {sql.WHERE("original_number = #{originalNumber}");}
			if(!Strings.isNullOrEmpty(entity.getReason())) {sql.WHERE("reason = #{reason}");}
			if(!Strings.isNullOrEmpty(entity.getReceivingAddress())) {sql.WHERE("receiving_address = #{receivingAddress}");}
			if(!Strings.isNullOrEmpty(entity.getReissueNumber())) {sql.WHERE("reissue_number = #{reissueNumber}");}
			if(!Strings.isNullOrEmpty(entity.getRemarks())) {sql.WHERE("remarks = #{remarks}");}
			if(!Strings.isNullOrEmpty(entity.getSolution())) {sql.WHERE("solution = #{solution}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			sql.WHERE("state ='1'");
			log.info("selectChComplaintInformation---"+sql.toString());
		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(@Param("id")int id) {
		SQL sql = new SQL().SELECT("id,commodity_name AS commodityName,contact_information AS contactInformation,"
				+ "createtime AS createtime,date_complaint AS dateComplaint,description_situation AS descriptionSituation,"
				+ "exchange_goods AS exchangeGoods,is_not_solve AS isNotSolve,name AS name,order_number AS orderNumber,"
				+ "original_number AS originalNumber,reason AS reason,receiving_address AS receivingAddress,"
				+ "reissue_number AS reissueNumber,remarks AS remarks,solution AS solution,state AS state,"
				+ "updatetime AS updatetime,user_id AS userId").FROM("ch_complaint_information");
		sql.WHERE("id = #{id}");
		log.info("selectOne---"+sql.toString());
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateChComplaintInformation(ChComplaintInformation entity) {
		SQL sql = new SQL().UPDATE("ch_complaint_information");
				sql.SET("commodity_name = #{commodityName}");
		sql.SET("contact_information = #{contactInformation}");
		sql.SET("date_complaint = #{dateComplaint}");
		sql.SET("description_situation = #{descriptionSituation}");
		sql.SET("exchange_goods = #{exchangeGoods}");
		sql.SET("is_not_solve = #{isNotSolve}");
		sql.SET("name = #{name}");
		sql.SET("order_number = #{orderNumber}");
		sql.SET("original_number = #{originalNumber}");
		sql.SET("reason = #{reason}");
		sql.SET("receiving_address = #{receivingAddress}");
		sql.SET("reissue_number = #{reissueNumber}");
		sql.SET("remarks = #{remarks}");
		sql.SET("solution = #{solution}");
		sql.SET("state = #{state}");
		sql.SET("user_id = #{userId}");
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		log.info("updateChComplaintInformation---"+sql.toString());
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateChComplaintInformationByNullChk(ChComplaintInformation entity) {
		SQL sql = new SQL().UPDATE("ch_complaint_information");
					if(!Strings.isNullOrEmpty(entity.getCommodityName())) {sql.SET("commodity_name = #{commodityName}");}
			if(!Strings.isNullOrEmpty(entity.getContactInformation())) {sql.SET("contact_information = #{contactInformation}");}
			if(!Strings.isNullOrEmpty(entity.getDateComplaint())) {sql.SET("date_complaint = #{dateComplaint}");}
			if(!Strings.isNullOrEmpty(entity.getDescriptionSituation())) {sql.SET("description_situation = #{descriptionSituation}");}
			if(!Strings.isNullOrEmpty(entity.getExchangeGoods())) {sql.SET("exchange_goods = #{exchangeGoods}");}
			if(!Strings.isNullOrEmpty(entity.getIsNotSolve())) {sql.SET("is_not_solve = #{isNotSolve}");}
			if(!Strings.isNullOrEmpty(entity.getName())) {sql.SET("name = #{name}");}
			if(!Strings.isNullOrEmpty(entity.getOrderNumber())) {sql.SET("order_number = #{orderNumber}");}
			if(!Strings.isNullOrEmpty(entity.getOriginalNumber())) {sql.SET("original_number = #{originalNumber}");}
			if(!Strings.isNullOrEmpty(entity.getReason())) {sql.SET("reason = #{reason}");}
			if(!Strings.isNullOrEmpty(entity.getReceivingAddress())) {sql.SET("receiving_address = #{receivingAddress}");}
			if(!Strings.isNullOrEmpty(entity.getReissueNumber())) {sql.SET("reissue_number = #{reissueNumber}");}
			if(!Strings.isNullOrEmpty(entity.getRemarks())) {sql.SET("remarks = #{remarks}");}
			if(!Strings.isNullOrEmpty(entity.getSolution())) {sql.SET("solution = #{solution}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.SET("state = #{state}");}
			if(!Objects.isNull(entity.getUserId())) {sql.SET("user_id = #{userId}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		log.info("updateChComplaintInformationByNullChk---"+sql.toString());
		return sql.toString();
	}
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public String deleteChComplaintInformation(@Param("id")int id) {
		SQL sql = new SQL().DELETE_FROM("ch_complaint_information");
		sql.WHERE("id = #{id}");
		log.info("deleteChComplaintInformation---"+sql.toString());
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(@Param("id")int id) {
		SQL sql = new SQL().UPDATE("ch_complaint_information");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		log.info("deleteByLogic---"+sql.toString());
		return sql.toString();
	}
}
