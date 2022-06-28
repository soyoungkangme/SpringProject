// 파일 삭제 (스프링꺼씀) 
/*
package com.ssamz.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssamz.web.controller.board.GetBoardListController;
import com.ssamz.web.controller.board.deleteBoardController;
import com.ssamz.web.controller.board.getBoardController;
import com.ssamz.web.controller.board.insertBoardController;
import com.ssamz.web.controller.board.insertBoardViewController;
import com.ssamz.web.controller.board.updateBoardController;
import com.ssamz.web.controller.user.insertUserController;
import com.ssamz.web.controller.user.insertUserViewController;
import com.ssamz.web.controller.user.loginController;
import com.ssamz.web.controller.user.loginViewController;
import com.ssamz.web.controller.user.logoutController;

public class HandlerMapping {
	
	
	private Map<String, Controller> mappings;      // 모든 Controller 객체들을 저장하는 Map 타입의 Collection 변수 
	
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller> ();      // key(문자열), value(Controller 타입의 객체) 형태로 Controller 객체들을 mappings에 등록 
		// BOARD 관련 Controller 등록
		mappings.put("/getBoardList.do", new GetBoardListController());   // 제너릭 Controller 는 인터페이스 이므로 클래스 생성시 자동 implements
		mappings.put("/getBoard.do", new getBoardController()); 
		mappings.put("/insertBoardView.do", new insertBoardViewController());
		mappings.put("/insertBoard.do", new insertBoardController()); 
		mappings.put("/updateBoard.do", new updateBoardController()); 
		mappings.put("/deleteBoard.do", new deleteBoardController()); 
		// User 관련 Controller 등록
		mappings.put("/insertUserView.do", new insertUserViewController());   // WEB-INF 폴더에 대해 브라우저가 직접 요청 할수 없으므로 우회 (회원가입 화면으로 이동)
		mappings.put("/insertUser.do", new insertUserController());
		mappings.put("/loginView.do", new loginViewController());
		mappings.put("/login.do", new loginController());
		mappings.put("/logout.do", new logoutController()); 
	}
	// ViewController 추가 : login, insertUser, insertBoard 화면으로 이동 
		mappings.put("/login.do", new loginController());
		mappings.put("/logout.do", new logoutController()); 
		mappings.put("/insertUser.do", new insertUserController()); 
	}

	
	public Controller getController(String path) {     // mappings에 등록된 Controller 중에서 path에 해당하는 Controller 객체 리턴
		return new GetBoardListController();           // 묵시적 형변환 
	}

}
*/

