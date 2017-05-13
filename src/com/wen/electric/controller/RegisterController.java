package com.wen.electric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.electric.entity.User;
import com.wen.electric.repository.UserRepository;
import com.wen.electric.service.RegisterService;

@Controller
public class RegisterController {

	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * 检验是否存在该用户名
	 * @param username
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/register/existUsername")
	public String existUsername(String username){
	
		if (registerService.existUsername(username)) {
			return "true";
		}else {
			return "false";
		}
	
	}
	
	@ResponseBody
	@RequestMapping(value="/register/regist")
	public String regist(User user){
		
		if (registerService.regist(user)) {
			
			return "true";
		}else {
			return "false";
		}
		
	}
}
