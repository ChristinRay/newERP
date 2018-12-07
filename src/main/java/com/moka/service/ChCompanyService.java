package com.moka.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChCompanyData;
import com.moka.model.ChCompany;
import com.moka.utils.ParamPreconditions;

import lombok.extern.slf4j.Slf4j;

/**
* @author    created by lbq
* @date	     2018年9月27日 下午7:46:07
**/
@Service
@Slf4j
public class ChCompanyService {
	
		private static final String key="companyList";
	
		@Autowired
		private ChCompanyData chCompanyData;
		@Autowired
		private StringRedisTemplate redisTemplate;
		
		@Transactional
		public int add(ChCompany chCompany){
			chCompanyData.insertChCompany(chCompany);
			
			return chCompany.getId();
		}
		
		
		/**
		 * 把公司列表放入缓存
		 */
		@PostConstruct
		public void init() {
			log.info("进入缓存");
			HashOperations<String, String, String> vo  = redisTemplate.opsForHash();
			// 缓存存在
	        boolean hasKey = redisTemplate.hasKey(key);
	        if (hasKey) {
	        	log.info("缓存存在");
	        }
	        // 从 DB中获取品牌信息
	        List<ChCompany> list= chCompanyData.selectChCompanyAll();
	        ParamPreconditions.checkNotNull(list, CodeEnum.FAIL.getCode(), "不能为空");
	        for (ChCompany chCompany : list) {
	        	vo.put(key,chCompany.getId()+"",chCompany.getCompanyName());
			}
	        log.info("方法结束");
		}
		
		/**
		 * 读取
		 * @param id
		 * @return
		 * @throws UnsupportedEncodingException
		 */
		public String findNameById(Integer id) throws UnsupportedEncodingException {
			HashOperations<String, String, String> vo  = redisTemplate.opsForHash();
			// 缓存存在
	        boolean hasKey = redisTemplate.hasKey(key);
	        if (hasKey) {
	        	String companyName = vo.get(key, id+"");
	        	//log.info("从缓存获取类型名称 >> " + companyName.toString());
	            return companyName;
	        }
	        return "类型测试";
		}
		/**
		 * 获取列表(测试)
		 * @param id
		 * @return
		 * @throws UnsupportedEncodingException
		 */
		public Map<String, String> getAll()  {
			HashOperations<String, String, String> vo= redisTemplate.opsForHash();
			// 缓存存在
	        boolean hasKey = redisTemplate.hasKey(key);
	        if (hasKey) {
	        	Map<String, String> map= vo.entries(key);
	        	//log.info("从缓存获取类型名称 >> " + map.toString());
	            return map;
	        }
	        return null;
		}
		
		
}
