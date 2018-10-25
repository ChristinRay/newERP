package com.moka.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.StatementType;

import com.moka.dto.ChProductItemDto;
import com.moka.dto.ChProductItemSupplyDto;
import com.moka.model.ChProductItem;
import com.moka.req.ChProductItemSupplyReq;

@Mapper
public interface ChProductItemData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ChProductItemProvider.class, method = "insertChProductItem")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertChProductItem(ChProductItem entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChProductItemProvider.class, method = "selectChProductItemByCount")
	public int selectChProductItemByCount(ChProductItem entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ChProductItemProvider.class, method = "selectChProductItemByLimt")
	public List<ChProductItemDto> selectChProductItemByLimt(ChProductItem entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChProductItemProvider.class, method = "selectChProductItem")
	public List<ChProductItem> selectChProductItem(ChProductItem entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ChProductItemProvider.class, method = "selectOne")
	public ChProductItemDto selectOne(@Param("id")int id);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChProductItemProvider.class, method = "updateChProductItemByNullChk")
	public int updateChProductItemByNullChk(ChProductItem entity);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChProductItemProvider.class, method = "deleteByLogic")
	public int deleteByLogic(@Param("id")int id);
	/**
	 * 查询已授权品牌信息和供应商下商品基本信息
	 * @return
	 */
	@SelectProvider(type = ChProductItemProvider.class, method = "findSupplyByBrand")
	public List<ChProductItemSupplyDto> findSupplyByBrand(ChProductItemSupplyReq req);
}
