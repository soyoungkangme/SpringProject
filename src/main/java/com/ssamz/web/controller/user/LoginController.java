package com.ssamz.web.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssamz.biz.user.UserDAOJDBC;
import com.ssamz.biz.user.UserVO;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAOJDBC userDAO, HttpSession session) {
	// 내가 만든 Controller는 리턴 타입 String, 스프링이 제공하는 Controller는 ModelAndView
		/*
		System.out.println("로그인 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		
		UserDAO dao = new UserDAOJDBC();
		*/
		UserVO user = userDAO.getUser(vo);
		
		/*
		// 3. 화면 이동
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			if(user.getPassword().equals(password)) {
				HttpSession session = request.getSession();   // 상태 정보를 세션에 저장
				session.setAttribute("user", user);
			}
		} 
		mav.setViewName("forward:/");    // index.jsp는 파일이름 명시하지 않아도됨 
		return mav;
		*/
		
		if(user != null) {
			if(user.getPassword().equals(vo.getPassword())) {
				session.setAttribute("user", user);
			}
		} 
		return "forward:/";

	}

}
