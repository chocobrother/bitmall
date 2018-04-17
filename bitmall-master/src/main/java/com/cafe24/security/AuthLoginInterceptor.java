package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.bitmall.service.UserService;
import com.cafe24.bitmall.vo.UserVo;



public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

//	@Autowired
//	private UserService userService;
	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object handler)
			throws Exception {
	
			String id = request.getParameter("id");
			String password = request.getParameter("passwd");

			
			if(id == "") {
				
				response.sendRedirect(request.getContextPath() +"/user/member_login");
				
				System.out.println(" id 가 0 이면 로그인 못하지!!!!!!!!!!!!!!!!!");
				
				return false;
			}
			
			if(password == "") {
				response.sendRedirect(request.getContextPath() +"/user/member_login");
				
				return false;
			}
			
			UserVo vo = new UserVo();
			
			vo.setId(id);
			
			System.out.println("로그인 인터셉트 아이디 : " + vo.getId());
			
			vo.setPasswd(password);
	
			
			//web application 실체에 접근
			//모든 컨테이너는 applicationcontext를 구현한 것이다
			
			ApplicationContext ac = 
			WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
			
			//userservice 클래스를 가지고 있음 줘
			UserService userService = ac.getBean(UserService.class);
			
			UserVo authUser = userService.getUser(vo);
			
			if(authUser == null) {
				response.sendRedirect(request.getContextPath() +"/user/member_login");
				
				System.out.println(" 앙대애애애애애애애애애");
				
				return false;
			}
			
			System.out.println("DDDDDDDDDD" + authUser);
			
			HttpSession session = request.getSession(true);
			session.setAttribute("authUser", authUser);
			response.sendRedirect(request.getContextPath() +"/main");
			
		return false;
	}

	
	
	
	
	
}
