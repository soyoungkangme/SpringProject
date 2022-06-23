package com.ssamz.biz.user;
// new, interface add, BoardService 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// 빈등록 대신 
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired   // 의존하는 객체 boardDAO notNullPointException 위해 Annotation/생성자인젝션/세터인젝션 
	private UserDAO userDAO; 
	

	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}
	
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	public List<UserVO> getUserList() {
		return userDAO.getUserList();
	}


}
