package com.intellect.user.mgmt.service;

import com.intellect.user.mgmt.model.User;

public interface UserService {

	public boolean create(User user);

	public boolean update(User user);

	public boolean delete(User user);

}
