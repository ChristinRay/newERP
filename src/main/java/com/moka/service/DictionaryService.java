package com.moka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.TDataDictData;
import com.moka.model.TDataDict;

/**
* @author    created by lbq
* @date	     2018年10月24日 上午10:46:38
**/
@Service
public class DictionaryService {
	@Autowired
	private TDataDictData tDataDictData;
	
	public TDataDict getValueById(Integer id){
		TDataDict dict= tDataDictData.getValueById(id);
		
		return dict;
	}
}
