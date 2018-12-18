package com.moka.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.moka.dao.ChBcmOrderManagementData;
import com.moka.model.ChBcmOrderManagement;
import com.moka.result.Result;
import com.moka.service.ChBcmOrderManagementService;
import com.moka.service.CommonService;
/**
* @author    created by hmm
* @date	     2018年12月10日 下午15:31:00
**/

@RestController
@RequestMapping("/api/erp/v1/bcm/orderManagement")
public class ChBcmOrderManagementController{
	
	private Logger log =LoggerFactory.getLogger(ChBcmOrderManagementController.class);
	
	@Autowired
	private ChBcmOrderManagementService  service;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ChBcmOrderManagementData chBcmOrderManagementData;
	/**
	 * 订单导入
	 * @return
	 */
	@GetMapping("upload")
	public Result<?> add(@RequestParam MultipartFile file, @RequestParam String userId){
		//MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String,Object> reqMap = new HashMap<String,Object>();
		//reqMap.put("userId", multipartRequest.getParameter("userId"));
		reqMap.put("userId",userId);
		if(null==file) {
			return Result.create("null", "导入订单列表为空");
		}
		String fileName=file.getOriginalFilename();
		log.info("upload fileName:"+fileName);
		long size=file.getSize();
		if(null==fileName||("").equals(fileName)||0==size) {
			return Result.create("null", "导入订单列表为空");
		}
		try {
			service.add(fileName,file,reqMap);
		}catch(Exception e) {
			log.error("CHBcmOrderManagementController export excel",e);
			return Result.create("unknownError","导出异常");
		}		
     return Result.create("0", "导入订单报表成功");
	}
	
	
	/**
	 * 订单查询
	 * @return
	 */
	@PostMapping("query")
	public Result<?> queryOrderManagement(@RequestBody ChBcmOrderManagement chBcmOrderManagement ){
		if(commonService.paginationSupport(chBcmOrderManagement.getPageIndex()==null?1:chBcmOrderManagement.getPageIndex(), 
				chBcmOrderManagement.getPageSize()==null?10:chBcmOrderManagement.getPageSize())) {
			int count = chBcmOrderManagementData.selectChBcmOrderByCount(chBcmOrderManagement);
			int[] page = commonService.getLimit(chBcmOrderManagement.getPageIndex()==null?1:chBcmOrderManagement.getPageIndex(), 
					chBcmOrderManagement.getPageSize()==null?10:chBcmOrderManagement.getPageSize());
			chBcmOrderManagement.setLimit(page[0]);
			chBcmOrderManagement.setLimitLen(page[1]);
			chBcmOrderManagement.setOrderBy("id");
			List<ChBcmOrderManagement> result = chBcmOrderManagementData.selectChBcmOrderByLimt(chBcmOrderManagement);
			return Result.createPage(result,chBcmOrderManagement.getPageIndex()==null?1:chBcmOrderManagement.getPageIndex(),
					chBcmOrderManagement.getPageSize()==null?10:chBcmOrderManagement.getPageSize(),(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
}
