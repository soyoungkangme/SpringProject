package com.ssamz.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;


public class BoardServiceClient {

	public static void main(String[] args) {
		// 1. 스프링 컨테이너 생성 
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml"); 

		// 2. 테스트 객체 Lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		// BoardService boardService = new BoardServiceImpl(); 과 같은 결과 
		if(boardService != null) {
			System.out.println("Lookup 성공 : " + boardService.toString());
		}
		
		// 3. Lookup한 객체의 메소드 테스트 
		// 인자로 넘겨줄 객체 생성
		BoardVO vo = new BoardVO();
		
		vo.setSeq(1000);      // vo.setSeq(0); -> IllegalArgumentException 발생, insert 실행 안됨
		vo.setTitle("IoC 테스트");
		vo.setWriter("테스터");
		vo.setContent("IoC 기능 테스트중.............");
		boardService.insertBoard(vo);  
		// 트랜잭션 설정 이후 똑같이 insert 에러 나지만, 주석처리 후 select 해보면 한번도 insert 되지 않음 = 트랜잭션 작동 
		
		vo.setSearchCondition("TITLE");     // NullPointException 방지 
		vo.setSearchKeyword("");
		// 리스트 컬렉션 획득하기 
		List<BoardVO> boardList = boardService.getBoardList(vo);
		// 글목록 하나씩 뿌려주기 
		for (BoardVO board : boardList) {
			System.out.println("--->" + board.toString());
		}

		// 3. 컨테이너 종료 
		container.close();
	}

}
