package com.moka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moka.dao.ChCompanyData;
import com.moka.model.ChCompany;

/**
* @author    created by lbq
* @date	     2018年9月27日 下午7:46:07
**/
@Service
public class ChCompanyService {

	@Autowired
	private ChCompanyData chCompanyData;
	
	@Transactional
	public int add(ChCompany chCompany){
		chCompanyData.insertChCompany(chCompany);
		
		return chCompany.getId();
	}
	
	
	
	
	public Object list(ChCompany chCompany){
		List<ChCompany> chCompanies= chCompanyData.selectChCompany(chCompany);
		
		return chCompanies;
	}
}
