package com.moka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.dao.ChCompanyData;
import com.moka.model.ChCompany;
import com.moka.result.Result;
import com.moka.service.ChCompanyService;
import com.moka.service.CommonService;

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
		return Result.create("error","参数类型不匹配");
	}

		
}

















