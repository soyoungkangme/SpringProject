package com.ssamz.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<BoardVO> {

	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// ResultSet(Board 테이블의 select 결)의 각 row에 어떤 VO 객체의 변수를 매핑할 것인지 기술 
		// 테이블 당 하나씩 필요한 클래스 
		
		// ResultSet의 데이터 수 만큼 자동 호출됨 
		// System.out.println(rowNum + " 번째 ROW를 BoardVO 객체에 매핑한다.");
		
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setContent(rs.getString("CONTENT"));
		board.setWriter(rs.getString("WRITER"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}
	
}