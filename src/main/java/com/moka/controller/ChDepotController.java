package com.moka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChDepotData;
import com.moka.model.ChDepot;
import com.moka.result.Result;
import com.moka.service.ChDepotService;
import com.moka.service.CommonService;
import com.moka.utils.ParamPreconditions;

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
		chDepot.check();
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
			List<ChDepot> result = chDepotData.selectChDepotByLimt(chDepot);
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
	/**
	 * 修改仓库信息
	 * @param chDepot
	 * @return
	 */
	@PostMapping
	public Result<?> update(@RequestBody ChDepot chDepot){
		chDepotService.update(chDepot);
		return Result.create("OK","修改成功");
	}
	/**
	 * 得到一条数据
	 * @param id
	 * @return
	 */
	@GetMapping("get/one")
	public Result<?> getOne(Integer id){
		ParamPreconditions.checkNotNull(id, CodeEnum.FAIL.getCode(), "id不能为空");
		ChDepot chDepot= chDepotData.selectOne(id);
		
		return Result.create(chDepot);
	}
	
	/**
	 * 根据id 逻辑删除一个仓库信息
	 * @param id
	 * @return
	 */
	@GetMapping("delete")
	public Result<?> delete(Integer id){
		int a= chDepotData.deleteByLogic(id);
		return Result.create(a);
	}
}
















