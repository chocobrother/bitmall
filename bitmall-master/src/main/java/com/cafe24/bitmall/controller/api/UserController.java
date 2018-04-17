package com.cafe24.bitmall.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.bitmall.dto.JSONResult;
import com.cafe24.bitmall.service.UserService;
import com.cafe24.bitmall.vo.CategoryVo;
import com.cafe24.mysite.exception.UserDaoException;

@Controller("userAPIController")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/categoryadd")
	public JSONResult categoryadd(@RequestParam(value = "posttype", required = true, defaultValue = "") String posttype,
			@RequestParam(value = "user_no", required = true, defaultValue = "") String user_no) throws UserDaoException {

		CategoryVo vo = new CategoryVo();

		Long user_noL = Long.parseLong(user_no);
		
		vo.setPosttype(posttype);
		
		vo.setUser_no(user_noL);
		
		System.out.println(vo);
		
		vo =  userService.categoryadd(vo);  //DB 저장
	
		System.out.println("vo 실험" + vo);
		
		return JSONResult.success(vo == null?"not exists":"exist");
	}

	@ResponseBody
	@RequestMapping("/categorydelete")
	public JSONResult categorydelete(@RequestParam(value = "no", required = true, defaultValue = "") String no1
			) {

		CategoryVo vo = new CategoryVo();

		System.out.println("ajax delete no" + no1);
		
		Long no = Long.parseLong(no1);
		
		vo.setCate_no(no);
		
		
		userService.categorydelete(no);

		return JSONResult.success(vo == null?"not exists":"exist");
	}
}

