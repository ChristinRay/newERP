package com.moka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.Enum.CodeEnum;
import com.moka.dao.TDataDictData;
import com.moka.model.TDataDict;
import com.moka.result.Result;
import com.moka.utils.ParamPreconditions;

/**
* @author    created by lbq
* @date	     2018年10月15日 上午11:46:48
**/
@RestController
@RequestMapping("/api/erp/v1/dic/")
public class DictionaryController {
	@Autowired
	private TDataDictData tdataDictData;
	/**
	 * 根据字典数据得到对应的值
	 * @param tDataDict
	 * @return
	 */
	@PostMapping("get/value")
	public Result<?> getAll(@RequestBody TDataDict tDataDict){
		ParamPreconditions.checkNotEmpty(tDataDict.getFieldCode(), CodeEnum.FAIL.getCode(), "fieldCode类型不能不为空", "fieldCode类型不能不为空");
		List<TDataDict> list= tdataDictData.selectTDataDict(tDataDict);
		ParamPreconditions.checkNotNull(list, CodeEnum.FAIL.getCode(), "fieldCode类型错误");
		return Result.create(list);
	}
}











