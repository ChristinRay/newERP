package com.moka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.dao.ChChannelData;
import com.moka.model.ChChannel;
import com.moka.result.Result;

/**
* @author    created by lbq
* @date	     2018年9月25日 下午7:13:59
**/
@RestController
@RequestMapping("/api/erp/v1/channel/")
public class ChChannelController {
	@Autowired
	private ChChannelData chChannelData;
	
	
	@PostMapping("add")
	public Result<?> add (@RequestBody ChChannel chChannel){
		
		int a= chChannelData.insertChChannel(chChannel);
		return Result.create(a);
	}
}
