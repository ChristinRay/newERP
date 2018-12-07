package com.moka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.req.ChannelProductReq;
import com.moka.result.Result;
import com.moka.service.ChannelProductService;

/**
* @author    created by lbq
* @date	     2018年12月6日 下午1:57:32
**/

@RestController
@RequestMapping("/api/erp/v1/channel/product")
public class ChChannelProductController {
	
	@Autowired
	private ChannelProductService  channelProductService;
	
	@PostMapping("find/product")
	public Result<?> findProduct(@RequestBody ChannelProductReq req){
	channelProductService.findProduct(req);
		
		return null;
	}
	
}
