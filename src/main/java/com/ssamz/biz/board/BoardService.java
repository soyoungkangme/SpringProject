package com.ssamz.biz.board;

import java.util.List;


public interface BoardService {

	void insertBoard(BoardVO vo);
	void updateBoard(BoardVO vo);
	void deleteBoard(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	List<BoardVO> getBoardList(BoardVO vo);

}

// 비즈니스 컴포넌트의 클라이언트인 Controller에게 제공하는 다형성 리모컨 