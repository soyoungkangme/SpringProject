package com.ssamz.web.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssamz.biz.board.BoardService;
import com.ssamz.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired   // 메모리에 로딩된 객체 중에 찾아서 할당해라 
	private BoardService boardService;   // 비즈니스 컴포넌트의 클라이언트인 Controller에게 BoardDAOJDBC 아닌 BoardService 제공 (리모컨) 

	@RequestMapping("/insertBoardView.do")
	public String insertBoardView() {
		return "insertBoard";
	}

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {  
		boardService.insertBoard(vo);   
		return "forward:getBoardList.do";  
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);   
		return "forward:getBoardList.do";  
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);   
		return "forward:getBoardList.do";  
	}
	// 매개변수로 BoardVO vo = int seq = @RequestParam("seq") int boardSeq 
	// 메모리 상의 변화 크게 없음 
	
	/*
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAOJDBC boardDAO, ModelAndView mav) {
		mav.addObject("board", boardDAO.getBoard(vo));  
		mav.setViewName("getBoard");  
		return mav;
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAOJDBC boardDAO, ModelAndView mav) {   
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");

		mav.addObject("condition", vo.getSearchCondition());   
		mav.addObject("keyword", vo.getSearchKeyword());
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);  
		
		mav.addObject("boardList", boardList);                
		mav.addObject("searchCount", boardList.size());      
		mav.setViewName("getBoardList");   
		return mav;
	}
	*/
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {   
		model.addAttribute("board", boardService.getBoard(vo));   // Model도 request에 자동 저장됨 
		return "getBoard";  
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,  Model model) {   
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");

		model.addAttribute("condition", vo.getSearchCondition());   
		model.addAttribute("keyword", vo.getSearchKeyword());
		
		List<BoardVO> boardList = boardService.getBoardList(vo);  
		
		model.addAttribute("boardList", boardList);                
		model.addAttribute("searchCount", boardList.size());      
		return "getBoardList";
	}
	
}


// BoardController 제외한 모든 컨트롤러 삭제 
