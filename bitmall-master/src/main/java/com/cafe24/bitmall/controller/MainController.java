	package com.cafe24.bitmall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.bitmall.service.UserService;
import com.cafe24.bitmall.vo.CategoryVo;
import com.cafe24.bitmall.vo.ProductVo;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping( "/main" )
	public String index(Model model) {
		
		List<ProductVo> list = null;
		
		list = userService.getProduct();
		
		List<CategoryVo> catelist = null;
		
		catelist = userService.getCategory();
		
		Map<String,Object> map = new HashMap();
		
		map.put("list", list);
	    map.put("catelist",catelist);
		
		model.addAttribute("map",map);
		
		return "main/index";
	}

}
