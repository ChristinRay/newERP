package com.moka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.dto.ChannelItemDto;
import com.moka.model.ChChannelItem;
import com.moka.req.ChannelItemReq;
import com.moka.result.Result;
import com.moka.service.ChannelProductService;
import com.moka.service.CommonService;

/**
* @author    created by lbq
* @date	     2018年12月6日 下午1:57:32
**/

@RestController
@RequestMapping("/api/erp/v1/channel/product")
public class ChChannelProductController {
	
	@Autowired
	private ChannelProductService  channelProductService;
	@Autowired
	private CommonService  commonService;
	
	
	/**
	 * add添加商品渠道信息接口
	 * @param req
	 * @return
	 */
	@PostMapping("add")
	public Result<?> add(@RequestBody ChChannelItem chChannelItem){
		chChannelItem.check();

		return channelProductService.add(chChannelItem);
	}
	/**
	 * 渠道商品详情接口
	 * @param chChannelItem
	 * @return
	 */
	@PostMapping("list")
	public Result<?> list(@RequestBody ChannelItemReq channelItemReq){
		if(commonService.paginationSupport(channelItemReq.getPageIndex(), channelItemReq.getPageSize())) {
			int count = channelProductService.selectByCount(channelItemReq);
			int[] page = commonService.getLimit(channelItemReq.getPageIndex(), channelItemReq.getPageSize());
			channelItemReq.setLimit(page[0]);
			channelItemReq.setLimitLen(page[1]);
			channelItemReq.setOrderBy("updatetime");
			List<ChannelItemDto> result = channelProductService.selecChChannelItemByLimt(channelItemReq);
			return Result.createPage(result,(long)count);
		}
		return Result.create("ERROR","参数类型不匹配");
	}
	
}





