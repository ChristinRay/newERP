package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.SysResources;

/**
 * 权限表
 * provider
 */
public class SysResourcesProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertSysResources(SysResources entity) {
		SQL sql = new SQL().INSERT_INTO("sys_resources");
		sql.VALUES("user_name,res_url,user_type,user_sort", "#{userName},#{resUrl},#{userType},#{userSort}");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectSysResourcesByCount(SysResources entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("sys_resources");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getUserName())) {sql.WHERE("user_name = #{userName}");}
			if(!Strings.isNullOrEmpty(entity.getResUrl())) {sql.WHERE("res_url = #{resUrl}");}
			if(!Objects.isNull(entity.getUserType())) {sql.WHERE("user_type = #{userType}");}
			if(!Objects.isNull(entity.getUserSort())) {sql.WHERE("user_sort = #{userSort}");}

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
	public String selectSysResourcesByLimt(SysResources entity) {
		SQL sql = new SQL().SELECT("*").FROM("sys_resources");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getUserName())) {sql.WHERE("user_name = #{userName}");}
			if(!Strings.isNullOrEmpty(entity.getResUrl())) {sql.WHERE("res_url = #{resUrl}");}
			if(!Objects.isNull(entity.getUserType())) {sql.WHERE("user_type = #{userType}");}
			if(!Objects.isNull(entity.getUserSort())) {sql.WHERE("user_sort = #{userSort}");}

		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectSysResources(SysResources entity) {
		SQL sql = new SQL().SELECT("*").FROM("sys_resources");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getUserName())) {sql.WHERE("user_name = #{userName}");}
			if(!Strings.isNullOrEmpty(entity.getResUrl())) {sql.WHERE("res_url = #{resUrl}");}
			if(!Objects.isNull(entity.getUserType())) {sql.WHERE("user_type = #{userType}");}
			if(!Objects.isNull(entity.getUserSort())) {sql.WHERE("user_sort = #{userSort}");}

		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(long id) {
		SQL sql = new SQL().SELECT("*").FROM("sys_resources");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateSysResources(SysResources entity) {
		SQL sql = new SQL().UPDATE("sys_resources");
				sql.SET("user_name = #{userName}");
		sql.SET("res_url = #{resUrl}");
		sql.SET("user_type = #{userType}");
		sql.SET("user_sort = #{userSort}");
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateSysResourcesByNullChk(SysResources entity) {
		SQL sql = new SQL().UPDATE("sys_resources");
					if(!Strings.isNullOrEmpty(entity.getUserName())) {sql.SET("user_name = #{userName}");}
			if(!Strings.isNullOrEmpty(entity.getResUrl())) {sql.SET("res_url = #{resUrl}");}
			if(!Objects.isNull(entity.getUserType())) {sql.SET("user_type = #{userType}");}
			if(!Objects.isNull(entity.getUserSort())) {sql.SET("user_sort = #{userSort}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public String deleteSysResources(long id) {
		SQL sql = new SQL().DELETE_FROM("sys_resources");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("sys_resources");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
