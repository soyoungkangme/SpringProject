package com.ssamz.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginViewController {

	@RequestMapping("/loginView.do")
	public String loginView() {
		/*
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
		*/
		
		return "login";
	}

}
