package com.moka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.Enum.CodeEnum;
import com.moka.dao.WebRedisMapper;
import com.moka.dao.WebData;
import com.moka.model.ChCategory;
import com.moka.model.ChCompany;
import com.moka.model.SysUser;
import com.moka.result.Result;
import com.moka.service.ChCategoryService;
import com.moka.utils.ParamPreconditions;

/**
* @author    created by lbq
* @date	     2018年9月25日 下午7:46:56
**/
@RestController
@RequestMapping("/api/erp/v1/web")
public class WebController {
	@Autowired
	private WebRedisMapper webRedisMapper;
	@Autowired
	private WebData webData;
	@Autowired
	private ChCategoryService chCategoryService;
	
	
/*	@GetMapping("add")
	public  Object ceshi (String userName,String passWord){
		userMapper.addUser(userName, passWord);
		return Result.create("OK");
	}
	
	@GetMapping("get/one")
	public  Object ceshi (Integer id ){
		SysUser sysUser= userMapper.findById(id);
		return Result.create(sysUser);
	}*/
	/**
	 * 得到公司信息接口
	 * @return
	 */
	@GetMapping("get/company")
	public Object getCompany(){
		List<ChCompany> list= webData.getCompany();
		
		return Result.create(list);
	}
	/**
	 * 得到商品分类接口
	 * @param chCategory
	 * @return
	 */
	@PostMapping("get/category")
	public Object getCategory(@RequestBody ChCategory chCategory){
		ParamPreconditions.checkNotNull(chCategory.getFatherId(), CodeEnum.FAIL.getCode(), "分类id不能为空");
		List<ChCategory> list= chCategoryService.getCategory(chCategory);
		ParamPreconditions.checkNotNull(list, CodeEnum.FAIL.getCode(), "数据格式错误");
		return Result.create(list);
	}
	
}
