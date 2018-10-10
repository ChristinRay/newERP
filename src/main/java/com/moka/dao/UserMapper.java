package com.moka.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.moka.model.SysUser;

/**
* @author    created by lbq
* @date	     2018年10月9日 下午1:29:31
**/
@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {
    @Insert("insert into sys_user(user_name,pass_word) values(#{userName},#{passWord})")
    int addUser(@Param("userName")String userName,@Param("passWord")String passWord);
    
    @Select("select id, user_name as userName,pass_word as passWord from sys_user where id =#{id}")
    @Cacheable(key ="#p0") 
    SysUser findById(@Param("id") int id);
    
    @CachePut(key = "#p0")
    @Update("update sys_user set user_name=#{userName} where id=#{id}")
    void updataById(@Param("id")String id,@Param("userName")String userName);
    
    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    @Delete("delete from sys_user where id=#{id}")
    void deleteById(@Param("id")String id);
    
}
