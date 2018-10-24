package com.moka.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChBrandData;
import com.moka.model.ChBrand;
import com.moka.result.Result;
import com.moka.utils.ParamPreconditions;

import lombok.extern.slf4j.Slf4j;

/**
* @author    created by lbq
* @date	     2018年9月17日 下午4:47:41
**/
@Service
@Slf4j
public class ChBrandService {

	@Autowired
	private ChBrandData chBrandData;
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public Result<?> list() throws UnsupportedEncodingException {
		String key ="brandList";
		ValueOperations<String, String> vo  = redisTemplate.opsForValue();
		log.info("开始读取缓存");
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	String list=vo.get(key);
            log.info("从缓存中读取品牌 >> " + list.toString());
            return Result.create(list);
        }
        return Result.create("OK","读取成功");
	}
	
	
	public String findNameByCode(String brandCode) throws UnsupportedEncodingException {
		String key ="brandList";
		HashOperations<String, String, String> vo  = redisTemplate.opsForHash();
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	String brandName = vo.get(key, brandCode);
            log.info("从缓存获取品牌名称 >> " + brandName.toString());
            return brandName;
        }
        return "测试";
	}
	/**
	 * 把品牌列表放入缓存
	 */
	@PostConstruct
	public void init() {
		log.info("进入缓存");
		String key ="brandList";
		HashOperations<String, String, String> vo  = redisTemplate.opsForHash();
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	log.info("缓存存在");
        }
        // 从 DB中获取品牌信息
        List<ChBrand> list= chBrandData.selectChBrandAll();
        ParamPreconditions.checkNotNull(list, CodeEnum.FAIL.getCode(), "不能为空");
        for (ChBrand chBrand : list) {
        	vo.put(key,chBrand.getBrandCode(),chBrand.getBrandName());
		}
        log.info("方法结束");
	}
	
}





