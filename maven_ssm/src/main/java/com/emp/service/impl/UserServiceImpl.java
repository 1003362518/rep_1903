package com.emp.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.emp.dao.UserDao;
import com.emp.entity.User;
import com.emp.service.UserService;

@Service
public class UserServiceImpl implements UserService {


	@Resource
	private UserDao userDao;
	public User getByUserName(String username) {
		return userDao.getByUserName(username);
	}
 
	public Set<String> getRoles(String username) {
		return userDao.getRoles(username);
	}
 
	public Set<String> getPermissions(String username) {
		return userDao.getPermissions(username);
	}

}
