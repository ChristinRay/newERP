package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChProductItem;

/**
 * 商品供应商详情表
 * provider
 */
public class ChProductItemProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChProductItem(ChProductItem entity) {
		SQL sql = new SQL().INSERT_INTO("ch_product_item");
		sql.VALUES("product_id,supply_id,brand_id,supply_product_no,purchase_price,pack_price,freight_price,user_id,state,createtime,updatetime", "#{productId},#{supplyId},#{brandId},#{supplyProductNo},#{purchasePrice},#{packPrice},#{freightPrice},#{userId},#{state},now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChProductItemByCount(ChProductItem entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_product_item");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getSupplyId())) {sql.WHERE("supply_id = #{supplyId}");}
			if(!Objects.isNull(entity.getBrandId())) {sql.WHERE("brand_id = #{brandId}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyProductNo())) {sql.WHERE("supply_product_no = #{supplyProductNo}");}
			if(!Objects.isNull(entity.getPurchasePrice())) {sql.WHERE("purchase_price = #{purchasePrice}");}
			if(!Objects.isNull(entity.getPackPrice())) {sql.WHERE("pack_price = #{packPrice}");}
			if(!Objects.isNull(entity.getFreightPrice())) {sql.WHERE("freight_price = #{freightPrice}");}
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
	public String selectChProductItemByLimt(ChProductItem entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_product_item");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getSupplyId())) {sql.WHERE("supply_id = #{supplyId}");}
			if(!Objects.isNull(entity.getBrandId())) {sql.WHERE("brand_id = #{brandId}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyProductNo())) {sql.WHERE("supply_product_no = #{supplyProductNo}");}
			if(!Objects.isNull(entity.getPurchasePrice())) {sql.WHERE("purchase_price = #{purchasePrice}");}
			if(!Objects.isNull(entity.getPackPrice())) {sql.WHERE("pack_price = #{packPrice}");}
			if(!Objects.isNull(entity.getFreightPrice())) {sql.WHERE("freight_price = #{freightPrice}");}
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
	public String selectChProductItem(ChProductItem entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_product_item");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getSupplyId())) {sql.WHERE("supply_id = #{supplyId}");}
			if(!Objects.isNull(entity.getBrandId())) {sql.WHERE("brand_id = #{brandId}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyProductNo())) {sql.WHERE("supply_product_no = #{supplyProductNo}");}
			if(!Objects.isNull(entity.getPurchasePrice())) {sql.WHERE("purchase_price = #{purchasePrice}");}
			if(!Objects.isNull(entity.getPackPrice())) {sql.WHERE("pack_price = #{packPrice}");}
			if(!Objects.isNull(entity.getFreightPrice())) {sql.WHERE("freight_price = #{freightPrice}");}
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
		SQL sql = new SQL().SELECT("*").FROM("ch_product_item");
		sql.WHERE("id=#{id}");
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateChProductItemByNullChk(ChProductItem entity) {
		SQL sql = new SQL().UPDATE("ch_product_item");
					if(!Objects.isNull(entity.getProductId())) {sql.SET("product_id = #{productId}");}
			if(!Objects.isNull(entity.getSupplyId())) {sql.SET("supply_id = #{supplyId}");}
			if(!Objects.isNull(entity.getBrandId())) {sql.SET("brand_id = #{brandId}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyProductNo())) {sql.SET("supply_product_no = #{supplyProductNo}");}
			if(!Objects.isNull(entity.getPurchasePrice())) {sql.SET("purchase_price = #{purchasePrice}");}
			if(!Objects.isNull(entity.getPackPrice())) {sql.SET("pack_price = #{packPrice}");}
			if(!Objects.isNull(entity.getFreightPrice())) {sql.SET("freight_price = #{freightPrice}");}
			if(!Objects.isNull(entity.getUserId())) {sql.SET("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.SET("state = #{state}");}
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
		SQL sql = new SQL().UPDATE("ch_product_item");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
