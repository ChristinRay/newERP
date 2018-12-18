package com.moka.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.Enum.CodeEnum;
import com.moka.Enum.CompanyStatic;
import com.moka.dao.ChBrandData;
import com.moka.model.ChBrand;
import com.moka.result.Result;
import com.moka.service.ChBrandService;
import com.moka.service.ChCompanyService;
import com.moka.service.CommonService;
import com.moka.utils.ParamPreconditions;

/**
* @author    created by lbq
* @date	     2018年9月17日 下午4:37:43
**/
@RestController
@RequestMapping("/api/erp/v1/brand")
public class ChBrandController {
	
	@Autowired
	private ChBrandService chBrandService;
	@Autowired
	private ChBrandData chBrandData;
	@Autowired
	private CommonService commonService;
	@Autowired
	private ChCompanyService chCompanyService;
	
	
	/**
	 * 品牌查询接口(缓存)
	 * @param entity
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("list")
	public  Result<?> list () {
		return Result.create(chBrandData.selectChBrandAll()); 
	}
	/**
	 * 添加品牌接口
	 * @param chBrand
	 * @return
	 */
	@PostMapping("add")
	public  Result<?> list (@RequestBody ChBrand chBrand) {
		return chBrandService.insertChBrand(chBrand);
	}
	/**
	 * 品牌列表接口
	 * @param chChannel
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("list/all")
	public Result<?> listAll (@RequestBody ChBrand chBrand) throws UnsupportedEncodingException{
		if(commonService.paginationSupport(chBrand.getPageIndex(), chBrand.getPageSize())) {
			int count = chBrandData.selectChBrandByCount(chBrand);
			int[] page = commonService.getLimit(chBrand.getPageIndex(), chBrand.getPageSize());
			chBrand.setLimit(page[0]);
			chBrand.setLimitLen(page[1]);
			chBrand.setOrderBy("updatetime");
			List<ChBrand> result = chBrandData.selectChBrandByLimt(chBrand);
			for (ChBrand chBrand2 : result) {
				String companyName=chCompanyService.findNameById(chBrand2.getCompanyId());
				chBrand2.setCompanyName(companyName);
			}
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
	/**
	 * 修改一个品牌信息
	 * @param chChannel
	 * @return
	 */
	@PostMapping("update")
	public Result<?> update (@RequestBody ChBrand chBrand){
		int a = chBrandData.updateChBrandByNullChk(chBrand);
		if(a==1){
			return Result.create("OK", "修改成功");
		}
		return Result.create("ERROR", "数据错误");
	}
	/**
	 * 得到一个品牌信息
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("get/one")
	public Result<?> get (Integer id) throws UnsupportedEncodingException{
		ParamPreconditions.checkNotNull(id, CodeEnum.FAIL.getCode(), "id不能为空");
		ChBrand chBrand = chBrandData.selectOne(id);
		chBrand.setCompanyName(chCompanyService.findNameById(chBrand.getCompanyId())); 
		return Result.create(chBrand);
	}
	
	/**
	 * 根据id 逻辑删除
	 * @param id
	 * @return
	 */
	@GetMapping("delete")
	public Result<?> delete(Integer id){
		int a= chBrandData.deleteByLogic(id);
		if(a==1){
			return Result.create("OK","删除成功");
		}
		return Result.create("ERROR","删除失败");
	}
	
	/**
	 * 得到品牌信息
	 * @return
	 */
	@GetMapping("info")
	public Result<?> info(){
		
		return Result.create(CompanyStatic.company());
	}
}











