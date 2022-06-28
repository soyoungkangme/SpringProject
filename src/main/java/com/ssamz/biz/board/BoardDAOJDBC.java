package com.ssamz.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssamz.biz.common.JDBCUtil;

// @Repository
public class BoardDAOJDBC implements BoardDAO {
	
	// JDBC 관련 변수
	private Connection conn;
	private PreparedStatement stmt;   
	private ResultSet rs;
	
	// SQL 명령어
	private final String BOARD_INSERT     = "insert into board(seq, title, writer, content) "
			                              + "values((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
	private final String BOARD_UPDATE     = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_UPDATE_CNT = "update board set cnt = cnt + 1 where seq = ?";     // 특정 게시글에 대해 조회수 증가 
	private final String BOARD_DELETE     = "delete board where seq = ?";
	private final String BOARD_LIST_T     = "select * from board where title   like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C     = "select * from board where content like '%'||?||'%' order by seq desc";
	private final String BOARD_GET        = "select * from board where seq = ?";

	public BoardDAOJDBC() {
		System.out.println("===> BoardDAO 생성");
	}
	
	// CRUD 기능의 메소드
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC 기반으로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC 기반으로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC 기반으로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
//	조회수 증가 기능은 다른데서 재사용 안되므로 이렇게 따로 메서드 구현하지 않음 
//	public void updateBoardCnt(int cnt) {
//		System.out.println("===> JDBC 기반으로 updateBoardCnt() 기능 처리");
//		try {
//			conn = JDBCUtil.getConnection();
//			stmt = conn.prepareStatement(BOARD_UPDATE_CNT);
//			stmt.setInt(1, cnt);
//			stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(stmt, conn);
//		}
//	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC 기반으로 getBoard() 기능 처리");
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();      // SQL 날리고 반환된 검색결과 result set에 저장 
			if(rs.next()) {				 
				
				// 검색 결과가 있을때만 조회수 증가 (rs.next() 가 true 일때만) 
				stmt = conn.prepareStatement(BOARD_UPDATE_CNT);       // select 결과 있을때 SQL 쿼리 실행 
				stmt.setInt(1, vo.getSeq());     // 물음표 채우기 
				stmt.executeUpdate();            // 실행 
				
			    // updateBoardCnt(vo.getSeq());     
				// 이렇게 안하고 메서드 따로 만들어도 되지만 이 기능은 다른데서 재사용 안되므로 이 메서드에만 기능 구현
				
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));          // rs 객체의 컬럼과 VO 객체의 변수 매핑  
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER"));
				board.setRegDate(rs.getDate("REGDATE")); 
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC 기반으로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			// VO 객체에 설정된 searchCondition(검색 조건)에 따라 검색 쿼리를 분기처리한다.
			if(vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BOARD_LIST_T);
			} else if(vo.getSearchCondition().equals("CONTENT")) {
				stmt = conn.prepareStatement(BOARD_LIST_C);
			}
			stmt.setString(1, vo.getSearchKeyword());
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}

}
