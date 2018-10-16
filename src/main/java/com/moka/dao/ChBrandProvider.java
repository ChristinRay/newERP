package com.moka.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChBrand;

/**
 * 品牌表
 * provider
 */
@Mapper
public class ChBrandProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChBrand(ChBrand entity) {
		SQL sql = new SQL().INSERT_INTO("ch_brand");
		sql.VALUES("brand_name,brand_code,user_id,state,createtime,updatetime", "#{brandName},#{brandCode},#{userId},#{state},now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChBrandByCount(ChBrand entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_brand");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getBrandName())) {sql.WHERE("brand_name = #{brandName}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
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
	public String selectChBrandByLimt(ChBrand entity) {
		SQL sql = new SQL().SELECT(" id,brand_name as brandName,brand_code as brandCode,user_id as userId ").FROM("ch_brand");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getBrandName())) {sql.WHERE("brand_name = #{brandName}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
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
	public String selectChBrand(ChBrand entity) {
		SQL sql = new SQL().SELECT("id,brand_name as brandName,brand_code as brandCode,user_id as userId").FROM("ch_brand");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getBrandName())) {sql.WHERE("brand_name = #{brandName}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
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
		SQL sql = new SQL().SELECT("*").FROM("ch_brand");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateChBrand(ChBrand entity) {
		SQL sql = new SQL().UPDATE("ch_brand");
				sql.SET("brand_name = #{brandName}");
		sql.SET("brand_code = #{brandCode}");
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
	public String updateChBrandByNullChk(ChBrand entity) {
		SQL sql = new SQL().UPDATE("ch_brand");
					if(!Strings.isNullOrEmpty(entity.getBrandName())) {sql.SET("brand_name = #{brandName}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.SET("brand_code = #{brandCode}");}
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
	public String deleteChBrand(long id) {
		SQL sql = new SQL().DELETE_FROM("ch_brand");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("ch_brand");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
