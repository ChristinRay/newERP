package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChChannel;

/**
 * 渠道表
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
		sql.VALUES("product_id,channel_name,channel_address,commission,integral,user_id,state,createtime,updatetime", "#{productId},#{channelName},#{channelAddress},#{commission},#{integral},#{userId},#{state},now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChChannelByCount(ChChannel entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_channel");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Strings.isNullOrEmpty(entity.getChannelName())) {sql.WHERE("channel_name = #{channelName}");}
			if(!Strings.isNullOrEmpty(entity.getChannelAddress())) {sql.WHERE("channel_address = #{channelAddress}");}
			if(!Strings.isNullOrEmpty(entity.getCommission())) {sql.WHERE("commission = #{commission}");}
			if(!Strings.isNullOrEmpty(entity.getIntegral())) {sql.WHERE("integral = #{integral}");}
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
	public String selectChChannelByLimt(ChChannel entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_channel");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Strings.isNullOrEmpty(entity.getChannelName())) {sql.WHERE("channel_name = #{channelName}");}
			if(!Strings.isNullOrEmpty(entity.getChannelAddress())) {sql.WHERE("channel_address = #{channelAddress}");}
			if(!Strings.isNullOrEmpty(entity.getCommission())) {sql.WHERE("commission = #{commission}");}
			if(!Strings.isNullOrEmpty(entity.getIntegral())) {sql.WHERE("integral = #{integral}");}
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
	public String selectChChannel(ChChannel entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_channel");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Strings.isNullOrEmpty(entity.getChannelName())) {sql.WHERE("channel_name = #{channelName}");}
			if(!Strings.isNullOrEmpty(entity.getChannelAddress())) {sql.WHERE("channel_address = #{channelAddress}");}
			if(!Strings.isNullOrEmpty(entity.getCommission())) {sql.WHERE("commission = #{commission}");}
			if(!Strings.isNullOrEmpty(entity.getIntegral())) {sql.WHERE("integral = #{integral}");}
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
		SQL sql = new SQL().SELECT("*").FROM("ch_channel");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateChChannel(ChChannel entity) {
		SQL sql = new SQL().UPDATE("ch_channel");
				sql.SET("product_id = #{productId}");
		sql.SET("channel_name = #{channelName}");
		sql.SET("channel_address = #{channelAddress}");
		sql.SET("commission = #{commission}");
		sql.SET("integral = #{integral}");
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
	public String updateChChannelByNullChk(ChChannel entity) {
		SQL sql = new SQL().UPDATE("ch_channel");
					if(!Objects.isNull(entity.getProductId())) {sql.SET("product_id = #{productId}");}
			if(!Strings.isNullOrEmpty(entity.getChannelName())) {sql.SET("channel_name = #{channelName}");}
			if(!Strings.isNullOrEmpty(entity.getChannelAddress())) {sql.SET("channel_address = #{channelAddress}");}
			if(!Strings.isNullOrEmpty(entity.getCommission())) {sql.SET("commission = #{commission}");}
			if(!Strings.isNullOrEmpty(entity.getIntegral())) {sql.SET("integral = #{integral}");}
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
	public String deleteChChannel(long id) {
		SQL sql = new SQL().DELETE_FROM("ch_channel");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(long id) {
		SQL sql = new SQL().UPDATE("ch_channel");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
