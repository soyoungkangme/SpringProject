package com.ssamz.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

//alt+shift+t, extract interface (BoardService), select all, implement 지우기 


// @Repository  // 빈등록 대신 
public class BoardDAOSpring implements BoardDAO { 
	
	@Autowired   // 변수 할당, notNullPointException, 생성=빈등록 
	private JdbcTemplate spring;
	
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) "
			                          + "values(?, ?, ?, ?)";
	//(select nvl(max(seq), 0) + 1 from board) -> seq 컬럼 값 자동으로 1씩 증가 (첫번째 물음표), 물음표 = 클라이언트가 입력한 
	private final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private final String BOARD_DELETE = "delete board where seq = ?";
	private final String BOARD_LIST_T = "select * from board where title   like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
	private final String BOARD_GET    = "select * from board where seq = ?";
	
	
//	// 언제 메모리에 객체 생성되는지 확인  
//	public BoardDAO() {
//		System.out.println("===>BoardDAO 생성");
//	}
	

	public void insertBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 insertBoard() 기능 메서드 처리");
		spring.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
		// 매개변수 = SQL문, 물음표 
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 updateBoard() 기능 메서드 처리");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 deleteBoard() 기능 메서드 처리");

		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 getBoard() 기능 메서드 처리");
		return spring.queryForObject(BOARD_GET, new BoardRowMapper(), vo.getSeq());
		// 하나 조회는 queryForObject, 목록 조회는 query 
		// queryForObject(SQL문, new BoardRowMapper(), 물음표,..)
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> SPRING 기반으로 getBoardList() 기능 메서드 처리");
		if(vo.getSearchCondition().equals("TITLE")) {
			return spring.query(BOARD_LIST_T, new BoardRowMapper(), vo.getSearchKeyword());   // 제목 검색 
		} else if(vo.getSearchCondition().equals("CONTENT")) { 
			return spring.query(BOARD_LIST_C, new BoardRowMapper(), vo.getSearchKeyword());   // 내용 검색 
		}
		return null;
		// .query(SQL, 매핑, 물음표) : JDBCTemplate아 목록 가져와 
		// ResultSet : row 1개 = 검색결과 1개 (각 컬럼값), 각 row에 rowNumber 할당됨, 맨위/아래에 데이터 없는 BeforeFirst/AfterLast,  
		//             최초의 커서는 BeforeFirst, rs.next() 마다 아래로 내려가서 데이터 있으면 true/없으면 false 
		// BoardRowMapper : row의 각 컬럼 값을 어떤 VO 객체 변수에 매핑할 것인지 알려줌 (JDBC 는 re.next()로 일일히 매핑했음)
	}
}
