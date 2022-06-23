package com.ssamz.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertUserViewController {

	@RequestMapping("/insertUserView.do")
	public String insertUserView() {
		
		/*
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insertUser");      // 회원가입 화면으로 이동
		return mav;
		*/
		
		return "insertUser";
	}

}

// ~.jsp 브라우저가 요청 못하도록 막아야함 (데이터 없는 목록 뜨므로) -> index 제외한 모든 jsp를 WEB-INF로 옮기기 -> 브라우저에서 요청 못하므로 우회 