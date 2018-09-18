package com.moka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moka.dao.ChBrandData;
import com.moka.model.ChBrand;
import com.moka.result.ResultFul;

/**
* @author    created by lbq
* @date	     2018年9月17日 下午4:47:41
**/
@Service
public class ChBrandService {

	@Autowired
	private ChBrandData chBrandData;
	
	@Transactional
	public ResultFul add(ChBrand entity){
		
		int a = chBrandData.insertChBrand(entity);
		if (a==1){
			return ResultFul.create("OK","品牌添加成功");
		}
		
		return ResultFul.create("ERROR", "品牌添加失败");
	}
}





