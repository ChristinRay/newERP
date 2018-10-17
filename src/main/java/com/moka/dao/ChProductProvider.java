package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChProduct;

/**
 * 商品表
 * provider
 */
public class ChProductProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChProduct(ChProduct entity) {
		SQL sql = new SQL().INSERT_INTO("ch_product");
		sql.VALUES("product_code,brand_code,product_name,product_english_name,product_size,product_type,product_unit,product_weight,length,width,height,picture,sku,user_id,state,createtime,updatetime", "#{productCode},#{brandCode},#{productName},#{productEnglishName},#{productSize},#{productType},#{productUnit},#{productWeight},#{length},#{width},#{height},#{picture},#{sku},'1','1',now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChProductByCount(ChProduct entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_product");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getProductCode())) {sql.WHERE("product_code = #{productCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getProductName())) {sql.WHERE("product_name = #{productName}");}
			if(!Strings.isNullOrEmpty(entity.getProductEnglishName())) {sql.WHERE("product_english_name = #{productEnglishName}");}
			if(!Objects.isNull(entity.getProductSize())) {sql.WHERE("product_size = #{productSize}");}
			if(!Strings.isNullOrEmpty(entity.getProductType())) {sql.WHERE("product_type = #{productType}");}
			if(!Strings.isNullOrEmpty(entity.getProductUnit())) {sql.WHERE("product_unit = #{productUnit}");}
			if(!Strings.isNullOrEmpty(entity.getProductWeight())) {sql.WHERE("product_weight = #{productWeight}");}
			if(!Strings.isNullOrEmpty(entity.getLength())) {sql.WHERE("length = #{length}");}
			if(!Strings.isNullOrEmpty(entity.getWidth())) {sql.WHERE("width = #{width}");}
			if(!Strings.isNullOrEmpty(entity.getHeight())) {sql.WHERE("height = #{height}");}
			if(!Strings.isNullOrEmpty(entity.getPicture())) {sql.WHERE("picture = #{picture}");}
			if(!Strings.isNullOrEmpty(entity.getSku())) {sql.WHERE("sku = #{sku}");}
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
	public String selectChProductByLimt(ChProduct entity) {
		SQL sql = new SQL().SELECT(" id,product_code as productCode,brand_code as brandCode,product_name as productName,"
				+ "product_english_name as productEnglishName,product_size as productSize,product_type as  productType,"
				+ "product_unit as productUnit,product_weight as productWeight,length,width,height,picture,user_id as userId ,"
				+ "state,createtime,updatetime").FROM("ch_product");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getProductCode())) {sql.WHERE("product_code = #{productCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getProductName())) {sql.WHERE("product_name = #{productName}");}
			if(!Strings.isNullOrEmpty(entity.getProductEnglishName())) {sql.WHERE("product_english_name = #{productEnglishName}");}
			if(!Objects.isNull(entity.getProductSize())) {sql.WHERE("product_size = #{productSize}");}
			if(!Strings.isNullOrEmpty(entity.getProductType())) {sql.WHERE("product_type = #{productType}");}
			if(!Strings.isNullOrEmpty(entity.getProductUnit())) {sql.WHERE("product_unit = #{productUnit}");}
			if(!Strings.isNullOrEmpty(entity.getProductWeight())) {sql.WHERE("product_weight = #{productWeight}");}
			if(!Strings.isNullOrEmpty(entity.getLength())) {sql.WHERE("length = #{length}");}
			if(!Strings.isNullOrEmpty(entity.getWidth())) {sql.WHERE("width = #{width}");}
			if(!Strings.isNullOrEmpty(entity.getHeight())) {sql.WHERE("height = #{height}");}
			if(!Strings.isNullOrEmpty(entity.getPicture())) {sql.WHERE("picture = #{picture}");}
			if(!Strings.isNullOrEmpty(entity.getSku())) {sql.WHERE("sku = #{sku}");}
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
	public String selectChProduct(ChProduct entity) {
		SQL sql = new SQL().SELECT(" id,product_code as productCode,brand_code as brandCode,product_name as productName,"
				+ "product_english_name as productEnglishName,product_size as productSize,product_type as  productType,"
				+ "product_unit as productUnit,product_weight as productWeight,length,width,height,picture,user_id as userId ,"
				+ "state,createtime,updatetime").FROM("ch_product");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getProductCode())) {sql.WHERE("product_code = #{productCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getProductName())) {sql.WHERE("product_name = #{productName}");}
			if(!Strings.isNullOrEmpty(entity.getProductEnglishName())) {sql.WHERE("product_english_name = #{productEnglishName}");}
			if(!Objects.isNull(entity.getProductSize())) {sql.WHERE("product_size = #{productSize}");}
			if(!Strings.isNullOrEmpty(entity.getProductType())) {sql.WHERE("product_type = #{productType}");}
			if(!Strings.isNullOrEmpty(entity.getProductUnit())) {sql.WHERE("product_unit = #{productUnit}");}
			if(!Strings.isNullOrEmpty(entity.getProductWeight())) {sql.WHERE("product_weight = #{productWeight}");}
			if(!Strings.isNullOrEmpty(entity.getLength())) {sql.WHERE("length = #{length}");}
			if(!Strings.isNullOrEmpty(entity.getWidth())) {sql.WHERE("width = #{width}");}
			if(!Strings.isNullOrEmpty(entity.getHeight())) {sql.WHERE("height = #{height}");}
			if(!Strings.isNullOrEmpty(entity.getPicture())) {sql.WHERE("picture = #{picture}");}
			if(!Strings.isNullOrEmpty(entity.getSku())) {sql.WHERE("sku = #{sku}");}
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
		SQL sql = new SQL().SELECT(" id,product_code as productCode,brand_code as brandCode,product_name as productName,product_english_name as productEnglishName,product_size as productSize,product_type as  productType,product_unit as productUnit,product_weight as productWeight,length,width,height,picture,user_id as userId ,state,createtime,updatetime").FROM("ch_product");
		sql.WHERE("id=#{id}");
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateChProductByNullChk(ChProduct entity) {
		SQL sql = new SQL().UPDATE("ch_product");
					if(!Strings.isNullOrEmpty(entity.getProductCode())) {sql.SET("product_code = #{productCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.SET("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getProductName())) {sql.SET("product_name = #{productName}");}
			if(!Strings.isNullOrEmpty(entity.getProductEnglishName())) {sql.SET("product_english_name = #{productEnglishName}");}
			if(!Objects.isNull(entity.getProductSize())) {sql.WHERE("product_size = #{productSize}");}
			if(!Strings.isNullOrEmpty(entity.getProductType())) {sql.SET("product_type = #{productType}");}
			if(!Strings.isNullOrEmpty(entity.getProductUnit())) {sql.SET("product_unit = #{productUnit}");}
			if(!Strings.isNullOrEmpty(entity.getProductWeight())) {sql.SET("product_weight = #{productWeight}");}
			if(!Strings.isNullOrEmpty(entity.getLength())) {sql.SET("length = #{length}");}
			if(!Strings.isNullOrEmpty(entity.getWidth())) {sql.SET("width = #{width}");}
			if(!Strings.isNullOrEmpty(entity.getHeight())) {sql.SET("height = #{height}");}
			if(!Strings.isNullOrEmpty(entity.getPicture())) {sql.SET("picture = #{picture}");}
			if(!Strings.isNullOrEmpty(entity.getSku())) {sql.SET("sku = #{sku}");}
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
		SQL sql = new SQL().UPDATE("ch_product");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
