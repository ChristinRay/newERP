package com.moka.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChCategoryData;
import com.moka.model.ChCategory;
import com.moka.utils.ParamPreconditions;

import lombok.extern.slf4j.Slf4j;

/**
* @author    created by lbq
* @date	     2018年10月15日 下午4:50:06
**/
@Service
@Slf4j
public class ChCategoryService {
	private static String key="typeList";
	
	@Autowired
	private ChCategoryData chCategoryData;
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public List<ChCategory> getCategory(ChCategory chCategory){
		List<ChCategory> list = chCategoryData.selectChCategory(chCategory);
		
		return list;
	}
	/**
	 * 把类别列表放入缓存
	 */
	@PostConstruct
	public void init() {
		log.info("进入类别缓存");
		HashOperations<String, String, String> vo  = redisTemplate.opsForHash();
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	log.info("类别缓存存在");
        }
        // 从 DB中获取品牌信息
        List<ChCategory> list= chCategoryData.selectChCategoryAll();
        ParamPreconditions.checkNotNull(list, CodeEnum.FAIL.getCode(), "不能为空");
        for (ChCategory chCategory : list) {
        	vo.put(key,chCategory.getId()+"",chCategory.getCategoryName());
		}
        log.info("方法结束");
	}
	
	public String findNameByCode(String id) throws UnsupportedEncodingException {
		HashOperations<String, String, String> vo  = redisTemplate.opsForHash();
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	String typeName = vo.get(key, id);
            log.info("从缓存获取类型名称 >> " + typeName.toString());
            return typeName;
        }
        return "类型测试";
	}
}
