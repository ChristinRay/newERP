package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChChannel;

/**
 * 
 * provider
 */
public class ChChannelProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChChannel(ChChannel entity) {
		SQL sql = new SQL().INSERT_INTO("ch_channel");
		sql.VALUES("channel_contact,channel_mobile,channel_name,createtime,id,state,updatetime,user_id", "#{channelContact},#{channelMobile},#{channelName},now(),#{id},'1',now(),#{userId}");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChChannelByCount(ChChannel entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_channel");
					if(!Strings.isNullOrEmpty(entity.getChannelAddress())) {sql.WHERE("channel_address = #{channelAddress}");}
			if(!Strings.isNullOrEmpty(entity.getChannelContact())) {sql.WHERE("channel_contact = #{channelContact}");}
			if(!Strings.isNullOrEmpty(entity.getChannelMobile())) {sql.WHERE("channel_mobile = #{channelMobile}");}
			if(!Strings.isNullOrEmpty(entity.getChannelName())) {sql.WHERE("channel_name = #{channelName}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}

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
	public String selectChChannelByLimt(ChChannel entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_channel");
					if(!Strings.isNullOrEmpty(entity.getChannelAddress())) {sql.WHERE("channel_address = #{channelAddress}");}
			if(!Strings.isNullOrEmpty(entity.getChannelContact())) {sql.WHERE("channel_contact = #{channelContact}");}
			if(!Strings.isNullOrEmpty(entity.getChannelMobile())) {sql.WHERE("channel_mobile = #{channelMobile}");}
			if(!Strings.isNullOrEmpty(entity.getChannelName())) {sql.WHERE("channel_name = #{channelName}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}

		return sql.toString() + " order by " + entity.getOrderBy() + " desc limit " + entity.getLimit() + "," + entity.getLimitLen();
	}
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	public String selectChChannel(ChChannel entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_channel");
					if(!Strings.isNullOrEmpty(entity.getChannelAddress())) {sql.WHERE("channel_address = #{channelAddress}");}
			if(!Strings.isNullOrEmpty(entity.getChannelContact())) {sql.WHERE("channel_contact = #{channelContact}");}
			if(!Strings.isNullOrEmpty(entity.getChannelMobile())) {sql.WHERE("channel_mobile = #{channelMobile}");}
			if(!Strings.isNullOrEmpty(entity.getChannelName())) {sql.WHERE("channel_name = #{channelName}");}
			if(!Strings.isNullOrEmpty(entity.getCreatetime())) {sql.WHERE("createtime = #{createtime}");}
			if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.WHERE("state = #{state}");}
			if(!Strings.isNullOrEmpty(entity.getUpdatetime())) {sql.WHERE("updatetime = #{updatetime}");}
			if(!Objects.isNull(entity.getUserId())) {sql.WHERE("user_id = #{userId}");}

		return sql.toString();
	}
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	public String selectOne(@Param("id")int id) {
		SQL sql = new SQL().SELECT("*").FROM("ch_channel");
		sql.WHERE("id=#{id}");
		return sql.toString();
	}
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	public String updateChChannelByNullChk(ChChannel entity) {
		SQL sql = new SQL().UPDATE("ch_channel");
					if(!Strings.isNullOrEmpty(entity.getChannelAddress())) {sql.SET("channel_address = #{channelAddress}");}
			if(!Strings.isNullOrEmpty(entity.getChannelContact())) {sql.SET("channel_contact = #{channelContact}");}
			if(!Strings.isNullOrEmpty(entity.getChannelMobile())) {sql.SET("channel_mobile = #{channelMobile}");}
			if(!Strings.isNullOrEmpty(entity.getChannelName())) {sql.SET("channel_name = #{channelName}");}
			if(!Strings.isNullOrEmpty(entity.getState())) {sql.SET("state = #{state}");}
			if(!Objects.isNull(entity.getUserId())) {sql.SET("user_id = #{userId}");}
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
		SQL sql = new SQL().UPDATE("ch_channel");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
