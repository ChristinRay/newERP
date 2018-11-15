package com.moka.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.moka.Enum.CodeEnum;
import com.moka.dao.ChComplaintInformationData;
import com.moka.model.ChComplaintInformation;
import com.moka.req.ChComplaintInformationReq;
import com.moka.result.Result;
import com.moka.service.ChComplaintInformationService;
import com.moka.service.CommonService;
import com.moka.utils.ParamPreconditions;
import com.moka.utils.StringDateUtil;

import lombok.extern.slf4j.Slf4j;

/**
* @author    created by GENG CHANG WEI
* @date	     2018年11月09日 10:19
**/
@RestController
@RequestMapping("/api/erp/v1/chcomforma")
@Slf4j
public class ChComplaintInformationController {
	
	@Autowired
	private CommonService commonService;
	@Autowired
	ChComplaintInformationData chComplaintInformationData;
	@Autowired
	ChComplaintInformationService chComplaintInformationService;
	
	/**
	 * 诉单添加接口
	 * @param chBrand
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@PostMapping("add")
	public  Result<?> add (@RequestBody ChComplaintInformation chBrand) throws IllegalAccessException, InvocationTargetException {
		log.info("诉单添加参数：---"+JSON.toJSONString(chBrand));
		chBrand.check();
		return chComplaintInformationService.add(chBrand);
	}
	
	/**
	 *诉单信息列表接口
	 * @param chComForma
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("list/Complaint")
	public Result<?> Complaint (@RequestBody ChComplaintInformation chComForma) throws UnsupportedEncodingException{
		log.info("诉单信息列表接口参数：----"+JSON.toJSONString(chComForma));
		if(commonService.paginationSupport(chComForma.getPageIndex(), chComForma.getPageSize())) {
			String startdf = null;
			if(StringUtils.isNotBlank(chComForma.getStarDate())){
				String startda = chComForma.getStarDate().trim();
				if(startda.length()>10){
					startdf = startda.substring(0, 10)+" 00:00:00";
				}else{
					startdf = startda+" 00:00:00";
				}
			}
			String enddf = null;
			if(StringUtils.isNotBlank(chComForma.getEndDate())){
				String enddate = chComForma.getEndDate().trim();
				if(enddate.length()>10){
					 enddf = enddate.substring(0, 10)+" 23:59:59";
				}else{
					enddf = enddate+" 23:59:59";
				}	
			}
			
			chComForma.setStarDate(startdf);
			chComForma.setEndDate(enddf);
			chComForma.setSelectFlg("2");
			int count = chComplaintInformationData.selectChComplaintInformationByCount(chComForma);
			int[] page = commonService.getLimit(chComForma.getPageIndex(), chComForma.getPageSize());
			chComForma.setLimit(page[0]);
			chComForma.setLimitLen(page[1]);
			chComForma.setOrderBy("updatetime");
			List<ChComplaintInformation> result = chComplaintInformationData.selectChComplaintInformationByLimt(chComForma);
			
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
	
	/**
	 * 修改一个诉单信息
	 * @param chComForma
	 * @return
	 */
	@PostMapping("update")
	public Result<?> update (@RequestBody ChComplaintInformation chComForma){
		log.info("----修改一个诉单信息参数："+JSON.toJSONString(chComForma));
		int a = chComplaintInformationData.updateChComplaintInformationByNullChk(chComForma);
		if(a==1){
			return Result.create("OK", "修改成功");
		}
		return Result.create("ERROR", "数据错误");
	}
	/**
	 * 得到一个诉单信息
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@GetMapping("get/one")
	public Result<?> get (Integer id) throws UnsupportedEncodingException{
		log.info("----诉单详情参数id:"+id);
		ParamPreconditions.checkNotNull(id, CodeEnum.FAIL.getCode(), "id不能为空");
		ChComplaintInformation chComForma = chComplaintInformationData.selectOne(id);
		return Result.create(chComForma);
	}
	
	/**
	 * 根据id 逻辑删除
	 * @param id
	 * @return
	 */
	@GetMapping("delete")
	public Result<?> delete(Integer id){
		log.info("----根据id 逻辑删除,参数id:"+id);
		int a= chComplaintInformationData.deleteByLogic(id);
		if(a==1){
			return Result.create("OK","删除成功");
		}
		return Result.create("ERROR","删除失败");
	}
	
