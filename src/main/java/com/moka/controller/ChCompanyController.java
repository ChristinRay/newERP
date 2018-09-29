package com.moka.controller;

import java.util.List;

import org.hibernate.validator.internal.metadata.provider.ProgrammaticMetaDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChCompanyData;
import com.moka.model.ChCompany;
import com.moka.result.Result;
import com.moka.service.ChCompanyService;
import com.moka.service.CommonService;
import com.moka.utils.ParamPreconditions;

/**
* @author    created by lbq
* @date	     2018年9月27日 下午7:44:12
**/
@RestController
@RequestMapping("/api/erp/v1/company")
public class ChCompanyController {
	
	@Autowired
	private ChCompanyService chCompanyService;
	
	@Autowired
	private CommonService commonService;
	@Autowired
	private ChCompanyData chCompanyData;
	/**
	 * 添加公司信息
	 * @param chCompany
	 * @return
	 */
	@PostMapping("add")
	public Result<?> add(@RequestBody ChCompany chCompany){
		chCompany.check();
		chCompanyService.add(chCompany);
		
		return Result.create(chCompany.getId());
	}
	/**
	 * 公司信息列表查询
	 * @param company
	 * @return
	 */
	@PostMapping("list")
	public Result<?> list (@RequestBody ChCompany company){
		if(commonService.paginationSupport(company.getPageIndex(), company.getPageSize())) {
			int count = chCompanyData.selectChCompanyByCount(company);
			int[] page = commonService.getLimit(company.getPageIndex(), company.getPageSize());
			company.setLimit(page[0]);
			company.setLimitLen(page[1]);
			company.setOrderBy("id");
			List<ChCompany> result = chCompanyData.selectChCompany(company);
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
	/**
	 * 修改公司信息
	 * @param ChCompany
	 * @return
	 */
	@PostMapping("update")
	public Result<?> update(@RequestBody ChCompany ChCompany){
		chCompanyData.updateChCompany(ChCompany);
		return Result.create("OK","修改成功");
	}
	/**
	 * 根据id得到一个公司
	 * @param id
	 * @return
	 */
	@GetMapping("get/one")
	public Result<?> getOne(Integer id){
		ParamPreconditions.checkNotNull(id, CodeEnum.FAIL.getCode(), "id不能为空");
		ChCompany chCompany= chCompanyData.selectOne(id);
		return Result.create(chCompany);
	}
	
	
	/**
	 * 根据id 逻辑删除一个公司信息
	 * @param id
	 * @return
	 */
	@GetMapping("delete")
	public Result<?> delete(Integer id){
		int a= chCompanyData.deleteByLogic(id);
		return Result.create(a);
	}
}






	










