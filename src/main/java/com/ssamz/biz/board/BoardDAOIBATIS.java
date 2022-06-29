package com.ssamz.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;


public class BoardDAOIBATIS implements BoardDAO {   // 타입인젝션 대신 extends SqlMapClientDaoSupport 가능하지만 공통의 부모 못가짐 
	
	@Autowired
	private SqlMapClientTemplate ibatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 insertBoard() 기능 메서드 처리");
		ibatis.insert("insertBoard", vo);   // SQL, 파라미터 객체 
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 updateBoard() 기능 메서드 처리");
		ibatis.update("updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 deleteBoard() 기능 메서드 처리");
		ibatis.delete("deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 getBoard() 기능 메서드 처리");
		return (BoardVO) ibatis.queryForObject("getBoard", vo);   // 명시적 형변환 
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 getBoardList() 기능 메서드 처리");
		return ibatis.queryForList("getBoardList", vo);
	}
}
