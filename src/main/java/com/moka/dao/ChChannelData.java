package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.annotations.Mapper;
import com.moka.model.ChChannel;

@Mapper
public interface ChChannelData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ChChannelProvider.class, method = "insertChChannel")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertChChannel(ChChannel entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChChannelProvider.class, method = "selectChChannelByCount")
	public int selectChChannelByCount(ChChannel entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ChChannelProvider.class, method = "selectChChannelByLimt")
	public List<ChChannel> selectChChannelByLimt(ChChannel entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChChannelProvider.class, method = "selectChChannel")
	public List<ChChannel> selectChChannel(ChChannel entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ChChannelProvider.class, method = "selectOne")
	public ChChannel selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChChannelProvider.class, method = "updateChChannel")
	public int updateChChannel(ChChannel entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChChannelProvider.class, method = "updateChChannelByNullChk")
	public int updateChChannelByNullChk(ChChannel entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = ChChannelProvider.class, method = "deleteChChannel")
	public int deleteChChannel(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChChannelProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
