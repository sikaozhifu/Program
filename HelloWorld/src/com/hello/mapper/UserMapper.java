package com.hello.mapper;

import com.hello.entry.User;

public interface UserMapper {

	//根据Id查询用户信息
	public User getUserById(Integer id);
	//增加一条记录
	public void insertUser(User user);
}
