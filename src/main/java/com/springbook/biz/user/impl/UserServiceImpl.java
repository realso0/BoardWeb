package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVo;

@Service("userService")//객체 생성
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao; //의존성 주입
	
	/*public void setUserDao(UserDao userDao) { //setUserDao라는 setter메소드를 통해서 객체 생성, 1.UserDao 객체 생성, 2.UserServiceImpl 객체 생성
		System.out.println("===> userDao, userService 객체 생성");
		this.userDao=userDao;
	}*/
	
	public UserVo getUser(UserVo vo) {
		return userDao.getUser(vo);
	}
}
