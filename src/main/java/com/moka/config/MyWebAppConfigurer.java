//package com.moka.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import lombok.extern.slf4j.Slf4j;
//
///**
//* @author    created by lbq
//* @date	     2018年12月17日 下午2:41:53
//**/
//@SuppressWarnings("deprecation")
//@Configuration
//@Slf4j
//public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
//	
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//    	log.info("跨越设置"+"测试");
//        registry.addMapping("/api/erp/v1/**")
//        .allowedOrigins("http://192.168.0.176:8001")
//        .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
//          .allowCredentials(true).maxAge(3600);
//    }
//    
//}
