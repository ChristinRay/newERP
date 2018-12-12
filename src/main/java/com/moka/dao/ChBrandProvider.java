package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChBrand;

/**
 * 品牌表
 * provider
 */
public class ChBrandProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChBrand(ChBrand entity) {
		SQL sql = new SQL().INSERT_INTO("ch_brand");
		sql.VALUES("brand_name,brand_code,accredit_level,accredit_start_time,accredit_end_time,company_id,channel_id,user_id,state,createtime,updatetime", "#{brandName},#{brandCode},#{accreditLevel},#{accreditStartTime},#{accreditEndTime},#{companyId},#{channelId},#{userId},'1',now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChBrandByCount(ChBrand entity) {
		SQL sql = new SQL().SELECT(
				  "a.id,a.brand_code AS brandCode,"
				+ "a.brand_name AS brandName,a.accredit_level AS accreditLevel,"
				+ "a.accredit_start_time AS accreditStartTime,a.accredit_end_time AS accreditEndTime,"
				+ "a.company_id AS companyId,"
				+ "b.channel_name as channelName,a.user_id as userId")
				.FROM("ch_brand a").INNER_JOIN("ch_channel b on(a.channel_id=b.id)");
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getBrandName())) {sql.WHERE("brand_name = #{brandName}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.WHERE("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			sql.WHERE("a.state ='1'");
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
	public String selectChBrandByLimt(ChBrand entity) {
		SQL sql = new SQL().SELECT(
				  "a.id,a.brand_code AS brandCode,"
				+ "a.brand_name AS brandName,a.accredit_level AS accreditLevel,"
				+ "a.accredit_start_time AS accreditStartTime,a.accredit_end_time AS accreditEndTime,"
				+ "a.company_id AS companyId,"
				+ "b.channel_name as channelName,a.user_id as userId")
				.FROM("ch_brand a").INNER_JOIN("ch_channel b on(a.channel_id=b.id)");
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getBrandName())) {sql.WHERE("brand_name = #{brandName}");}
			if(!Strings.isNullOrEmpty(entity.getBrandCode())) {sql.WHERE("brand_code = #{brandCode}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.WHERE("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			sql.WHERE("a.state ='1'");
		return sql.toString() + " order by a." + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(@Param("id")int id) {
		SQL sql = new SQL().SELECT(
				  "a.id,a.brand_code AS brandCode,"
				+ "a.brand_name AS brandName,a.accredit_level AS accreditLevel,"
				+ "a.accredit_start_time AS accreditStartTime,a.accredit_end_time AS accreditEndTime,"
				+ "a.company_id AS companyId,"
				+ "b.channel_name as channelName,a.user_id as userId")
				.FROM("ch_brand a").INNER_JOIN("ch_channel b on(a.channel_id=b.id)");
		sql.WHERE("a.id=#{id}");
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
			if(!Strings.isNullOrEmpty(entity.getAccreditLevel())) {sql.SET("accredit_level = #{accreditLevel}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditStartTime())) {sql.SET("accredit_start_time = #{accreditStartTime}");}
			if(!Strings.isNullOrEmpty(entity.getAccreditEndTime())) {sql.SET("accredit_end_time = #{accreditEndTime}");}
			if(!Objects.isNull(entity.getCompanyId())) {sql.SET("company_id = #{companyId}");}
			if(!Objects.isNull(entity.getChannelId())) {sql.SET("channel_id = #{channelId}");}
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
		SQL sql = new SQL().UPDATE("ch_brand");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 查询所有
	 * @return
	 */
	public String  selectChBrandAll(){
		SQL sql = new SQL().SELECT("id,brand_name as brandName,brand_code as brandCode,user_id as userId").FROM("ch_brand");
		sql.WHERE("state ='1'");
		return sql.toString();
	}
}
