package com.moka.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.moka.model.ChCompany;

/**
* @author    created by lbq
* @date	     2018年10月10日 下午2:40:46
**/
@Mapper
public interface WebData {
	@SelectProvider(type = WebProvider.class, method = "getCompany")
	public List<ChCompany> getCompany();
	
}
