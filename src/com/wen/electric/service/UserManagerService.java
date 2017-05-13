package com.wen.electric.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.wen.electric.entity.Permission;
import com.wen.electric.entity.Role;
import com.wen.electric.entity.User;
import com.wen.electric.repository.RoleRepository;
import com.wen.electric.repository.UserRepository;



@Service
public class UserManagerService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	/**
	 * 获取所有users
	 * @return
	 */
	public List<User> getUerList(){
		List<User> users = userRepository.findAll();
		for (User user : users) {
			user.setPassword(null);
		}
		return users;
		
	}
	
	/**
	 * 分页获取users
	 * @param offset
	 * @param limit
	 * @return
	 */
	public Map<String, Object> getUserListPage(int offset,int limit) {
		
		HashMap<String, Object> result = new HashMap<>();
		
		
		int pageNum = offset/limit;
		
		Pageable page = new PageRequest(pageNum, limit);
		Page<User> users = userRepository.findAll(page);
		
		result.put("total", userRepository.count());
		result.put("rows", users.getContent());
		
		return result;
	}
	
	@Transactional
	public boolean deleteUser(@RequestBody List<User> users) {
		
		
		try {
			userRepository.delete(users);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	@Transactional
	public boolean updateUser(User user){
		
		try {
			String realName = user.getRealName();
			User one = userRepository.findOne(user.getId());
			one.setEmail(user.getEmail());
			one.setGender(user.getGender());
			one.setPhoneNum(user.getPhoneNum());
			one.setRealName(user.getRealName());
			one.setRoles(user.getRoles());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
		
			return true;
		
	}

	public List<Role> findRoles(String username) {
		
		return userRepository.getByUsername(username).getRoles();
	}

	public User findByUsername(String username) {
		
		System.out.println();
		return userRepository.getByUsername(username);
	}

	public List<Permission> findPermissions(String username) {
		List<Role> roles = userRepository.getByUsername(username).getRoles();
		List<Permission> permissions = new ArrayList<>();
		for (Role role : roles) {
			List<Permission> permissions2 = role.getPermissions();
			if (permissions2 != null && permissions2.size() > 0) {
				permissions.addAll(permissions2);
			}
		}

		return permissions;
	}
	
	@Transactional
	public User changeBalanceToFreezenByUsername(String username){
		User user = userRepository.getByUsername(username);
		BigDecimal balance = user.getBalance();
		BigDecimal frezenAssets = user.getFrezenAssets();
		user.setBalance(balance.subtract(BigDecimal.valueOf(2000)));
		if(frezenAssets == null){
			user.setFrezenAssets(BigDecimal.valueOf(2000));
		}else{
			
			user.setFrezenAssets(frezenAssets.add(BigDecimal.valueOf(2000)));
			
		}
		return user;
		
	}
	
	@Transactional
	public void recharge(String sum, User user) {
		User user2 = userRepository.getByUsername(user.getUsername());
		BigDecimal balance = user2.getBalance();
		user2.setBalance(balance.add(BigDecimal.valueOf(Double.valueOf(sum))));
	}
	
	
	
}
