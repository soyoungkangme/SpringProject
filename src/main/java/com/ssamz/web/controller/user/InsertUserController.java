package com.ssamz.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssamz.biz.user.UserDAOJDBC;
import com.ssamz.biz.user.UserVO;

@Controller  
public class InsertUserController {

	@RequestMapping("/insertUser.do")
	public String insertUser(UserVO vo, UserDAOJDBC userDAO) {
		
		/*
		System.out.println("회원 등록 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
			
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setRole(role);
		
		UserDAO dao = new UserDAOJDBC();
		dao.insertUser(vo);
		
		// 3. 화면 이동	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/");
		return mav;
		*/
		
		userDAO.insertUser(vo);
		return "forward:/";
		

	}

}
