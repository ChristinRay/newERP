package com.moka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.dao.ChDepotData;
import com.moka.model.ChCompany;
import com.moka.model.ChDepot;
import com.moka.result.Result;
import com.moka.service.ChDepotService;
import com.moka.service.CommonService;

/**
* @author    created by lbq
* @date	     2018年9月29日 下午5:35:34
**/
@RestController
@RequestMapping("/api/erp/v1/depot/")
public class ChDepotController {
	@Autowired
	private ChDepotService chDepotService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ChDepotData chDepotData;
	
	/**
	 * 仓库添加接口
	 * @param chDepot
	 * @return
	 */
	@PostMapping("add")
	public Result<?> add(@RequestBody ChDepot chDepot){
		chDepotService.add(chDepot);
		return Result.create(chDepot.getId());
	}
	/**
	 * 仓库列表查询接口
	 * @param chDepot
	 * @return
	 */
	@PostMapping("list")
	public Result<?> list(@RequestBody ChDepot chDepot){
		if(commonService.paginationSupport(chDepot.getPageIndex(), chDepot.getPageSize())) {
			int count = chDepotData.selectChDepotByCount(chDepot);
			int[] page = commonService.getLimit(chDepot.getPageIndex(), chDepot.getPageSize());
			chDepot.setLimit(page[0]);
			chDepot.setLimitLen(page[1]);
			chDepot.setOrderBy("id");
			List<ChDepot> result = chDepotData.selectChDepot(chDepot);
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
		
	
}
