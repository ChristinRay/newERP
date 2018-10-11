package com.moka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moka.dao.ChDepotData;
import com.moka.model.ChDepot;

/**
* @author    created by lbq
* @date	     2018年9月29日 下午5:37:42
**/
@Service
public class ChDepotService {
	@Autowired
	private ChDepotData chDepotData;
	
	
	public int  add(ChDepot chDepot){
		int a= chDepotData.insertChDepot(chDepot);
		
		return a;
	}
	
	public int update (ChDepot chDepot){
		int a= chDepotData.updateChDepotByNullChk(chDepot);
		return a;
	}
}
















