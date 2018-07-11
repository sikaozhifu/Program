package com.hello.service;

import com.hello.entry.User;

public interface UserService {

	// 根据Id查询用户信息
	public User getUserById(Integer id);

	// 增加一条记录
	public void insertUser(User user);
}
