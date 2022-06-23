package com.ssamz.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssamz.biz.board.BoardDAOJDBC;
import com.ssamz.biz.board.BoardVO;

@Controller
public class DeleteBoardController {

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAOJDBC boardDAO) {
		
		/*
		System.out.println("글 삭제 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAOJDBC();
		boardDAO.deleteBoard(vo);
		
		// 3. 페이지 네비게이션
		ModelAndView mav = new ModelAndView();
		mav.addObject(seq, mav);
		mav.setViewName("forward:getBoardList.do");
		return mav;
		*/
		
		boardDAO.deleteBoard(vo);
		return "forward:getBoardList.do";
	}

}
