package com.intellect.user.mgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.user.mgmt.dao.UserDao;
import com.intellect.user.mgmt.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean create(User user) {

		// TODO: validations should be included here.
		return userDao.createUser(user);
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public boolean delete(User user) {

		return userDao.deleteUser(user);
	}

}
