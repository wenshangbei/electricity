package com.wen.electric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.electric.entity.Permission;
import com.wen.electric.entity.Role;
import com.wen.electric.entity.User;
import com.wen.electric.service.RoleManagerService;

@Controller
public class RoleManagerController {

	@Autowired
	private RoleManagerService roleManagerService;
	
	@RequestMapping("/back/roleManager")
	public String index(){
		
		return "/back/roleManager";
	}
	
	@ResponseBody
	@RequestMapping("/back/roleList")
	public List<Role> getRoles(){
		
		
		return roleManagerService.getRoles();
	}
	
	@ResponseBody
	@RequestMapping("/back/getPermissions")
	public List<Permission> getPermissions(){
		
		
		return roleManagerService.getAllPermissions();
	}
	
	@ResponseBody
	@RequestMapping(value="/back/updateRole")
	public String updateRole(@RequestBody Role role){
		
		return String.valueOf(roleManagerService.updateRole(role));
	}
}
