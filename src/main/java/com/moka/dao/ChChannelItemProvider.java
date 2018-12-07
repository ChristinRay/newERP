package com.moka.dao;

import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.Strings;
import java.util.Objects;
import com.moka.model.ChChannelItem;

/**
 * 渠道表
 * provider
 */
public class ChChannelItemProvider {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	public String insertChChannelItem(ChChannelItem entity) {
		SQL sql = new SQL().INSERT_INTO("ch_channel_item");
		sql.VALUES("product_id,channel_id,channel_product_name,commission,integral,staging,user_id,state,createtime,updatetime", "#{productId},#{channelId},#{channelProductName},#{commission},#{integral},#{staging},#{userId},#{state},now(),now()");
		return sql.toString();
	}
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	public String selectChChannelItemByCount(ChChannelItem entity) {
		SQL sql = new SQL().SELECT("count(*)").FROM("ch_channel_item");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getChannelId())) {sql.WHERE("channel_id = #{channelId}");}
			if(!Strings.isNullOrEmpty(entity.getChannelProductName())) {sql.WHERE("channel_product_name = #{channelProductName}");}
			if(!Strings.isNullOrEmpty(entity.getCommission())) {sql.WHERE("commission = #{commission}");}
			if(!Strings.isNullOrEmpty(entity.getIntegral())) {sql.WHERE("integral = #{integral}");}
			if(!Strings.isNullOrEmpty(entity.getStaging())) {sql.WHERE("staging = #{staging}");}
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
	public String selectChChannelItemByLimt(ChChannelItem entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_channel_item");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getChannelId())) {sql.WHERE("channel_id = #{channelId}");}
			if(!Strings.isNullOrEmpty(entity.getChannelProductName())) {sql.WHERE("channel_product_name = #{channelProductName}");}
			if(!Strings.isNullOrEmpty(entity.getCommission())) {sql.WHERE("commission = #{commission}");}
			if(!Strings.isNullOrEmpty(entity.getIntegral())) {sql.WHERE("integral = #{integral}");}
			if(!Strings.isNullOrEmpty(entity.getStaging())) {sql.WHERE("staging = #{staging}");}
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
	public String selectChChannelItem(ChChannelItem entity) {
		SQL sql = new SQL().SELECT("*").FROM("ch_channel_item");
					if(!Objects.isNull(entity.getId())) {sql.WHERE("id = #{id}");}
			if(!Objects.isNull(entity.getProductId())) {sql.WHERE("product_id = #{productId}");}
			if(!Objects.isNull(entity.getChannelId())) {sql.WHERE("channel_id = #{channelId}");}
			if(!Strings.isNullOrEmpty(entity.getChannelProductName())) {sql.WHERE("channel_product_name = #{channelProductName}");}
			if(!Strings.isNullOrEmpty(entity.getCommission())) {sql.WHERE("commission = #{commission}");}
			if(!Strings.isNullOrEmpty(entity.getIntegral())) {sql.WHERE("integral = #{integral}");}
			if(!Strings.isNullOrEmpty(entity.getStaging())) {sql.WHERE("staging = #{staging}");}
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
	public String selectOne(int id) {
		SQL sql = new SQL().SELECT("*").FROM("ch_channel_item");
		sql.WHERE("id="+id);
		return sql.toString();
	}
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	public String updateChChannelItem(ChChannelItem entity) {
		SQL sql = new SQL().UPDATE("ch_channel_item");
				sql.SET("product_id = #{productId}");
		sql.SET("channel_id = #{channelId}");
		sql.SET("channel_product_name = #{channelProductName}");
		sql.SET("commission = #{commission}");
		sql.SET("integral = #{integral}");
		sql.SET("staging = #{staging}");
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
	public String updateChChannelItemByNullChk(ChChannelItem entity) {
		SQL sql = new SQL().UPDATE("ch_channel_item");
					if(!Objects.isNull(entity.getProductId())) {sql.SET("product_id = #{productId}");}
			if(!Objects.isNull(entity.getChannelId())) {sql.SET("channel_id = #{channelId}");}
			if(!Strings.isNullOrEmpty(entity.getChannelProductName())) {sql.SET("channel_product_name = #{channelProductName}");}
			if(!Strings.isNullOrEmpty(entity.getCommission())) {sql.SET("commission = #{commission}");}
			if(!Strings.isNullOrEmpty(entity.getIntegral())) {sql.SET("integral = #{integral}");}
			if(!Strings.isNullOrEmpty(entity.getStaging())) {sql.SET("staging = #{staging}");}
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
	public String deleteChChannelItem(int id) {
		SQL sql = new SQL().DELETE_FROM("ch_channel_item");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	public String deleteByLogic(int id) {
		SQL sql = new SQL().UPDATE("ch_channel_item");
		sql.SET("state=2");
		sql.WHERE("id = #{id}");
		return sql.toString();
	}
}
