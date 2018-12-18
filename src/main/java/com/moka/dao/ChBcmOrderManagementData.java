package com.moka.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;
import com.moka.model.ChBcmOrderManagement;


@Mapper
public interface ChBcmOrderManagementData {

	/**
	 * 插入操作
	 * @param list
	 * @return
	 */
	@InsertProvider(type = ChBcmOrderManagementProvider.class, method = "insertList")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public void insertList(@Param("list") List<ChBcmOrderManagement> records);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChBcmOrderManagementProvider.class, method = "selectChBcmOrderByCount")
	public int selectChBcmOrderByCount(ChBcmOrderManagement chBcmOrderManagement);
	
	
	/**
	 * 按条件分页查询
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChBcmOrderManagementProvider.class, method = "selectChBcmOrderByLimt")
	public List<ChBcmOrderManagement> selectChBcmOrderByLimt(ChBcmOrderManagement chBcmOrderManagement);
	
}
