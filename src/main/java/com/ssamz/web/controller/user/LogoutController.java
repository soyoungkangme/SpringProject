package com.ssamz.web.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		
		/*
		System.out.println("로그아웃 기능 처리");
		
		HttpSession session = request.getSession();
		session.invalidate();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/");
		return mav;
		*/
		
		session.invalidate();    // 세션 강제 종료 
		return "forward:/";
	}

}
