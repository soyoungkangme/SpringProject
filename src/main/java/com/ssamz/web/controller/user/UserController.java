package com.ssamz.web.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssamz.biz.user.UserDAOJDBC;
import com.ssamz.biz.user.UserVO;

@Controller
public class UserController {
	
	@RequestMapping("/insertUserView.do")
	public String insertUserView() {
		return "insertUser";
	}
	
	@RequestMapping("/insertUser.do")
	public String insertUser(UserVO vo, UserDAOJDBC userDAO) {
		userDAO.insertUser(vo);
		return "forward:/";
	}
	
	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAOJDBC userDAO, HttpSession session) {
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			if(user.getPassword().equals(vo.getPassword())) {
				session.setAttribute("user", user);
			}
		} 
		return "forward:/";
	}
	
	@RequestMapping("/loginView.do")
	public String loginView(@ModelAttribute("user") UserVO vo) {   // Model 객체에 user로 UserVO 객체 등록해라 (없어도 결과 같지만 등록되 이름 userVO) 
	// 매개변수로 UserVO 안받아도 되는 로직이지만 매개변수로 VO 객체 받으면, 컨테이너가 자동으로 Model에 등록하므로 화면에 뿌릴수 있음 (Model은 request에 자동 등록)
		vo.setId("test");
		vo.setPassword("test");
		return "login";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();  
		return "forward:/";
	}
	
}


//UserController 제외한 모든 컨트롤러 삭제 

