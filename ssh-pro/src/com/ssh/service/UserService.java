package com.ssh.service;

import com.ssh.dao.UserDao;
import com.ssh.entities.User;
import com.ssh.exception.UsernameException;

public class UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void saveOrUpdate(User user) throws UsernameException{
		userDao.saveOrUpdate(user);
	}
	public boolean usernameIsValid(String name){
		return userDao.getUserByName(name)==null;
	}
}
