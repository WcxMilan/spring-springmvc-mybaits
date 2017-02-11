package com.ssm.mapper;

import java.util.List;

import com.ssm.domain.User;
import com.ssm.domain.UserCondition;

public interface UserMapper {
    //获取所有的信息
	public List<User> getUserList();
	//获取一条记录
	User getById(int userId);
    //增加
	void insert(User user);
	//删除
	void delete(int userId);
	//修改
	void update(User user);
	//查询
	List<User> findUser(UserCondition usercondition);
}
