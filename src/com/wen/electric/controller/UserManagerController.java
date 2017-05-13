package com.wen.electric.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.electric.entity.User;
import com.wen.electric.service.UserManagerService;

@Controller
public class UserManagerController {
	
	@Autowired
	private UserManagerService userManangerService;
	
	@RequestMapping("/back/userManager")
	public String index(){
		
		return "/back/userManager";
	}
	
	@ResponseBody
	@RequestMapping("/back/userList")
	public List<User> getUserList(){
	
		
		return userManangerService.getUerList();
	}
	
	@ResponseBody
	@RequestMapping(value="/back/deleteUsers")
	public String deleteUsers(@RequestBody 	List<User>  users) {
		
		return String.valueOf(userManangerService.deleteUser(users));
	}
	
	
	@ResponseBody
	@RequestMapping(value="/back/updateUser")
	public String updateuser(@RequestBody User user){
		
		return String.valueOf(userManangerService.updateUser(user));
	}
}
