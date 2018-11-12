package com.moka.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.ChSupply;

@Mapper
public interface ChSupplyData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ChSupplyProvider.class, method = "insertChSupply")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertChSupply(ChSupply entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChSupplyProvider.class, method = "selectChSupplyByCount")
	public int selectChSupplyByCount(ChSupply entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ChSupplyProvider.class, method = "selectChSupplyByLimt")
	public List<ChSupply> selectChSupplyByLimt(ChSupply entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ChSupplyProvider.class, method = "selectOne")
	public ChSupply selectOne(@Param("id") int id);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChSupplyProvider.class, method = "updateChSupplyByNullChk")
	public int updateChSupplyByNullChk(ChSupply entity);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChSupplyProvider.class, method = "deleteByLogic")
	public int deleteByLogic(@Param("id")int id);
	
	/**
	 * 禁用实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChSupplyProvider.class, method = "updateState")
	public int updateState(@Param("id")int id);
	/**
	 * 供应商下拉列表
	 * @return
	 */
	@SelectProvider(type = ChSupplyProvider.class, method = "getSupply")
	public ChSupply getSupply();
}
