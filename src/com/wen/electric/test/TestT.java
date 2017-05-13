package com.wen.electric.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wen.electric.service.UserManagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestT {

	@Autowired
	UserManagerService userManangerService;
	
	
	@Test
	public void test1(){
		userManangerService.getUserListPage(0, 10);
	}
}
