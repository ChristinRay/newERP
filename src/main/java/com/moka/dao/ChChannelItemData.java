package com.moka.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.StatementType;

import com.moka.dto.ChannelItemDto;
import com.moka.model.ChChannelItem;
import com.moka.req.ChannelItemReq;

@Mapper
public interface ChChannelItemData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ChChannelItemProvider.class, method = "insertChChannelItem")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertChChannelItem(ChChannelItem entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChChannelItemProvider.class, method = "selectChChannelItemByCount")
	public int selectChChannelItemByCount(ChannelItemReq entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ChChannelItemProvider.class, method = "selectChChannelItemByLimt")
	public List<ChannelItemDto> selectChChannelItemByLimt(ChannelItemReq entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChChannelItemProvider.class, method = "selectChChannelItem")
	public List<ChChannelItem> selectChChannelItem(ChChannelItem entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ChChannelItemProvider.class, method = "selectOne")
	public ChChannelItem selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChChannelItemProvider.class, method = "updateChChannelItem")
	public int updateChChannelItem(ChChannelItem entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChChannelItemProvider.class, method = "updateChChannelItemByNullChk")
	public int updateChChannelItemByNullChk(ChChannelItem entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = ChChannelItemProvider.class, method = "deleteChChannelItem")
	public int deleteChChannelItem(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChChannelItemProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
