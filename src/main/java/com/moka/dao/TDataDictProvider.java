package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.TDataDict;

/**
 * 系统字典表
 * provider
 */
public class TDataDictProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertTDataDict(TDataDict entity) {
		SQL sql = new SQL().INSERT_INTO("t_data_dict");
		sql.VALUES("sys_code,field_code,code,value", "#{sysCode},#{fieldCode},#{code},#{value}");
		return sql.toString();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectTDataDict(TDataDict entity) {
		SQL sql = new SQL().SELECT(" id,sys_code as sysCode,field_code as fieldCode,code,value").FROM("t_data_dict");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getSysCode())) {sql.WHERE("sys_code = #{sysCode}");}
			if(!Strings.isNullOrEmpty(entity.getFieldCode())) {sql.WHERE("field_code = #{fieldCode}");}
			if(!Strings.isNullOrEmpty(entity.getCode())) {sql.WHERE("code = #{code}");}
			if(!Strings.isNullOrEmpty(entity.getValue())) {sql.WHERE("value = #{value}");}

		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateTDataDictByNullChk(TDataDict entity) {
		SQL sql = new SQL().UPDATE("t_data_dict");
					if(!Strings.isNullOrEmpty(entity.getSysCode())) {sql.SET("sys_code = #{sysCode}");}
			if(!Strings.isNullOrEmpty(entity.getFieldCode())) {sql.SET("field_code = #{fieldCode}");}
			if(!Strings.isNullOrEmpty(entity.getCode())) {sql.SET("code = #{code}");}
			if(!Strings.isNullOrEmpty(entity.getValue())) {sql.SET("value = #{value}");}
		sql.SET("updatetime = now()");

		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	public String deleteTDataDict(int id) {
		SQL sql = new SQL().DELETE_FROM("t_data_dict");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 根据id得到相应的值
	 * @param id
	 * @return
	 */
	public String getValueById(@Param("id")int id){
		SQL sql = new SQL().SELECT(" id,sys_code as sysCode,field_code as fieldCode,code,value").FROM("t_data_dict");
		sql.WHERE("id=#{id}");
		return sql.toString();
	}
}
