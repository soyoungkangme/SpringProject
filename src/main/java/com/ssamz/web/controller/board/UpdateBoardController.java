package com.ssamz.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssamz.biz.board.BoardDAOJDBC;
import com.ssamz.biz.board.BoardVO;

@Controller
public class UpdateBoardController {

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAOJDBC boardDAO) { 
		
		/*
		System.out.println("글 수정 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String title = request.getParameter("title");
		String seq = request.getParameter("seq");
		String content = request.getParameter("content");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setSeq(Integer.parseInt(seq));
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAOJDBC();     // BoardDAO 가 인터페이스 이기 때문에 객체 생성하려면 인터페이스를 구현한 객체 생성해야함 
		boardDAO.updateBoard(vo);
		
		// 3. 페이지 네비게이션
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:getBoardList.do");
		return mav;
		*/
		
		boardDAO.updateBoard(vo);
		return "forward:getBoardList.do";

	}

}
