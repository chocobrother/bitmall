package com.cafe24.bitmall.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.bitmall.service.UserService;
import com.cafe24.bitmall.vo.BuyVo;
import com.cafe24.bitmall.vo.CategoryVo;
import com.cafe24.bitmall.vo.FaqVo;
import com.cafe24.bitmall.vo.ProductVo;
import com.cafe24.bitmall.vo.UserVo;
import com.cafe24.mysite.exception.UserDaoException;
import com.cafe24.security.Auth;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/{id:(?!uploads|assets).*}")
public class AdminController {


	@Autowired
	
	private UserService userService;
	
//	@RequestMapping(value = "/login",method = RequestMethod.GET)
//	public String login() {
//		return "admin/login";
//	}
	
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String member(@PathVariable("id") String id,
			Model model) throws UserDaoException {
		
		List<UserVo> list = userService.getlist();
		
		//회원 수 세기 위함
		Long count = userService.getcount();
		

		Map<String, Object> map = new HashMap();
		
		map.put("list", list);
		map.put("count", count);
		
		model.addAttribute("map",map);
		
		return "admin/member";
	}
	
	
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value = "/product",method = RequestMethod.GET)
	public String product(@PathVariable("id") String id,
			@ModelAttribute ProductVo vo,
			Model model) throws UserDaoException {
		

		//상품 리스트 가져오기

		List<ProductVo> list = null;
		
		list = userService.getProduct();
		
		Long count = userService.getproductcount();
		
		Map<String,Object> map = new HashMap();
		
		map.put("list", list);
		map.put("count", count);
		
		model.addAttribute("map",map);
		
		
		
		return "admin/product";
	}
	
	
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value = "/product",method = RequestMethod.POST)
	public String product(
			@ModelAttribute ProductVo vo,
			@AuthUser UserVo uservo,
			@RequestParam("image_file") MultipartFile multipartFile,
			@RequestParam("no") Long no,
			Model model) throws UserDaoException {
		

		String url = userService.restore(multipartFile);
		
		System.out.println("product update vo " + vo +":"+url);
		
		vo.setImage(url);
		
		vo.setNo(no);
		
		userService.updateproduct(vo);
		
		
		return "redirect:/"+uservo.getId()+"/product";
	}
	
	
	
	@Auth(role=Auth.Role.ADMIN)
	@RequestMapping(value = "/product_new",method = RequestMethod.GET)
	public String productNew(@PathVariable("id") String id,
			
			Model model) throws UserDaoException {
		
		List<CategoryVo> list = null;
		
		list = userService.getCategory();
		
		model.addAttribute("list",list);
		

		return "admin/product_new";
	}
	
	
	@RequestMapping(value = "/product_success",method = RequestMethod.POST)
	public String productSuccess(@PathVariable("id") String id,
			@ModelAttribute ProductVo vo,
			@RequestParam("image_file") MultipartFile multipartFile,
			Model model) throws UserDaoException {
		
		String url = userService.restore(multipartFile);
		
		System.out.println("product vo " + vo +":"+url);
		
		vo.setImage(url);
								
		userService.addproduct(vo);
				
		return "admin/product_success";
	}
	
	@RequestMapping(value = "/product_edit/{no}",method = RequestMethod.GET)
	public String product_edit(@PathVariable("no") Long no1,
			Model model) throws UserDaoException {
		
//		Long no = Long.parseLong(no1);
		
		List<CategoryVo> list = null;
		
		list = userService.getCategory();
		
		
		ProductVo vo = userService.getProductByNo(no1);
		
		Map<String, Object> map = new HashMap();
		
		map.put("list", list);
		map.put("vo", vo);
		
		model.addAttribute("map",map);
		
		

		return "admin/product_edit";
	}
	
	@RequestMapping(value = "/{no}",method = RequestMethod.GET)
	public String productdelete(@PathVariable("no") Long no1,
			Model model) throws UserDaoException {
		
//		Long no = Long.parseLong(no1);
		
		userService.productDelete(no1);

		return "redirect:/admin/product";
	}
	
	
	
	
	@RequestMapping(value = "/jumun",method = RequestMethod.GET)
	public String jumun(@AuthUser UserVo vo,
			Model model) throws UserDaoException {
		
		
		List<BuyVo> list = null;
		
		
//		list = userService.jumunlist(vo.getNo());
	
		list = userService.alljumunlist();
		
		Long count = userService.getbuycount();
		
		for(BuyVo vo2 : list) {
			System.out.println("admin jumun" + vo2);
		}
		
		
		Map<String,Object> map = new HashMap();
		
		map.put("list", list);
		map.put("count", count);
		
		model.addAttribute("map",map);
		
		return "admin/jumun";
	}
	
	//주문 번호 
	@RequestMapping(value = "/jumun_info/{no}/{productName}/{num}",method = RequestMethod.GET)
	public String jumuninfo(@PathVariable("no") Long no,
			@PathVariable("productName") String productName,
			@PathVariable("num") Long num,
			Model model) throws UserDaoException {
		
		System.out.println("jumun_info : " + no);
		
		BuyVo vo = null;


		vo = userService.buylistbyno(no);
		
		vo.setProductName(productName);
		vo.setNum(num);
		
		//네임 수량 받아서 
		
		model.addAttribute("vo",vo);
//		
		
		return "admin/jumun_info";
	}
	
	
	//주문 번호 
		@RequestMapping(value = "/jumun_delete/{no}",method = RequestMethod.GET)
		public String jumun_delete(@PathVariable("no") Long no,
			
				Model model) throws UserDaoException {
			
			
			userService.orderjumundelete(no);
			
			userService.jumundelete(no);
			
			return "redirect:/admin/jumun";
		}
		
	
	
	
	@RequestMapping(value = "/faq",method = RequestMethod.GET)
	public String faq(Model model) throws UserDaoException {
		
		List<FaqVo> list  = null;
		
		list = userService.getfaqlist();
		
		for(FaqVo vo : list) {
			
			System.out.println("faq : " + vo);
		}
		
		model.addAttribute("list",list);
		
		return "admin/faq";
	}
	
	@RequestMapping(value = "/faq",method = RequestMethod.POST)
	public String faq(@PathVariable("id") String id,
			@ModelAttribute FaqVo vo,
			@AuthUser UserVo uservo,
			Model model) throws UserDaoException {
		
		
		vo.setUser_no(uservo.getNo());
		
		userService.addfaq(vo);
		
	
		return "redirect:/admin/faq";
	}
	
	@RequestMapping(value = "/faq1/{no}",method = RequestMethod.POST)
	public String faq1(@PathVariable("id") String id,
			@ModelAttribute FaqVo vo,
			@PathVariable("no") String no,
			Model model) throws UserDaoException {
				
		userService.updatefaq(vo);
     
		
	
		return "redirect:/admin/faq";
	}
	
	
	
	@RequestMapping(value = "/faq_new",method = RequestMethod.GET)
	public String faq_new(@PathVariable("id") String id,
			Model model) throws UserDaoException {
		
		
		return "admin/faq_new";
	}
	
	@RequestMapping(value = "/faq_edit/{no}",method = RequestMethod.GET)
	public String faq_edit(@PathVariable("id") String id,
			@PathVariable("no") Long no,
			Model model) throws UserDaoException {
		
//		System.out.println("no1: " + no1);
//		
//		Long no = Long.parseLong("no1");
		
		model.addAttribute("no",no);
		
		return "admin/faq_edit";
	}
	
	@RequestMapping(value = "/faq_delete/{no}",method = RequestMethod.GET)
	public String faq_delete(@PathVariable("id") String id,
			@PathVariable("no") String no1,
			Model model) throws UserDaoException {
		
		Long no = Long.parseLong(no1);
		
		userService.deletefaq(no);
		
		
		return "redirect:/admin/faq";
	}
	
	
	
	@RequestMapping(value = "/category",method = RequestMethod.GET)
	public String category(@PathVariable("id") String id,
			Model model) throws UserDaoException {
		
		List<CategoryVo> list = null;
		
		list = userService.getCategory();
		
		Long count = userService.getcategorycount();
		
		Map<String,Object> map = new HashMap();
		
		map.put("list", list);
		map.put("count", count);
		
		
		model.addAttribute("map",map);
		
		return "admin/category";
	}
	
}
