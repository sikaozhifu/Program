package com.hello.mapper;

import com.hello.entry.User;

public interface UserMapper {

	//����Id��ѯ�û���Ϣ
	public User getUserById(Integer id);
	//����һ����¼
	public void insertUser(User user);
}
