package com.wen.electric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wen.electric.entity.Permission;
import com.wen.electric.entity.Role;
import com.wen.electric.entity.User;
import com.wen.electric.repository.PermissionRepository;
import com.wen.electric.repository.RoleRepository;

@Service
public class RoleManagerService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	public List<Role> getRoles(){
		
		return roleRepository.findAll();
	}

	public Boolean deleteRoles(List<Role> roles) {

		try {
			roleRepository.delete(roles);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Permission> getAllPermissions(){
		return permissionRepository.findAll();
	}

	@Transactional
	public boolean updateRole(Role role) {
		try {
			String roleName = role.getRoleName();
			Role one = roleRepository.findOne(role.getId());
			
			one.setRoleName(roleName);
			one.setPermissions(role.getPermissions());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
			return true;
	}
}
