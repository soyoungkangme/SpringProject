package com.ssamz.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssamz.biz.board.BoardDAOJDBC;
import com.ssamz.biz.board.BoardVO;


@Controller   // preseatation-layer.xml 빈등록 대신 메모리 로딩 
public class InsertBoardController {

	@RequestMapping("/insertBoard.do")       // HandlerMapping 객체 대신 .do 요청과 Controller 매핑 
	public String insertBoard(BoardVO vo, BoardDAOJDBC boardDAO) {    // 사용자가 입력한 값을 추출하여 vo에 세팅하는 것 대신 메서드가 BoardVO 객체를 인자로 받으면됨
	// 컨테이너가 메서드 호출할때 인자로 BoardVO 객체 전달, 이때 컨테이너가 자동으로 세터메서드 자동 호출 하여 vo 채워서 전달함 (세터인젝션) 
	// userVO, HttpSession, ModelAndView 등 필요한 객체는 다 생성하거나 게터 메서드 사용없이 매개변수로 받으면 스프링 컨테이너가 생성해서 넘겨줌 (POJO)
		
		/*
		// 1. 사용자 입력정보 추출
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content"); 
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		*/
		
		boardDAO.insertBoard(vo);    // vo 에 세팅된 값으로 insert 처리 
		return "forward:getBoardList.do";     // 뷰이름을 문자열로 리턴하면 해당 화면으로 이동 
		
		/*
		// 3. 페이지 네비게이션
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:getBoardList.do");  // 인서트된 데이터가 포함된 글목록을 다시 셀렉트 해야 하기 때문에 .jsp 아닌 .do 로 가야함 
		// -> forward: 나 redirect: 붙여서 ViewResolver 적용X
		return mav;
		*/
	}

}


//Controller 상속한 객체 => POJO 만들기 
// 1. 부모, 사용하지 않는 매개변수 삭제
// 2. 메서드 이름, 리턴타입 내맘대로 가능 
