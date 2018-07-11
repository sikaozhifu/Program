package com.hello.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hello.entry.User;
import com.hello.mapper.UserMapper;
import com.hello.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private  UserMapper userMapper;
	
	@Override
	public User getUserById(Integer id) {
		
		return userMapper.getUserById(id);
	}

	@Override
	public void insertUser(User user) {
		
		userMapper.insertUser(user);
	}

}
