package com.ssamz.biz.board;

import java.sql.Date;

import lombok.Data;

@Data    // lombok : setter, getter, toString 등의 메서드 자동 제공 
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	
	// 검색 관련 멤버변수
	private String searchCondition;
	private String searchKeyword;
}
