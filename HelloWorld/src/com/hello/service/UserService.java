package com.hello.service;

import com.hello.entry.User;

public interface UserService {

	// ����Id��ѯ�û���Ϣ
	public User getUserById(Integer id);

	// ����һ����¼
	public void insertUser(User user);
}
