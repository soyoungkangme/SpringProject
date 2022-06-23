package com.ssamz.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// @Repository
public class UserDAOSpring implements UserDAO {
	
	@Autowired
	private JdbcTemplate spring;
	
	private final String USER_INSERT = "insert into users(id, password, name, role) values(?, ?, ?, ?)";
	private final String USER_LIST   = "select * from users order by id desc";
	private final String USER_GET    = "select * from users where id = ?";  

	public void insertUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 insertUser() 기능 메서드 처리");
	}
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING 기반으로 getUser() 기능 메서드 처리");
		return spring.queryForObject(USER_GET, new UserRowMapper(), vo.getId());
	}
	
	public List<UserVO> getUserList() {
		System.out.println("===> SPRING 기반으로 getUserList() 기능 메서드 처리"); 
		return spring.query(USER_LIST, new UserRowMapper());
	}
}
