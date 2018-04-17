package com.cafe24.bitmall.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.bitmall.service.UserService;
import com.cafe24.bitmall.vo.BuyVo;
import com.cafe24.bitmall.vo.CartVo;
import com.cafe24.bitmall.vo.FaqVo;
import com.cafe24.bitmall.vo.OrderProductVo;
import com.cafe24.bitmall.vo.ProductVo;
import com.cafe24.bitmall.vo.UserVo;
import com.cafe24.mysite.exception.UserDaoException;
import com.cafe24.security.AuthUser;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/member_login",method = RequestMethod.GET)
	public String login() {
		return "user/member_login";
	}
	
	
	@RequestMapping(value = "/member_agree",method = RequestMethod.GET)
	public String agree() {
		return "user/member_agree";
	}
	
	
	@RequestMapping(value = "/member_join",method = RequestMethod.GET)
	public String join() {
		
		return "user/member_join";
	}
	
	
	@RequestMapping(value = "/member_joinend", method = RequestMethod.POST)
	public String joinend(@AuthUser @ModelAttribute UserVo vo) {
			
		vo.setGrade("user");

		userService.join(vo);
		
		return "user/member_joinend";
			
	}
	
	
	@RequestMapping(value = "/member_modify/{no}", method = RequestMethod.GET)
	public String modify(@ModelAttribute UserVo vo,
			@PathVariable String no) {
				
		return "user/member_modify";
			
	}
	
	@RequestMapping(value = "/member_modifying/{no}", method = RequestMethod.POST)
	public String modifying(@ModelAttribute UserVo vo,
			@PathVariable String no) {
			
		userService.update(vo);
		
		
		return "user/member_modifying";
			
	}

	//cate_no
		@RequestMapping(value = "/product/{no}", method = RequestMethod.GET)
		public String product(
				@PathVariable("no") Long cate_no,
					Model model) throws UserDaoException
			 {
	
			List<ProductVo> list = null;
			
			list = userService.getProlistByNo(cate_no);
			
			
			model.addAttribute("list",list);
			
			return "/product";
				
		}

	//product_no
	@RequestMapping(value = "/product_detail/{product_no}", method = RequestMethod.GET)
	public String productDetail(@PathVariable("product_no") String product_no,
				@AuthUser UserVo vo1,
				Model model) throws UserDaoException
		 {
				
		System.out.println("비회원 구매 방지" + vo1.getId());
						
		System.out.println("productDetail ~~~~" + product_no);
		
		Long no = Long.parseLong(product_no);
		
		ProductVo vo = new ProductVo();
		
		vo = userService.getProductByNo(no);
				
		
		
		model.addAttribute("vo",vo);
		
		return "/product_detail";
			
	}
	
	//////////////////////ORDER 카트에서 구매 
	//order/  상품번호
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(
//			@ModelAttribute ProductVo vo1,
			@AuthUser UserVo vo1,
			@RequestParam(value = "no", required = false) String no1,
			@RequestParam(value = "num", required = false) String num1,
				Model model) throws UserDaoException
		 {
		
		System.out.println("~~~~~~상품 번호~~~~~~" +  no1);
			
		List<CartVo> list = userService.cartlist(vo1.getNo());
		
		
		model.addAttribute("list",list);
		
		return "/order";
			
	}
	
	/////////////////// 바로 구매 order /상품번호 / 수량 
	@RequestMapping(value = "/order1", method = RequestMethod.GET)
	public String order1(
//			@ModelAttribute ProductVo vo1,
			@AuthUser UserVo vo1,
			@RequestParam(value = "no", required = false) String no1,
			@RequestParam(value = "num", required = false) String num1,
				Model model) throws UserDaoException
		 {
		

		

	Long num = Long.parseLong(num1);
	
	Long no = Long.parseLong(no1);
	
	System.out.println("~~~~~~상품 번호~~~~~~" +  no1 + ":" + num);

	
	ProductVo productvo = new ProductVo();
	
	productvo = userService.getProductByNo(no);
	
	CartVo cartvo = new CartVo();
	
	
	cartvo.setImage(productvo.getImage());
	
	cartvo.setProductName(productvo.getProductName());
	
	cartvo.setNum(num);
	
	productvo.setNum(num);
	
	System.out.println("orderpay 1 product 정보 " + productvo);
	
	Long price = Long.parseLong(productvo.getPrice());
	
	cartvo.setCartPrice(price);
	
//	List<CartVo> list = userService.cartjoinpro(no);
	
	List<CartVo> list = new ArrayList<CartVo>();
	
	list.add(cartvo);
	
	for(CartVo vo12 : list) {
		
			System.out.println("바로구매 리스트 " + vo12);

	}
	
	
	Map<String,Object> map = new HashMap();
	
	map.put("list", list);
	map.put("productvo", productvo);
	
	model.addAttribute("map",map);
		
		return "/order1";
			
	}
	
	
	
	//수량과 user_no 상품이름 상품 가격 
	@RequestMapping(value = "/order_pay", 
			method = RequestMethod.POST)
	public String orderPay(
			@AuthUser UserVo uservo,
			@ModelAttribute BuyVo buyVo,
			@RequestParam(value = "product_no", required = false)Long product_no,

			
				Model model) throws UserDaoException
		 {
				
		System.out.println("order pay :" + buyVo);
		

		
		//buyVo 객체에 user_no 매핑 
		buyVo.setUser_no(uservo.getNo());
		
		List<CartVo> list = userService.cartlist(uservo.getNo());
		
		//MAP 사용해서 ORDERPAY에 넘기기 
		Map<String,Object> map = new HashMap();
		
		map.put("buyvo", buyVo);
		map.put("list", list);
//		map.put("productvo", productVo);
		//추후계획 ORDERPAY에서 받은 PRODUCTVO 는 상품 표시
		
		
		System.out.println("buyvo : + 오더페이 : " + buyVo);
		
		
		model.addAttribute("map", map);
		
		// BUYVO에는결제 방식 추가하여 매핑 후 DB 저장 할 것

		return "/order_pay";
			
	}
	
	
	
	
	//@RequestMapping(value = "/order_pay/{num}/{no}/{productName}/{price}/{prono}", 
		@RequestMapping(value = "/order_pay1", 
				method = RequestMethod.POST)
		public String orderPay1(
				@AuthUser UserVo uservo,
				@ModelAttribute BuyVo buyVo,
				@RequestParam(value = "no", required = false)Long no,
				@RequestParam(value = "num", required = false)Long num,

					Model model) throws UserDaoException
			 {
					
			System.out.println("order pay :" + buyVo + "::" + no + "::" + num);
			
			ProductVo productvo = new ProductVo();

			productvo = userService.getProductByNo(no);
			
			productvo.setNum(num);
			
			CartVo cartvo = new CartVo();
			
			cartvo.setUser_no(uservo.getNo());
						
			cartvo.setImage(productvo.getImage());
			
			cartvo.setProductName(productvo.getProductName());
			
			cartvo.setNum(num);
			
			productvo.setNum(num);
			
			System.out.println("orderpay 1 product 정보 확실하냥!!!" + productvo);
			
			Long price = Long.parseLong(productvo.getPrice());
			
			cartvo.setCartPrice(price);
			
//			List<CartVo> list = userService.cartjoinpro(no);
			
			List<CartVo> list = new ArrayList<CartVo>();
			
			buyVo.setUser_no(uservo.getNo());
			
			list.add(cartvo);
			
			Map<String,Object> map = new HashMap();
			
			map.put("productvo", productvo);
			map.put("buyvo", buyVo);
			map.put("list", list);
			
			
			model.addAttribute("map", map);
			
		
			return "/order_pay1";
				
		}
	
	
	
	@RequestMapping(value = "/order_ok", method = RequestMethod.POST)
	public String order_ok(
			@AuthUser UserVo uservo,
			@ModelAttribute BuyVo vo,
			@RequestParam(value = "prono", required = false)String prono1) throws UserDaoException
		 {
		//prono은 product no 입니당.~~
		System.out.println("buy vo orderok : " + vo +"///" );
		
		
		vo = userService.addbuy(vo);
	
		OrderProductVo opvo = new OrderProductVo();
	
			
		//buy테이블 no를 가져와야되요 !
	
		Long orderNo = vo.getNo();
		
		
		//cart 에 담겨있는 상품 no를 가져와서 삽입 해줍니다 .
		
		List<CartVo> list = userService.pronumbycart(uservo.getNo());
		
		for(CartVo cartvo : list) {
			
			System.out.println("cartvo vovovo : :" + cartvo);
			
			opvo.setProduct_no(cartvo.getProduct_no());
			opvo.setOrder_no(orderNo);
			opvo.setNum(cartvo.getNum());
			userService.addorder(opvo);
		}
		
		

		
		//카트내용 전부 삭제
		userService.cartalldelete();
		
		return "/order_ok";
			
	}
	
	
	
	@RequestMapping(value = "/order_ok1", method = RequestMethod.POST)
	public String order_ok1(
			@AuthUser UserVo uservo,
			@ModelAttribute BuyVo vo,
			@RequestParam(value = "product_no", required = false)Long product_no,
			@RequestParam(value = "product_num", required = false)Long product_num) throws UserDaoException
		 {
		//prono은 product no 입니당.~~
		System.out.println("buy vo orderok1 : " + vo +"///"  + product_no + "?//" + product_num);
		
		System.out.println("바로 구매 수량은 "  + product_num);
		
		vo = userService.addbuy(vo);
	
		OrderProductVo opvo = new OrderProductVo();
	
			
		//buy테이블 no를 가져와야되요 !
	
		Long orderNo = vo.getNo();
		
		
	
		opvo.setProduct_no(product_no);
		opvo.setOrder_no(orderNo);
		opvo.setNum(product_num);
		
		System.out.println("바로구매 opvo 는? "  + opvo);
		
		userService.addorder(opvo);
	
		
		return "/order_ok";
			
	}
	

	//user_id
	@RequestMapping(value = "/jumun/{id}", method = RequestMethod.GET)
	public String jumun(@PathVariable String id,
			@AuthUser UserVo vo,
			Model model) throws UserDaoException
		 {
		
	  Long user_id = vo.getNo();
	  
	  System.out.println("user_id jumun" + user_id);
		
	 List<BuyVo> list = userService.jumunlist(user_id);
	  
	 for(BuyVo vo2 : list) {
		 System.out.println("주문정보 다나와 새끼드랑!!!!!!!!!1" + vo2);
		 
	 }
	
	  model.addAttribute("list",list);
		
		return "/jumun";
			
	}
	

	@RequestMapping(value = "/jumun_info/{no}/{productName}/{product_no}/{num}", method = RequestMethod.GET)
	public String jumuninfo(@PathVariable("no") Long buy_no,
			@PathVariable("productName") String productName,
			@PathVariable("product_no") Long product_no,
			@PathVariable("num") Long product_num,
			Model model) throws UserDaoException
		 {

		BuyVo vo = userService.getbuyinfo(buy_no);
		

		vo.setProductName(productName);
		
		vo.setProduct_no(product_no);
		
		vo.setNum(product_num);
	
		String image = userService.getImage(productName);
		

		
		Map<String,Object> map = new HashMap();
		
		map.put("vo", vo);
		map.put("image", image);
		
		model.addAttribute("map",map);
		
	System.out.println("jumun info에 들아가서 buy no" + buy_no);
		return "/jumun_info";
			
	}
	
	
	//authUser.no / 상품번호 / 상품 가격 
	@RequestMapping(value = "/cart/{no}/{product_no}/{cartPrice}/{productName}", method = RequestMethod.GET)
	public String cart(
			@PathVariable String no,
			@PathVariable String product_no,
			@PathVariable String cartPrice,
			@PathVariable String productName,
			@ModelAttribute CartVo cartvo,
			@AuthUser UserVo vo,
			Model model) throws UserDaoException
		 {
			
			String image = userService.getImage(productName);	
	
			Long user_no = Long.parseLong(no);
			
			Long product_no1 = Long.parseLong(product_no);
		
			cartvo.setImage(image);
			
			Long cartPrice1 = Long.parseLong(cartPrice);
			
			cartvo.setCartPrice(cartPrice1);
			
			
			
			cartvo.setUser_no(user_no);
			
			System.out.println("cart price :" + cartPrice1);
		
			System.out.println("cart vo :" + cartvo);
	  
			userService.addcart(cartvo);
		
		return "redirect:/user/cart/"+user_no;
//			return null;
			
	}
	//authUser.no 
	@RequestMapping(value = "/cart/{no}", method = RequestMethod.GET)
	public String cart(@AuthUser UserVo vo,
			@PathVariable String no,
			Model model) throws UserDaoException
		 {
	
		Long user_no = Long.parseLong(no);

//		System.out.println("cart user no" + vo.getNo() + ":::///" + user_no);
		
		List<CartVo> list = userService.cartlist(user_no);
		
		//카트리스트에 있는프로덕트 넘버를 가져와서 프로덕트 정보를 출력  
		
		ProductVo productVo = userService.getProductByNo(user_no);
	 
		model.addAttribute("list",list);
		
		return "/cart";
			
	}
	
	//cart_no
	@RequestMapping(value = "/cartdelete/{no}", method = RequestMethod.GET)
	public String cartdelete(@AuthUser UserVo vo,
			@PathVariable String no,
			Model model) throws UserDaoException
		 {
		Long cart_no = Long.parseLong(no);
		
		userService.deletecart(cart_no);
		
		return "redirect:/user/cart/"+vo.getNo();
			
	}
	
	@RequestMapping(value = "/cartalldelete", method = RequestMethod.GET)
	public String cartalldelete(@AuthUser UserVo vo
		) throws UserDaoException
		 {
		
		
		userService.cartalldelete();
		
		return "redirect:/user/cart/"+vo.getNo();
			
	}
	
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faq(@AuthUser UserVo vo,
		Model model
		) throws UserDaoException
		 {
		
		List<FaqVo> list = null;
		
		list = userService.getfaqlist();
			
		model.addAttribute("list",list);
		
		return "/faq";
			
	}
	
	@RequestMapping(value = "/faq_read/{no}", method = RequestMethod.GET)
	public String faq_read(@AuthUser UserVo vo1,
			@PathVariable("no") Long no,	
		Model model
		) throws UserDaoException
		 {
		
		FaqVo vo = null;
		
		vo = userService.faqbyno(no);
			
		model.addAttribute("vo",vo);
		
		return "/faq_read";
			
	}
	
	
}
