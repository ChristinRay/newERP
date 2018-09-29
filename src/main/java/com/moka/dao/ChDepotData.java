package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.annotations.Mapper;
import com.moka.model.ChDepot;

@Mapper
public interface ChDepotData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ChDepotProvider.class, method = "insertChDepot")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertChDepot(ChDepot entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChDepotProvider.class, method = "selectChDepotByCount")
	public int selectChDepotByCount(ChDepot entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ChDepotProvider.class, method = "selectChDepotByLimt")
	public List<ChDepot> selectChDepotByLimt(ChDepot entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChDepotProvider.class, method = "selectChDepot")
	public List<ChDepot> selectChDepot(ChDepot entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ChDepotProvider.class, method = "selectOne")
	public ChDepot selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChDepotProvider.class, method = "updateChDepot")
	public int updateChDepot(ChDepot entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChDepotProvider.class, method = "updateChDepotByNullChk")
	public int updateChDepotByNullChk(ChDepot entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = ChDepotProvider.class, method = "deleteChDepot")
	public int deleteChDepot(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChDepotProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
