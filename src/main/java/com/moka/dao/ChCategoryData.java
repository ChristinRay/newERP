package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.annotations.Mapper;
import com.moka.model.ChCategory;

@Mapper
public interface ChCategoryData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ChCategoryProvider.class, method = "insertChCategory")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertChCategory(ChCategory entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChCategoryProvider.class, method = "selectChCategoryByCount")
	public int selectChCategoryByCount(ChCategory entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ChCategoryProvider.class, method = "selectChCategoryByLimt")
	public List<ChCategory> selectChCategoryByLimt(ChCategory entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChCategoryProvider.class, method = "selectChCategory")
	public List<ChCategory> selectChCategory(ChCategory entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ChCategoryProvider.class, method = "selectOne")
	public ChCategory selectOne(int id);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChCategoryProvider.class, method = "updateChCategoryByNullChk")
	public int updateChCategoryByNullChk(ChCategory entity);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChCategoryProvider.class, method = "deleteByLogic")
	public int deleteByLogic(int id);
}
