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
	public String loginView(@ModelAttribute("user") UserVO vo) {    // Model 객체 사용되지만 매개변수로 안받아도됨 (자동) 
		vo.setId("test");   // 로그인 화면에서 id, password 세팅 해놓기
		vo.setPassword("test");
		// model.addAttribute("userVO", vo);  // 매개변수로 VO 객체 받으면 자동으로 Model에 등록됨 -> 로그인 화면에서 id, password 정보 뿌릴수 있음 
		return "login";
	}
	// 매개변수로 UserVO 안받아도 되는 로직이지만 매개변수로 VO 객체 받으면, 컨테이너가 자동으로 Model에 등록하므로 화면에 뿌릴수 있음 (Model은 request에 자동 등록)
	// 이동한 jsp 화면에서 Model에 저장된 데이터를 session 아닌 request 로부터 꺼내 쓸수 있음 
	// @ModelAttribute("user") 생략해도 결과 동일 (Model에 UserVO 객체를 user 이름으로 저장해라 -> jsp에서 user로 사용) 
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();  
		return "forward:/"; 
	}
	
}


//UserController 제외한 모든 컨트롤러 삭제 

