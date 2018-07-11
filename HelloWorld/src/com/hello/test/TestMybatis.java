package com.hello.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hello.entry.User;
import com.hello.mapper.UserMapper;

public class TestMybatis {

	@Test
	public void testSelect() throws IOException {
//		String resource="spring-config.xml";
//		InputStream in = Resources.getResourceAsStream(resource);
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//		SqlSession session = factory.openSession();
		
//		User user = session.selectOne("com.hello.mapper.UserMapper.getUsers", 2);
//		System.out.println(user);
		
		
		//利用代理生成
		
		//查
//		UserMapper userMapper = session.getMapper(UserMapper.class);
//		User user = userMapper.getUserById(2);
//		System.out.println(user);
//		session.close();
		//增
//		UserMapper userMapper = session.getMapper(UserMapper.class);
//		User user = new User();
//		user.setName("");
//		userMapper.insertUser(user);
		
		
		//---------------------------------------------------
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		UserMapper userMapper = context.getBean("UserMapper", UserMapper.class);
		User user = userMapper.getUserById(2);
		System.out.println(user);
	}
}
