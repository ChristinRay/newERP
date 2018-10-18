package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChCategory;

/**
 * 
 * provider
 */
public class ChCategoryProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChCategory(ChCategory entity) {
		SQL sql = new SQL().INSERT_INTO("ch_category");
		sql.VALUES("category_name,father_id", "#{categoryName},#{fatherId}");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChCategoryByCount(ChCategory entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_category");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getCategoryName())) {sql.WHERE("category_name = #{categoryName}");}
			if(!Objects.isNull(entity.getFatherId())) {sql.WHERE("father_id = #{fatherId}");}

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
	public String selectChCategoryByLimt(ChCategory entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_category");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getCategoryName())) {sql.WHERE("category_name = #{categoryName}");}
			if(!Objects.isNull(entity.getFatherId())) {sql.WHERE("father_id = #{fatherId}");}

		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectChCategory(ChCategory entity) {
		SQL sql = new SQL().SELECT(" id,category_name as categoryName,father_id as fatherId").FROM("ch_category");
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getCategoryName())) {sql.WHERE("category_name = #{categoryName}");}
			if(!Objects.isNull(entity.getFatherId())) {sql.WHERE("father_id = #{fatherId}");}

		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(int id) {
		SQL sql = new SQL().SELECT("*").FROM("ch_category");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateChCategoryByNullChk(ChCategory entity) {
		SQL sql = new SQL().UPDATE("ch_category");
					if(!Strings.isNullOrEmpty(entity.getCategoryName())) {sql.SET("category_name = #{categoryName}");}
			if(!Objects.isNull(entity.getFatherId())) {sql.SET("father_id = #{fatherId}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(int id) {
		SQL sql = new SQL().UPDATE("ch_category");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 查询所有类别
	 * @return
	 */
	public String selectChCategoryAll(){
		SQL sql = new SQL().SELECT("id,category_name as categoryName,father_id as fatherId").FROM("ch_category");
		return sql.toString();
	}
}
