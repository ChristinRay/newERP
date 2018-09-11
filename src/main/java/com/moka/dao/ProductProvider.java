package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.Product;

/**
 * 
 * provider
 */
public class ProductProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertProduct(Product entity) {
		SQL sql = new SQL().INSERT_INTO("product");
		sql.VALUES("product_no", "#{product_no}");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectProductByCount(Product entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("product");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getProduct_no())) {sql.WHERE("product_no = #{product_no}");}

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
	public String selectProductByLimt(Product entity) {
		SQL sql = new SQL().SELECT("*").FROM("product");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getProduct_no())) {sql.WHERE("product_no = #{product_no}");}

		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectProduct(Product entity) {
		SQL sql = new SQL().SELECT("*").FROM("product");
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getProduct_no())) {sql.WHERE("product_no = #{product_no}");}

		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(long id) {
		SQL sql = new SQL().SELECT("*").FROM("product");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateProduct(Product entity) {
		SQL sql = new SQL().UPDATE("product");
				sql.SET("product_no = #{product_no}");
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateProductByNullChk(Product entity) {
		SQL sql = new SQL().UPDATE("product");
					if(!Strings.isNullOrEmpty(entity.getProduct_no())) {sql.SET("product_no = #{product_no}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public String deleteProduct(long id) {
		SQL sql = new SQL().DELETE_FROM("product");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("product");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
