package com.moka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.moka.Enum.CodeEnum;
import com.moka.dao.ChDepotData;
import com.moka.model.ChDepot;
import com.moka.result.Result;
import com.moka.utils.ParamPreconditions;

/**
* @author    created by lbq
* @date	     2018年9月29日 下午5:37:42
**/
@Service
public class ChDepotService {
	@Autowired
	private ChDepotData chDepotData;
	
	
	public Result<?>  add(ChDepot chDepot){
		ChDepot depot= chDepotData.findCodeByDepot(chDepot.getDepotCode());
		if(depot!=null){
			return Result.create(CodeEnum.FAIL.getCode(), "仓库编码不能重复");
		}
		
		int a= chDepotData.insertChDepot(chDepot);
		if(a==1){
			return Result.create(a);
		}
		return Result.create(CodeEnum.FAIL.getCode(), "dao层异常");
	}
	
	public int update (ChDepot chDepot){
		int a= chDepotData.updateChDepotByNullChk(chDepot);
		return a;
	}
}
















