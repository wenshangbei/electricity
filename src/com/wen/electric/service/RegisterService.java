package com.wen.electric.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wen.electric.entity.User;
import com.wen.electric.repository.UserRepository;
import com.wen.electric.utils.PasswordHelper;

@Service
public class RegisterService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 检验是否存在该用户
	 * @param username
	 * @return
	 */
	public boolean existUsername(String username){
		
		if(userRepository.getByUsername(username) != null){
			return true;
		}else {
			return false;
		}
	}
	
	@Transactional
	public boolean regist(User user) {
		
		PasswordHelper passwordHelper = new PasswordHelper();
		
		passwordHelper.encryptPassword(user);
		
		User user2 = userRepository.save(user);
		
		if (user2 != null && user2.getUsername() != null) {
			
			return true;
		}else {
			return false;
		}
		
	}
}
