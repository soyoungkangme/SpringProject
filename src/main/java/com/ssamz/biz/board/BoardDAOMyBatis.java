package com.ssamz.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;


public class BoardDAOMyBatis implements BoardDAO {   
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 insertBoard() 기능 메서드 처리");  
		mybatis.insert("BoardDAO.insertBoard", vo);    // 여러개의 sqlMapping.xml 에서 중복되는 id는 namespace로 구별 (namespace.id) 
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 updateBoard() 기능 메서드 처리");
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 deleteBoard() 기능 메서드 처리");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> MyBatis 기반으로 getBoard() 기능 메서드 처리");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);  
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> iBATIS 기반으로 getBoardList() 기능 메서드 처리");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}


// queryForObject -> selectOne
// queryForList -> selectList 


