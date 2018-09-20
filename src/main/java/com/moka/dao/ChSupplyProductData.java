package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.mapping.StatementType;

import com.moka.model.ChSupplyProduct;
@Mapper
public interface ChSupplyProductData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ChSupplyProductProvider.class, method = "insertChSupplyProduct")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertChSupplyProduct(ChSupplyProduct entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChSupplyProductProvider.class, method = "selectChSupplyProductByCount")
	public int selectChSupplyProductByCount(ChSupplyProduct entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ChSupplyProductProvider.class, method = "selectChSupplyProductByLimt")
	public List<ChSupplyProduct> selectChSupplyProductByLimt(ChSupplyProduct entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChSupplyProductProvider.class, method = "selectChSupplyProduct")
	public List<ChSupplyProduct> selectChSupplyProduct(ChSupplyProduct entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ChSupplyProductProvider.class, method = "selectOne")
	public ChSupplyProduct selectOne(int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChSupplyProductProvider.class, method = "updateChSupplyProduct")
	public int updateChSupplyProduct(ChSupplyProduct entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChSupplyProductProvider.class, method = "updateChSupplyProductByNullChk")
	public int updateChSupplyProductByNullChk(ChSupplyProduct entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = ChSupplyProductProvider.class, method = "deleteChSupplyProduct")
	public int deleteChSupplyProduct(int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChSupplyProductProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
