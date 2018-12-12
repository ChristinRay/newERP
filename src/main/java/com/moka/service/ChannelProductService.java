package com.moka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moka.dao.ChChannelItemData;
import com.moka.dto.ChannelItemDto;
import com.moka.model.ChChannelItem;
import com.moka.req.ChannelItemReq;
import com.moka.result.Result;

import lombok.extern.slf4j.Slf4j;

/**
* @author    created by lbq
* @date	     2018年12月7日 下午3:14:34
**/
@Service
@Slf4j
public class ChannelProductService {
	@Autowired
	private ChChannelItemData  chChannelItemData;
	
	/**
	 * 添加渠道
	 * @param entity
	 * @return
	 */
	@Transactional
	public Result<?> add(ChChannelItem entity){
		log.info("添加信息"+entity);
	
		int a= chChannelItemData.insertChChannelItem(entity);
		if(a!=1){
			return Result.create("ERROR","数据错误");
		}
		return Result.create("OK", "添加成功");
	}

	/**
	 * 分页查询渠道商品详情service
	 */
	public List<ChannelItemDto> selecChChannelItemByLimt(ChannelItemReq channelItemReq) {
		log.info("添加信息"+channelItemReq);
		channelItemReq.setState("1");
		
		return chChannelItemData.selectChChannelItemByLimt(channelItemReq);
	}

	/**
	 * 数量
	 * @param channelItemReq
	 * @return
	 */
	public int selectByCount(ChannelItemReq channelItemReq) {
		channelItemReq.setState("1");
		return chChannelItemData.selectChChannelItemByCount(channelItemReq);
	}
}
