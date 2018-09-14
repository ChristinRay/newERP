package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChSupplyProduct;

/**
 * 商品供应商关联表
 * provider
 */
public class ChSupplyProductProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChSupplyProduct(ChSupplyProduct entity) {
		SQL sql = new SQL().INSERT_INTO("ch_supply_product");
		sql.VALUES("supply_id,product_id,product_price,product_freight_price,user_id,state,createtime,updatetime", "#{supplyId},#{productId},#{productPrice},#{productFreightPrice},#{userId},#{state},now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChSupplyProductByCount(ChSupplyProduct entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_supply_product");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getSupplyId())) {sql.WHERE("supply_id = #{supplyId}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getProductPrice())) {sql.WHERE("product_price = #{productPrice}");}
			if(!Objects.isNull(entity.getProductFreightPrice())) {sql.WHERE("product_freight_price = #{productFreightPrice}");}
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
	public String selectChSupplyProductByLimt(ChSupplyProduct entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_supply_product");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getSupplyId())) {sql.WHERE("supply_id = #{supplyId}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getProductPrice())) {sql.WHERE("product_price = #{productPrice}");}
			if(!Objects.isNull(entity.getProductFreightPrice())) {sql.WHERE("product_freight_price = #{productFreightPrice}");}
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
	public String selectChSupplyProduct(ChSupplyProduct entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_supply_product");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getSupplyId())) {sql.WHERE("supply_id = #{supplyId}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getProductPrice())) {sql.WHERE("product_price = #{productPrice}");}
			if(!Objects.isNull(entity.getProductFreightPrice())) {sql.WHERE("product_freight_price = #{productFreightPrice}");}
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
		SQL sql = new SQL().SELECT("*").FROM("ch_supply_product");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateChSupplyProduct(ChSupplyProduct entity) {
		SQL sql = new SQL().UPDATE("ch_supply_product");
				sql.SET("supply_id = #{supplyId}");
		sql.SET("product_id = #{productId}");
		sql.SET("product_price = #{productPrice}");
		sql.SET("product_freight_price = #{productFreightPrice}");
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
	public String updateChSupplyProductByNullChk(ChSupplyProduct entity) {
		SQL sql = new SQL().UPDATE("ch_supply_product");
					if(!Objects.isNull(entity.getSupplyId())) {sql.SET("supply_id = #{supplyId}");}
			if(!Objects.isNull(entity.getProductId())) {sql.SET("product_id = #{productId}");}
			if(!Objects.isNull(entity.getProductPrice())) {sql.SET("product_price = #{productPrice}");}
			if(!Objects.isNull(entity.getProductFreightPrice())) {sql.SET("product_freight_price = #{productFreightPrice}");}
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
	public String deleteChSupplyProduct(long id) {
		SQL sql = new SQL().DELETE_FROM("ch_supply_product");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("ch_supply_product");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
