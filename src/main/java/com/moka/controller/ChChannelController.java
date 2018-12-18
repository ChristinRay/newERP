package com.moka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChChannelData;
import com.moka.model.ChChannel;
import com.moka.result.Result;
import com.moka.service.CommonService;
import com.moka.utils.ParamPreconditions;

/**
* @author    created by lbq
* @date	     2018年9月25日 下午7:13:59
**/
@RestController
@RequestMapping("/api/erp/v1/channel/")
public class ChChannelController {
	@Autowired
	private ChChannelData chChannelData;
	@Autowired
	private CommonService commonService;
	
	/**
	 * 渠道添加接口
	 * @param chChannel
	 * @return
	 */
	@PostMapping("add")
	public Result<?> add (@RequestBody ChChannel chChannel){
		int a = chChannelData.insertChChannel(chChannel);
		if(a==1){
			return Result.create("OK", "添加成功");
		}
		
		return Result.create("ERROR", "数据错误");
	}
	/**
	 * 渠道列表接口
	 * @param chChannel
	 * @return
	 */
	@PostMapping("list")
	public Result<?> list (@RequestBody ChChannel chChannel){
		if(commonService.paginationSupport(chChannel.getPageIndex(), chChannel.getPageSize())) {
			int count = chChannelData.selectChChannelByCount(chChannel);
			int[] page = commonService.getLimit(chChannel.getPageIndex(), chChannel.getPageSize());
			chChannel.setLimit(page[0]);
			chChannel.setLimitLen(page[1]);
			chChannel.setOrderBy("updatetime");
			List<ChChannel> result = chChannelData.selectChChannelByLimt(chChannel);
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
	/**
	 * 修改一个渠道信息
	 * @param chChannel
	 * @return
	 */
	@PostMapping("update")
	public Result<?> update (@RequestBody ChChannel chChannel){
		int a = chChannelData.updateChChannelByNullChk(chChannel);
		if(a==1){
			return Result.create("OK", "修改成功");
		}
		return Result.create("ERROR", "数据错误");
	}
	/**
	 * 得到一个渠道信息
	 * @param id
	 * @return
	 */
	@GetMapping("get/one")
	public Result<?> get (Integer id){
		ParamPreconditions.checkNotNull(id, CodeEnum.FAIL.getCode(), "id不能为空");
		ChChannel chChannel = chChannelData.selectOne(id);
		return Result.create(chChannel);
	}
	
	/**
	 * 根据id 逻辑删除一个渠道信息
	 * @param id
	 * @return
	 */
	@GetMapping("delete")
	public Result<?> delete(Integer id){
		int a= chChannelData.deleteByLogic(id);
		if(a==1){
			return Result.create("OK","删除成功");
		}
		return Result.create("ERROR","删除失败");
	}
	
	/**
	 * 获取所有渠道的接口 state='1'
	 * @return
	 */
	@GetMapping("all")
	public Result<?> list(){
		List<ChChannel> list= chChannelData.selectChChannel();
		return Result.create(list);
	}
	
	
} 
