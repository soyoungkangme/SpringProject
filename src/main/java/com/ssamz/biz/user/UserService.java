package com.ssamz.biz.user;

import java.util.List;


// UserDAO 에서 com+shift+t, extract interface 
public interface UserService {
	void insertUser(UserVO vo);
	UserVO getUser(UserVO vo);
	List<UserVO> getUserList();

}