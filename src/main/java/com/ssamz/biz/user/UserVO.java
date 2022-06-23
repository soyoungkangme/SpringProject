package com.ssamz.biz.user;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String password;
	private String name;
	private String role;

	// 검색 관련 멤버변수
	private String searchCondition;
	private String searchKeyword;
}

