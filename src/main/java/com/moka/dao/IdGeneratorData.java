package com.moka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IdGeneratorData {
	
	@Select("SELECT nextid(#{tab_name}) from dual;")
	public Long nextid(@Param("tab_name") String tab_name);
}