	/**
	 * 邮政扣款列表接口
	 * @param chComForma
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@PostMapping("list/postalDeductions")
	public Result<?> listAll (@RequestBody ChComplaintInformation chComForma) throws UnsupportedEncodingException{
		
		log.info("----邮政扣款列表接口参数："+JSON.toJSONString(chComForma));
		if(commonService.paginationSupport(chComForma.getPageIndex(), chComForma.getPageSize())) {
			String startdf = null;
			if(StringUtils.isNotBlank(chComForma.getStarDate())){
				String startda = chComForma.getStarDate().trim();//2018-10 前段只选到月份
				String month = startda.substring(startda.indexOf("-")+1);
				int days = countDaysInMonth(month);//获得某个月的天数
				String startdate = startda+"-01";
				String endDate = StringDateUtil.dateToString(StringDateUtil.addDates(StringDateUtil.stringToDate(startdate, 3), days), 3);
				if(startdate.length()>10){
					startdf = startdate.substring(0, 10)+" 00:00:00";
				}else{
					startdf = startdate+" 00:00:00";
				}
				String enddf = null;
				if(endDate.length()>10){
					enddf = endDate.substring(0, 10)+" 23:59:59";
				}else{
					enddf = endDate+" 23:59:59";
				}
				chComForma.setStarDate(startdf);
				chComForma.setEndDate(enddf);
			}
			chComForma.setSelectFlg("1");
			int count = chComplaintInformationData.selectChComplaintInformationByCount(chComForma);
			int[] page = commonService.getLimit(chComForma.getPageIndex(), chComForma.getPageSize());
			chComForma.setLimit(page[0]);
			chComForma.setLimitLen(page[1]);
			chComForma.setOrderBy("updatetime");
			List<ChComplaintInformation> result = chComplaintInformationData.selectChComplaintInformationByLimt(chComForma);
			
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
	

	
	/**
	 * 诉单 情况说明 读取缓存
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GetMapping("presentationList")
	public Result<?> presentationList() {
		return chComplaintInformationService.presentationList();
	}
	/**
	 * 诉单 原因 读取缓存
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GetMapping("reasonList")
	public Result<?> reasonList() throws UnsupportedEncodingException{
		return chComplaintInformationService.reasonList();
	}
	/**
	 * 诉单 解决方案 读取缓存
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@GetMapping("solutionList")
	public Result<?> solutionList() throws UnsupportedEncodingException{
		return chComplaintInformationService.solutionList();
	}
	
	/*public static void main(String[] args) {
		System.out.println(countDaysInMonth("12"));
		String s = "2018-10";
		System.out.println(s.substring(s.indexOf("-") + 1));
		String a = "2018-10-12";
		System.out.println(a.substring(a.indexOf("-") + 1, a.lastIndexOf("-")));
		System.out.println(StringDateUtil.stringToDate("2018-10-08", 3));
		System.out.println(StringDateUtil.dateToString(StringDateUtil.addDates(StringDateUtil.stringToDate("2018-10-08", 3), 2), 3));
	}*/
	 

	/**
	 * 获得某个月的天数
	 * 
	 * @param month
	 * @return
	 */
	public static int countDaysInMonth(String month) {
		// 获取当前时间
		LocalDate now = LocalDate.now();
		// System.out.println("获取当前时间:" + now);
		// 把当前时间的月份修改为输入的月份
		String monthNew = null;
		// 月份10以下，开头是否带0
		if (month.startsWith("0")) {
			monthNew = month.substring(1);
		} else {
			monthNew = month;
		}
		LocalDate thisMonthDate = now.withMonth(Integer.parseInt(monthNew));
		// System.out.println("月份修改为输入的月份:" + thisMonthDate);
		return thisMonthDate.lengthOfMonth();
	}

}
