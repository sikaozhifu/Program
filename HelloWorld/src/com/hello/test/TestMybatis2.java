package com.hello.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hello.entry.User;
import com.hello.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-config.xml"})
public class TestMybatis2 {

	private static Logger logger = Logger.getLogger(TestMybatis2.class);
	
	@Resource
	private UserService UserService;
	@Test
	public void test1() {
		
		User user = UserService.getUserById(1);
		
//		System.out.println(user);
		logger.info("user"+user);
	}
}
