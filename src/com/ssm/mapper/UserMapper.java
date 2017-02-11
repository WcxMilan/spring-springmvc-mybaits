package com.ssm.mapper;

import java.util.List;

import com.ssm.domain.User;
import com.ssm.domain.UserCondition;

public interface UserMapper {
    //��ȡ���е���Ϣ
	public List<User> getUserList();
	//��ȡһ����¼
	User getById(int userId);
    //����
	void insert(User user);
	//ɾ��
	void delete(int userId);
	//�޸�
	void update(User user);
	//��ѯ
	List<User> findUser(UserCondition usercondition);
}
