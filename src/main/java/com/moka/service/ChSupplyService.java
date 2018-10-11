package com.moka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moka.dao.ChSupplyData;
import com.moka.model.ChSupply;

/**
* @author    created by lbq
* @date	     2018年10月10日 上午11:44:50
**/
@Service
public class ChSupplyService {
	@Autowired
	private ChSupplyData chSupplyData;
	
	@Transactional
	public int add(ChSupply chSupply){
		chSupply.setState("1");
		chSupply.setSupplyCertificate("1");
		int a = chSupplyData.insertChSupply(chSupply);
		return a ;
	}
	
	public int update(ChSupply chSupply){
		return chSupplyData.updateChSupplyByNullChk(chSupply);
	}
	
	public ChSupply getOne(Integer id){
		ChSupply chSupply = chSupplyData.selectOne(id);
		return chSupply;
	}
	
		
}