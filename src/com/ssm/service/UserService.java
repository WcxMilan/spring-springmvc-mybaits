package com.ssm.service;

import java.util.List;

import com.ssm.domain.User;
import com.ssm.domain.UserCondition;

public interface UserService {

	public List<User> getUserList();
	User getById(int userId);
	void insert(User user);
	void delete(int userId);
	void update(User user);
	List<User> findUser(UserCondition usercondition);
}
