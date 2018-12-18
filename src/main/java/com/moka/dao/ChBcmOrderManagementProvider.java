package com.moka.dao;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.ibatis.jdbc.SQL;

import com.google.common.base.Strings;
import com.moka.model.ChBcmOrderManagement;
import com.moka.model.ChCompany;

/**
 * 仓库表
 * provider
 */
public class ChBcmOrderManagementProvider {
	/**
	 * 插入操作
	 * @param list
	 * @return
	 */
	public String insertList(Map<String,List<ChBcmOrderManagement>> map) { 
            List<ChBcmOrderManagement> list = map.get("list");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into ch_bcm_order_manager(order_number,order_time,consignee_name,consignee_contact,consignee_address,goods_number,goods_name,buy_type,goods_status,distributor_name,distributor_number,delivery_time,order_type,payment_type,user_id,state,createtime,updatetime,order_platform) values");
            MessageFormat messageFormat = new MessageFormat("(#'{'list[{0}].orderNumber}, " +
                    "#'{'list[{0}].orderTime}, #'{'list[{0}].consigneeName}, " +
                    "#'{'list[{0}].consigneeContact}, #'{'list[{0}].consigneeAddress}, " +
                    "#'{'list[{0}].goodsNumber}, #'{'list[{0}].goodsName}," +
                    "#'{'list[{0}].buyType}),#'{'list[{0}].goodsStatus}," +
                    "#'{'list[{0}].distributorName}),#'{'list[{0}].distributorNumber}," +
                    "#'{'list[{0}].deliveryTime}),#'{'list[{0}].orderType}," +
                    "#'{'list[{0}].paymentType}),#'{'list[{0}].userId}," +
                    "'1',now(),now(),#'{'list[{0}].orderPlatform})");
            System.out.println(stringBuilder.toString());
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(messageFormat.format(new Integer[]{i}));
                stringBuilder.append(",");
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
		
		

//		System.out.println("insertList");
//       // 获取真正的参数
//		List<ChBcmOrderManagement> devList = map.get("list");
//		StringBuilder sql = new StringBuilder();
//		sql.append("insert into ch_bcm_order_manager ");
//		sql.append("(order_number,order_time,consignee_name,"
//				+ "consignee_contact,consignee_address,goods_number,goods_name,buy_type,goods_status,"
//				+ "distributor_name,distributor_number,delivery_time,order_type,payment_type,user_id,"
//				+ "state,createtime,updatetime,order_platform) values");
//		for (int i = 0; i < devList.size(); i++) {
//        //这里的list为在map中的key值
//			sql.append("(#{list["+i+"].orderNumber},#{list["+i+"].orderTime},#{list["+i+"].consigneeName},"
//					+ "#{list["+i+"].consigneeContact},#{list["+i+"].consigneeAddress},"
//							+ "#{list["+i+"].goodsNumber},#{list["+i+"].goodsName},#{list["+i+"].buyType},"
//							+ "#{list["+i+"].goodsStatus},#{list["+i+"].distributorName},#{list["+i+"].distributorNumber},"
//							+ "#{list["+i+"].deliveryTime},#{list["+i+"].orderType},#{list["+i+"].paymentType},"
//									+ "#{list["+i+"].userId},'1',now(),now(),#{list["+i+"].orderPlatform})");
//			if(i!=devList.size()-1){
//				sql.append(",");
//			}else
//				sql.append(";");
//		}
//		System.out.println(sql.toString());
//		return sql.toString();
//
//	}
	
	
	
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChBcmOrderByCount(ChBcmOrderManagement entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_bcm_order_manager");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getOrderNumber())) {sql.WHERE("order_number = #{orderNumber}");}
			if(!Strings.isNullOrEmpty(entity.getOrderTime())) {sql.WHERE("order_time = #{orderTime}");}
			if(!Strings.isNullOrEmpty(entity.getConsigneeName())){sql.WHERE(" consignee_name=#{consigneeName}");}
			if(!Strings.isNullOrEmpty(entity.getConsigneeContact())) {sql.WHERE("consignee_contact = #{consigneeContact}");}
			if(!Strings.isNullOrEmpty(entity.getConsigneeAddress())) {sql.WHERE("consignee_address = #{consigneeAddress}");}
			if(!Strings.isNullOrEmpty(entity.getGoodsNumber())) {sql.WHERE("goods_number = #{goodsNumber}");}
			if(!Strings.isNullOrEmpty(entity.getGoodsName())) {sql.WHERE("goods_name = #{goodsName}");}			
			if(!Strings.isNullOrEmpty(entity.getBuyType())) {sql.WHERE("buy_type = #{buyType}");}
			if(!Strings.isNullOrEmpty(entity.getGoodsStatus())) {sql.WHERE("goods_status = #{goodsStatus}");}
			if(!Strings.isNullOrEmpty(entity.getDistributorName())) {sql.WHERE("distributor_name = #{distributorName}");}
			if(!Objects.isNull(entity.getDistributorNumber())) {sql.WHERE("distributor_number = #{distributorNumber}");}
			if(!Strings.isNullOrEmpty(entity.getDeliveryTime())) {sql.WHERE("delivery_time = #{deliveryTime}");}
			if(!Strings.isNullOrEmpty(entity.getOrderType())) {sql.WHERE("order_type = #{orderType}");}
			if(!Strings.isNullOrEmpty(entity.getPaymentType())) {sql.WHERE("payment_type = #{paymentType}");}	
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			sql.WHERE(" goods_status='已发货'");
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
	public String selectChBcmOrderByLimt(ChBcmOrderManagement entity) {
		SQL sql = new SQL().SELECT("id, order_number as orderNumber,order_time as orderTime,consignee_name as consigneeName,consignee_contact as consigneeContact,"
				+ "consignee_address as consigneeContact,goods_number as goodsNumber,goods_name as goodsName,"
				+ "buy_type as buyType,goods_status as goodsStatus,distributor_name as distributorName,"
				+ "distributor_number as distributorNumber,delivery_time as deliveryTime,order_type as orderType,payment_type as paymentType,"
				+ "user_id as userId,state,createtime,updatetime ").FROM("ch_bcm_order_manager");
		    if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getOrderNumber())) {sql.WHERE("order_number = #{orderNumber}");}
			if(!Strings.isNullOrEmpty(entity.getOrderTime())) {sql.WHERE("order_time = #{orderTime}");}
			if(!Strings.isNullOrEmpty(entity.getConsigneeName())){sql.WHERE(" consignee_name=#{consigneeName}");}
			if(!Strings.isNullOrEmpty(entity.getConsigneeContact())) {sql.WHERE("consignee_contact = #{consigneeContact}");}
			if(!Strings.isNullOrEmpty(entity.getConsigneeAddress())) {sql.WHERE("consignee_address = #{consigneeAddress}");}
			if(!Strings.isNullOrEmpty(entity.getGoodsNumber())) {sql.WHERE("goods_number = #{goodsNumber}");}
			if(!Strings.isNullOrEmpty(entity.getGoodsName())) {sql.WHERE("goods_name = #{goodsName}");}			
			if(!Strings.isNullOrEmpty(entity.getBuyType())) {sql.WHERE("buy_type = #{buyType}");}
			if(!Strings.isNullOrEmpty(entity.getGoodsStatus())) {sql.WHERE("goods_status = #{goodsStatus}");}
			if(!Strings.isNullOrEmpty(entity.getDistributorName())) {sql.WHERE("distributor_name = #{distributorName}");}
			if(!Objects.isNull(entity.getDistributorNumber())) {sql.WHERE("distributor_number = #{distributorNumber}");}
			if(!Strings.isNullOrEmpty(entity.getDeliveryTime())) {sql.WHERE("delivery_time = #{deliveryTime}");}
			if(!Strings.isNullOrEmpty(entity.getOrderType())) {sql.WHERE("order_type = #{orderType}");}
            if(!Strings.isNullOrEmpty(entity.getPaymentType())) {sql.WHERE("payment_type = #{paymentType}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			sql.WHERE(" goods_status='已发货'");
			String aaa=sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
			System.out.println(aaa);
		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
}
