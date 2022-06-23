package com.ssamz.biz.board;

import java.util.List;

public interface BoardDAO {

	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);

	
//	void updateBoardCnt(BoardVO vo); -> BoardDAOJDBC, BoardDAOSpring 에서 메서드 구현 (오버라이딩)     
// 	검색결과 있을때만 조회수 1증가 시키는 기능 -> getBoard.do 에서만 사용되는 기능 -> BoardDAOJDBC 의 getBoard()

}