package com.ssamz.biz.board;

import java.util.List;


public interface BoardService {

	// CRUD 기능의 메소드
	// 글 등록
	void insertBoard(BoardVO vo);

	// 글 수정
	void updateBoard(BoardVO vo);

	// 글 삭제
	void deleteBoard(BoardVO vo);

	// 글 상세 조회
	BoardVO getBoard(BoardVO vo);

	// 글 목록 검색
	List<BoardVO> getBoardList(BoardVO vo);

}