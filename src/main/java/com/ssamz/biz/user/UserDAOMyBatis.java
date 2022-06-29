package com.ssamz.biz.user;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOMyBatis implements UserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertUser(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 insertUser() 기능 메서드 처리");
		mybatis.insert("UserDAO.insertUser", vo);
	}
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 getUser() 기능 메서드 처리");
		return mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	public List<UserVO> getUserList() {
		System.out.println("===> MyBatis 기반으로 getUserList() 기능 메서드 처리"); 
		return new ArrayList<UserVO>();
	}
}
