package com.moka.dao;

import java.util.Objects;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.google.common.base.Strings;
import com.moka.model.ChProductItem;
import com.moka.req.ChProductItemSupplyReq;

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
		sql.VALUES("product_id,supply_id,brand_code,supply_product_no,purchase_price,pack_price,freight_price,freightway, user_id,state,createtime,updatetime", "#{productId},#{supplyId},#{brandCode},#{supplyProductNo},#{purchasePrice},#{packPrice},#{freightPrice},#{freightway},#{userId},#{state},now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChProductItemByCount(ChProductItem entity) {
		SQL sql = new SQL().SELECT(" a.id AS id,a.product_id AS productId,a.supply_id AS supplyId,"
				+ " b.sku,b.brand_code AS brandCode, b.product_type AS productType, c.supply_name AS supplyName,"
				+ " a.supply_product_no AS supplyProductNo, a.freight_price AS freightPrice, a.pack_price as packPrice, "
				+ " a.purchase_price AS purchasePrice ").FROM("ch_product_item a "
						+ " INNER JOIN ch_product b ON ( a.product_id = b.id ) "
						+ " INNER JOIN ch_supply c ON ( a.supply_id = c.id )");
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getSupplyId())) {sql.WHERE("supply_id = #{supplyId}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyProductNo())) {sql.WHERE("supply_product_no = #{supplyProductNo}");}
			if(!Objects.isNull(entity.getPurchasePrice())) {sql.WHERE("purchase_price = #{purchasePrice}");}
			if(!Objects.isNull(entity.getPackPrice())) {sql.WHERE("pack_price = #{packPrice}");}
			if(!Objects.isNull(entity.getFreightPrice())) {sql.WHERE("freight_price = #{freightPrice}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			
		return "select count(*) from"+"("+ sql.toString()+")a";
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
		SQL sql = new SQL().SELECT(" a.id AS id,a.product_id AS productId,a.supply_id AS supplyId,"
				+ " b.sku,b.brand_code AS brandCode, b.product_type AS productType, c.supply_name AS supplyName,"
				+ " a.supply_product_no AS supplyProductNo, a.freight_price AS freightPrice,a.freightway, a.pack_price as packPrice, "
				+ " a.purchase_price AS purchasePrice,b.product_code AS productCode,a.createtime,a.updatetime,a.state ").FROM("ch_product_item a "
				+ " INNER JOIN ch_product b ON ( a.product_id = b.id ) "
				+ " INNER JOIN ch_supply c ON ( a.supply_id = c.id )");
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getSupplyId())) {sql.WHERE("supply_id = #{supplyId}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getSupplyProductNo())) {sql.WHERE("supply_product_no = #{supplyProductNo}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}

		return sql.toString() + " order by a." + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
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
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
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
		SQL sql = new SQL().SELECT(" a.id AS id,a.product_id AS productId,a.supply_id AS supplyId,"
				+ " b.sku,b.brand_code AS brandCode, b.product_type AS productType, c.supply_name AS supplyName,"
				+ " a.supply_product_no AS supplyProductNo, a.freight_price AS freightPrice,a.freightway, a.pack_price as packPrice, "
				+ " a.purchase_price AS purchasePrice,b.product_code AS productCode,a.createtime,a.updatetime,a.state ").FROM("ch_product_item a "
				+ " INNER JOIN ch_product b ON ( a.product_id = b.id ) "
				+ " INNER JOIN ch_supply c ON ( a.supply_id = c.id )");
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
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
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
	/**
	 * 查询已授权品牌信息和供应商下商品基本信息SQL
	 * @return
	 */
	public String findSupplyByBrand(ChProductItemSupplyReq req){
		SQL sql = new SQL().SELECT(" a.id AS supplyId,b.id AS productId,a.supply_name as supplyName, a.accredit_brand AS accreditBrand,"
				+ " b.product_code AS productCode,b.sku,b.product_unit AS productUnit,b.product_weight AS productWeight,"
				+ " b.product_name AS productName").FROM(" ch_supply a INNER JOIN ch_product b ON(a.accredit_brand=b.brand_code)");
		if(!Objects.isNull(req.getProductId())) {sql.WHERE(" b.id = #{productId}");}
		if(!Objects.isNull(req.getSupplyId())) {sql.WHERE(" a.id = #{supplyId}");}
		if(!Strings.isNullOrEmpty(req.getAccreditBrand())) {sql.WHERE(" a.accredit_brand = #{accreditBrand}");}
		sql.WHERE("  a.state='1' AND b.state='1'");
		return sql.toString();
	}
}
