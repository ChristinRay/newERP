package com.moka.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.moka.model.Product;

/**
* @author    created by lbq
* @date	     2018年9月10日 下午7:34:33
**/
@Controller
@RequestMapping(value = "/erp/v1/product/")
public class ProductController {
	@PostMapping("ceshi11")
	public String ceshi (){
		return "测试";
	}
	
	@GetMapping("demo")
	public String listProduct(Model model){
		List<Product> productlist=Lists.newArrayList();
		
		productlist.add(new Product(1L,"1"));
		model.addAttribute("products",productlist);
		return "/product/list";
	}
}
