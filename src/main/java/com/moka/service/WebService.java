package com.moka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.WebData;
import com.moka.model.ChCompany;

/**
* @author    created by lbq
* @date	     2018年10月10日 下午2:36:11
**/
@Service
public class WebService {
	@Autowired
	private WebData webData;
	
	public Object getCompany(){
		List<ChCompany> list= webData.getCompany();
		
		return list;
	}
}
