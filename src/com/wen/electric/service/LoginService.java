package com.wen.electric.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wen.electric.entity.User;
import com.wen.electric.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean checkUser(String username,String password) {
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		
		Subject subject = SecurityUtils.getSubject();
		
		User user = userRepository.getByUsername(username);
		
		if (user != null && password.equals(user.getPassword())) {
			return true;
		}
		
		return false;
	}
}
