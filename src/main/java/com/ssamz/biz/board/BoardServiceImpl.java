package com.ssamz.biz.board;
// new, interface add, BoardService 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



// 빈등록 대신 
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	// 의존하는 객체 boardDAO notNullPointException 위해 Annotation/생성자인젝션/세터인젝션 
	@Autowired
	private BoardDAO boardDAO;
	// BoardDAO 또는 BoardDAOSpring (디비연동 JDBC/SPring) => 자바소스 수정없이 변경하기 => 다형성(인터페이스, 상속) 
	
	// 언제 메모리에 객체 생성되는지 확인 
	public BoardServiceImpl() {
		System.out.println("===>BoardServiceImpl 생성");
	}
	
	
	// 트랜잭션 관리해야 하는 비즈니스 메서드 
	// => 내부의 두 메서드가 모두 실행되면 commit, 두 메서드 중 하나가 실행안되면 rollback 
//	public void 계좌이체() {
//		신한은행에서인출한다();
//		우리은행에입금한다();
//	}
//	private void 우리은행에입금한다() {
//		System.out.println("우리은행에입금한다");
//	}
//	public void 신한은행에서인출한다() {
//		System.out.println("신한은행에서인출한다");
//	}
 
	
	public void insertBoard(BoardVO vo) {
		// System.out.println("[사전처리] 핵심 비즈니스 로직 수행 전 동작"); 이나 
		// LogAdvice log = new LogAdvice();
		// log.printLog(); 를 모든 메서드에 추가하는 대신 AOP 
		
//		if(vo.getSeq() == 0) {
//			throw new IllegalArgumentException();
//		}
		// 0번글 등록하지 못하도록 
		// throw는 하나의 예외 객체 강제로 발생시켜서 던질때, throws 는 메서드 이름 옆에
		// 예외 발생한 줄에서 프로세스 중단하여 다음 코드는 실행되지 않음 
		// 프로세스가 비정상적으로 종료 했으므로 XML에 AOP 설정 
		
		boardDAO.insertBoard(vo);   // 핵심 관심 코드 
		boardDAO.insertBoard(vo);
		// seq 는 primary key 이므로 두번째 insert 에러  
		// 분리 될 수 없는 작업 단위 (이체=출금+입금) 
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
