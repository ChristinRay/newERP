package com.moka.service;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.moka.Enum.Presentation;
import com.moka.Enum.Reason;
import com.moka.Enum.Solution;
import com.moka.dao.ChComplaintInformationData;
import com.moka.model.ChComplaintInformation;
import com.moka.result.Result;

import lombok.extern.slf4j.Slf4j;
/**
 * @author 耿长伟
 * @date	     2018年11月8日 下午6:36:07
 *
 */
@Service
@Slf4j
public class ChComplaintInformationService {
	
	@Autowired
	ChComplaintInformationData chComplaintInformationData;
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	/**
	 * 添加诉单信
	 * @param chComplaintInformation
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Result<?> add(ChComplaintInformation chComplaintInformation) throws IllegalAccessException, InvocationTargetException{
		log.info("添加诉单信开始，请求参数："+JSON.toJSONString(chComplaintInformation));
		chComplaintInformation.check();//字段非空校验
		
		chComplaintInformation.setState("1");
		int a= chComplaintInformationData.insertChComplaintInformation(chComplaintInformation);
		if(a==1){
			log.info("添加诉单信结束，添加成功");
			return Result.create(chComplaintInformation);
		}
		log.info("添加诉单信结束，添加失败");
		return Result.create("ERROR","添加失败");
	}
	
	/**
	 * 诉单 情况说明 列表放入缓存
	 */
	@PostConstruct
	public void initPresentation() {
		log.info("进入缓存");
		String key ="presentationList";
		HashOperations<String, String, String> vo  = redisTemplate.opsForHash();
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	log.info("缓存存在");
        }
        for (Presentation presentation : Presentation.values()) {
        	vo.put(key,presentation.getCode(),presentation.getMsg());
        }
        log.info("方法结束"); 
	}
	
	/**
	 * 诉单 原因 列表放入缓存
	 */
	@PostConstruct
	public void initReason() {
		log.info("进入缓存");
		String key ="reasonList";
		HashOperations<String, String, String> vo  = redisTemplate.opsForHash();
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	log.info("缓存存在");
        }
        for (Reason reason : Reason.values()) {
        	vo.put(key,reason.getCode(),reason.getMsg());
        }
        log.info("方法结束");
	}
	
	/**
	 * 诉单 解决方案列表放入缓存
	 */
	@PostConstruct
	public void initSolution() {
		log.info("进入缓存");
		String key ="solutionList";
		HashOperations<String, String, String> vo  = redisTemplate.opsForHash();
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	log.info("缓存存在");
        }
        for (Solution solution : Solution.values()) {
        	vo.put(key,solution.getCode(),solution.getMsg());
        }
        log.info("方法结束");
	}
	
	/**
	 * 诉单 情况说明 读取缓存
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public Result<?> presentationList()  {
		
		String key ="presentationList";
		HashOperations<String,String, String> vo  = redisTemplate.opsForHash();
		log.info("开始读取缓存");
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	Map<String, String> map=vo.entries(key);
            log.info("诉单 情况说明 >> "+map);
            return Result.create(map);
        }
        return Result.create("OK","读取成功");
	}
	
	/**
	 * 诉单 原因 读取缓存
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public Result<?> reasonList() throws UnsupportedEncodingException {
		
		String key ="reasonList";
		HashOperations<String,String, String> vo  = redisTemplate.opsForHash();
		log.info("开始读取缓存");
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	Map<String, String> map=vo.entries(key);
            log.info("从缓存中读取诉单 原因 >> " + map);
            return Result.create(map);
        }
        return Result.create("OK","读取成功");
	}
	
	/**
	 * 诉单 解决方案 读取缓存
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public Result<?> solutionList() throws UnsupportedEncodingException {
		
		String key ="solutionList";
		HashOperations<String,String, String> vo  = redisTemplate.opsForHash();
		log.info("开始读取缓存");
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	Map<String, String> map=vo.entries(key);
            log.info("从缓存中读取诉单 解决方案 >> " + map);
            return Result.create(map);
        }
        return Result.create("OK","读取成功");
	}

}
