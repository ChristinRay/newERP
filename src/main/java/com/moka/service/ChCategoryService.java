package com.moka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.ChCategoryData;
import com.moka.model.ChCategory;

/**
* @author    created by lbq
* @date	     2018年10月15日 下午4:50:06
**/
@Service
public class ChCategoryService {
	@Autowired
	private ChCategoryData chCategoryData;
	
	
	public List<ChCategory> getCategory(ChCategory chCategory){
		List<ChCategory> list = chCategoryData.selectChCategory(chCategory);
		
		return list;
	}
}
