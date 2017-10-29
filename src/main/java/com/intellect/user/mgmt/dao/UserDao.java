package com.intellect.user.mgmt.dao;

import com.intellect.user.mgmt.model.User;

public interface UserDao {

	public boolean createUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);

}
