package com.moka.dao;

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
		sql.VALUES("product_code,brand_code,product_name,prodct_english_name,product_size,product_type,product_unit,product_weight,picture,user_id,state,createtime,updatetime", "#{productCode},#{brandCode},#{productName},#{prodctEnglishName},#{productSize},#{productType},#{productUnit},#{productWeight},#{picture},#{userId},#{state},now(),now()");
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
			if(!Strings.isNullOrEmpty(entity.getProductSize())) {sql.WHERE("product_size = #{productSize}");}
			if(!Strings.isNullOrEmpty(entity.getProductType())) {sql.WHERE("product_type = #{productType}");}
			if(!Strings.isNullOrEmpty(entity.getProductUnit())) {sql.WHERE("product_unit = #{productUnit}");}
			if(!Strings.isNullOrEmpty(entity.getProductWeight())) {sql.WHERE("product_weight = #{productWeight}");}
			if(!Strings.isNullOrEmpty(entity.getPicture())) {sql.WHERE("picture = #{picture}");}
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
		SQL sql = new SQL().SELECT("*").FROM("ch_product");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getProductCode())) {sql.WHERE("product_code = #{productCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getProductName())) {sql.WHERE("product_name = #{productName}");}
			if(!Strings.isNullOrEmpty(entity.getProductEnglishName())) {sql.WHERE("product_english_name = #{productEnglishName}");}
			if(!Strings.isNullOrEmpty(entity.getProductSize())) {sql.WHERE("product_size = #{productSize}");}
			if(!Strings.isNullOrEmpty(entity.getProductType())) {sql.WHERE("product_type = #{productType}");}
			if(!Strings.isNullOrEmpty(entity.getProductUnit())) {sql.WHERE("product_unit = #{productUnit}");}
			if(!Strings.isNullOrEmpty(entity.getProductWeight())) {sql.WHERE("product_weight = #{productWeight}");}
			if(!Strings.isNullOrEmpty(entity.getPicture())) {sql.WHERE("picture = #{picture}");}
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
		SQL sql = new SQL().SELECT("*").FROM("ch_product");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getProductCode())) {sql.WHERE("product_code = #{productCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getProductName())) {sql.WHERE("product_name = #{productName}");}
			if(!Strings.isNullOrEmpty(entity.getProductEnglishName())) {sql.WHERE("product_english_name = #{productEnglishName}");}
			if(!Strings.isNullOrEmpty(entity.getProductSize())) {sql.WHERE("product_size = #{productSize}");}
			if(!Strings.isNullOrEmpty(entity.getProductType())) {sql.WHERE("product_type = #{productType}");}
			if(!Strings.isNullOrEmpty(entity.getProductUnit())) {sql.WHERE("product_unit = #{productUnit}");}
			if(!Strings.isNullOrEmpty(entity.getProductWeight())) {sql.WHERE("product_weight = #{productWeight}");}
			if(!Strings.isNullOrEmpty(entity.getPicture())) {sql.WHERE("picture = #{picture}");}
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
		SQL sql = new SQL().SELECT("*").FROM("ch_product");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateChProduct(ChProduct entity) {
		SQL sql = new SQL().UPDATE("ch_product");
				sql.SET("product_code = #{productCode}");
		sql.SET("brand_code = #{brandCode}");
		sql.SET("product_name = #{productName}");
		sql.SET("prodct_english_name = #{prodctEnglishName}");
		sql.SET("product_size = #{productSize}");
		sql.SET("product_type = #{productType}");
		sql.SET("product_unit = #{productUnit}");
		sql.SET("product_weight = #{productWeight}");
		sql.SET("picture = #{picture}");
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
	public String updateChProductByNullChk(ChProduct entity) {
		SQL sql = new SQL().UPDATE("ch_product");
					if(!Strings.isNullOrEmpty(entity.getProductCode())) {sql.SET("product_code = #{productCode}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.SET("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getProductName())) {sql.SET("product_name = #{productName}");}
			if(!Strings.isNullOrEmpty(entity.getProductEnglishName())) {sql.SET("product_english_name = #{productEnglishName}");}
			if(!Strings.isNullOrEmpty(entity.getProductSize())) {sql.SET("product_size = #{productSize}");}
			if(!Strings.isNullOrEmpty(entity.getProductType())) {sql.SET("product_type = #{productType}");}
			if(!Strings.isNullOrEmpty(entity.getProductUnit())) {sql.SET("product_unit = #{productUnit}");}
			if(!Strings.isNullOrEmpty(entity.getProductWeight())) {sql.SET("product_weight = #{productWeight}");}
			if(!Strings.isNullOrEmpty(entity.getPicture())) {sql.SET("picture = #{picture}");}
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
	public String deleteChProduct(long id) {
		SQL sql = new SQL().DELETE_FROM("ch_product");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("ch_product");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
