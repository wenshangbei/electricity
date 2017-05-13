package com.wen.electric.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.electric.entity.Role;
import com.wen.electric.entity.User;
import com.wen.electric.service.RoleManagerService;

@Controller
public class RoleController {
	
	@Autowired
	private RoleManagerService roleManagerService;
	
	
	@ResponseBody
	@RequestMapping("/back/getRoles")
	public List<Role> getRoles(){
		return roleManagerService.getRoles();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/back/deleteRoles")
	public String deleteRoles(@RequestBody 	List<Role>  roles) {
		return String.valueOf(roleManagerService.deleteRoles(roles));
	}
	
}
