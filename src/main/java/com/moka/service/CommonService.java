package com.moka.service;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.moka.Enum.CodeEnum;
import com.moka.dao.IdGeneratorData;
import com.moka.model.BaseModel;
import com.moka.utils.ParamPreconditions;

/**
 * 项目service
 * @author  created by lbq
 * @date    2018年10月5日 上午9:40:37
 */
@Service
@EnableAsync
public class CommonService {

	
	private static final Logger log = LoggerFactory.getLogger(CommonService.class);
	@Autowired
	private IdGeneratorData idGeneratorData;

	/**
	 * 判断是否可分页
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public boolean paginationSupport(Integer pageIndex, Integer pageSize) {
		log.info("判断是否可分页pageIndex:{},pageSize:{}", pageIndex, pageSize);
		if(pageSize == null) pageSize = 20;
		if(pageIndex == null)
			return false;
		ParamPreconditions.checkArgument(pageIndex > 0 && pageSize > 0, CodeEnum.FAIL.getCode(), "页码或页数不能为负数","页码或页数不能为负数");
		return true;
	}
	/**
	 * 获取查询的limit和limitLen
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public int[] getLimit(Integer pageIndex, Integer pageSize) {
		int limit = (pageIndex-1) * pageSize;
		return new int[] {limit,pageSize};
	}
	/**
	 * 填充分页参数
	 * @param entity
	 */
	public void fillEntityParamByPage(BaseModel entity) {
		int limit = (entity.getPageIndex()-1) * entity.getPageSize();
		entity.setLimit(limit);
		entity.setLimitLen(entity.getPageSize());
	}
	/**
	 * 判断是否可分页，如果可分页做limit计算
	 * @param entity
	 * @return
	 */
	public boolean fillPageIfpaginationSupport(BaseModel entity) {
		if(paginationSupport(entity.getPageIndex(), entity.getPageSize())) {
			fillEntityParamByPage(entity);
			return true;
		}else {
			return false;
		}
	}



	/**
	 * 获取in查询串
	 * @param param		以逗号分隔字符串
	 * @return
	 */
	public String getInQryStrByComma(String param) {
		if(!Strings.isNullOrEmpty(param))
			return param;
		return getInQryStr(param.split(","));
	}
	/**
	 * 获取in查询串
	 * @param param
	 * @return
	 */
	public String getInQryStr(String ...param) {
		String result = "";
		for(int i=0;i<param.length;i++) {
			if(!Strings.isNullOrEmpty(param[i]))
				result = result + "'" + param[i] + "'" + ",";
		}
		if(Strings.isNullOrEmpty(result))
			return result;
		return result.substring(0, result.length()-1);
	}
	/**
	 * 获取in查询串
	 * @param param
	 * @return
	 */
	public String getInQryObj(Object ...param) {
		String result = "";
		for(int i=0;i<param.length;i++) {
			if(!Objects.isNull(param[i]))
				result = result + param[i] + ",";
		}
		if(Strings.isNullOrEmpty(result))
			return result;
		return result.substring(0, result.length()-1);
	}

}