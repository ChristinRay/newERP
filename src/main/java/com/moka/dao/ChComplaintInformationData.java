package com.moka.dao;

import java.util.List;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.moka.model.ChComplaintInformation;

@Mapper
public interface ChComplaintInformationData {
	
	/**
	 * 插入操作
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = ChComplaintInformationProvider.class, method = "insertChComplaintInformation")
	@SelectKey(before=false,keyProperty="id",resultType=Integer.class,statementType=StatementType.STATEMENT,statement="SELECT LAST_INSERT_ID() AS id")
	public int insertChComplaintInformation(ChComplaintInformation entity);
	/**
	 * 按条件查询总记录数
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChComplaintInformationProvider.class, method = "selectChComplaintInformationByCount")
	public int selectChComplaintInformationByCount(ChComplaintInformation entity);
	/**
	 * 按条件分页查询
	 * @param entity
	 * @param orderBy
	 * @param limit
	 * @param limitLen
	 * @return
	 */
	@SelectProvider(type = ChComplaintInformationProvider.class, method = "selectChComplaintInformationByLimt")
	public List<ChComplaintInformation> selectChComplaintInformationByLimt(ChComplaintInformation entity);
	/**
	 * 按条件查询记录
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = ChComplaintInformationProvider.class, method = "selectChComplaintInformation")
	public List<ChComplaintInformation> selectChComplaintInformation(ChComplaintInformation entity);
	/**
	 * 根据主键id查询实体
	 * @param id
	 * @return
	 */
	@SelectProvider(type = ChComplaintInformationProvider.class, method = "selectOne")
	public ChComplaintInformation selectOne(@Param("id")int id);
	/**
	 * 更新实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChComplaintInformationProvider.class, method = "updateChComplaintInformation")
	public int updateChComplaintInformation(ChComplaintInformation entity);
	/**
	 * 更新实体，过滤空值
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChComplaintInformationProvider.class, method = "updateChComplaintInformationByNullChk")
	public int updateChComplaintInformationByNullChk(ChComplaintInformation entity);
	/**
	 * 物理删除实体
	 * @param id
	 * @return
	 */
	@DeleteProvider(type = ChComplaintInformationProvider.class, method = "deleteChComplaintInformation")
	public int deleteChComplaintInformation(@Param("id")int id);
	/**
	 * 逻辑删除实体
	 * @param entity
	 * @return
	 */
	@UpdateProvider(type = ChComplaintInformationProvider.class, method = "deleteByLogic")
	public int deleteByLogic(@Param("id")int id);
}
