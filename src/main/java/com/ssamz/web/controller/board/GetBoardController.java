package com.ssamz.web.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssamz.biz.board.BoardDAOJDBC;
import com.ssamz.biz.board.BoardVO;

@Controller
public class GetBoardController {

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAOJDBC boardDAO, ModelAndView mav) {
		
		/*
		System.out.println("글 상세 조회 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));     // 사용자가 클릭한 게시글을 
		
		BoardDAO boardDAO = new BoardDAOJDBC();
		BoardVO board = boardDAO.getBoard(vo);    // 디비에서 가져옴 
		
//		if(board != null) {                  // 검색 결과 있을 때만 조회수 증가 
//			boardDAO.updateBoardCnt(vo);
//		}
		// BoardDAOJDBC 의 getBoard() 에 기능 구현 
		
		// 3. 화면 이동
		// 검색 결과를 request에 등록하고 getBoardList.jsp로 이동(forwarding)한다. 
		// request.setAttribute("board", board);
		// return "/WEB-INF/board/getBoard.jsp";     // 브라우저 아닌 서버 안에서 컨트롤러가 WEB-INF 밑 jsp로 접근 하는 것은 가능
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard");
		return mav;
		*/
		
		
		mav.addObject("board", boardDAO.getBoard(vo));   // 검색결과 저장 
		mav.setViewName("getBoard");     // 뿌릴 화면 저장 
		return mav;
	}

}
