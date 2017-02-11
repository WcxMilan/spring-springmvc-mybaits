package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.domain.User;
import com.ssm.domain.UserCondition;
import com.ssm.mapper.UserMapper;
import com.ssm.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> getUserList() {
		
		return userMapper.getUserList();
	}
	@Override
	public void insert(User user) {
		userMapper.insert(user);
		
	}
	@Override
	public void delete(int userId) {
		userMapper.delete(userId);	
	}
	@Override
	public void update(User user) {
		userMapper.update(user);
		
	}
	@Override
	public User getById(int userId) {
		return userMapper.getById(userId);
	}
	@Override
	public List<User> findUser(UserCondition usercondition) {
		
		return userMapper.findUser(usercondition);
	}
	

	
}
