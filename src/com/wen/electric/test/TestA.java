package com.wen.electric.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wen.electric.entity.User;
import com.wen.electric.repository.UserRepository;
import com.wen.electric.service.UserManagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestA {

	@Autowired
	private UserManagerService userManangerService;
	@Autowired
	private UserRepository userDao;
	
	@Test
	public void testname() throws Exception {
		userManangerService.getUserListPage(0, 10);
	}
	
	
	@Test
	public void testFindbyname() throws Exception {
		userManangerService.findByUsername("admin");
	}
	
	@Test
	public void testDelete() {
		
		List<User> users = new ArrayList<>();
		User e = userDao.getByUsername("131110052");
		users.add(e);
		userManangerService.deleteUser(users );
	}
}
