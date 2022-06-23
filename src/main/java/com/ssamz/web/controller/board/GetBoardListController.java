package com.ssamz.web.controller.board;

import java.util.List;

import org.springframework.stereotype.Controller;   // 내가 만든거 말고 스프링꺼 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssamz.biz.board.BoardDAOJDBC;
import com.ssamz.biz.board.BoardVO;


@Controller
public class GetBoardListController {

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAOJDBC boardDAO, ModelAndView mav) {   
	// 내가 만든 Controller는 String 반환 -> ModelAndView
		
		/*  스프링 컨테이너가 BoardVO 자동으로 세팅 후 넘겨줌 
		System.out.println("글 목록 검색 기능 처리");
		// 사용자 입력정보 추출
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		*/

		/*
		// Null Check
		if(searchCondition == null) searchCondition = "TITLE";
		if(searchKeyword == null) searchKeyword = "";
		
		request.setAttribute("condition", searchCondition);
		request.setAttribute("keyword", searchKeyword);
		*/
		
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");

		mav.addObject("condition", vo.getSearchCondition());    // ModelAndView에 저장하면 request에 자동 저장되므로 똑같음 
		mav.addObject("keyword", vo.getSearchKeyword());
		
		
		/*
		// 디비 연동
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		BoardDAO dao = new BoardDAOJDBC();      // DAO 생성하여 JDBC 기반으로 글목록 반환
		*/
		List<BoardVO> boardList = boardDAO.getBoardList(vo);   // 글 목록 받아옴 
		
		// 화면 이동 (스프링의 Contoller 사용) : 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴 (handleRequest()의 반환값) 
		// 어떤 데이터(검색결과)를 어느화면에서 뿌릴거냐 
		// ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardList", boardList);                 // 앞의 이름으로 뒤의 검색결과(Model) 저장 -> 반환 받은 DispatcherServlet이 request에 저장 
		mav.addObject("searchCount", boardList.size());        // 키값 같다면 덮어씀 
		mav.setViewName("getBoardList");    // jsp 화면으로 포워딩 됐을때 request에 등록된 정보를 EL( ${} ) 으로 뿌림 (view) 
		return mav;
		
		
		// 화면이동 (내가 만든 Controller 사용)
//		request.setAttribute("boardList", boardList);    // 반환 받은 글목록(검색결과) request에 담고 
//		return "/WEB-INF/board/getBoardList.jsp";                       // 문자열 리턴 (DispatcherServlet 으로) 
		// 브라우저 아닌 서버 안에서 컨트롤러가 WEB-INF 밑 jsp로 접근 하는 것은 가능

	}

}
