package com.wen.electric.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wen.electric.entity.User;
import com.wen.electric.utils.PasswordHelper;

public class TestShiro {

	@Test
	public void test1() throws Exception {
		PasswordHelper passwordHelper = new PasswordHelper();
		User user = new User();
		user.setUsername("abc");
		user.setPassword("abc");
		passwordHelper.encryptPassword(user);
		System.out.println(user);
		
	}
}
