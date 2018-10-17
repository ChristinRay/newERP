package com.moka.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moka.Enum.CodeEnum;
import com.moka.dao.ChBrandData;
import com.moka.model.ChBrand;
import com.moka.result.Result;
import com.moka.result.ResultFul;
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
	private RedisTemplate redisTemplate;
	
	@Transactional
	public ResultFul add(ChBrand entity){
		
		int a = chBrandData.insertChBrand(entity);
		if (a==1){
			return ResultFul.create("OK","品牌添加成功");
		}
		
		return ResultFul.create("ERROR", "品牌添加失败");
	}
	
	public Result<?> list(ChBrand entity){
		String key = "brandList";
		ValueOperations<String, List<ChBrand>> operations = redisTemplate.opsForValue();
		// 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	List<ChBrand> list = operations.get(key);
            log.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + list.toString());
            return Result.create(list);
        }
        // 从 DB中获取品牌信息
        List<ChBrand> list= chBrandData.selectChBrand(entity);
        ParamPreconditions.checkNotNull(list, CodeEnum.FAIL.getCode(), "不能为空");
        operations.set(key, list,10, TimeUnit.HOURS);
        return Result.create(list);
	}
}





