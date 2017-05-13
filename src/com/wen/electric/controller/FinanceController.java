package com.wen.electric.controller;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.electric.entity.User;
import com.wen.electric.service.UserManagerService;

@Controller
public class FinanceController {

	@Autowired
	private UserManagerService userManagerService;
	
	@RequestMapping("/front/finance")
	public String index(Map<String, Object> map,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		User user2 = userManagerService.findByUsername(user.getUsername());
		BigDecimal frezenAssets = user2.getFrezenAssets();
		if(frezenAssets == null){
			frezenAssets = BigDecimal.ZERO;
		}
		map.put("balance", user2.getBalance());
		map.put("frezenAssets", frezenAssets);
		
		return "/front/finance";
	}
	
	
	@ResponseBody
	@RequestMapping("/front/recharge")
	public String recharge(String sum,HttpServletRequest request){
		try {
			User user = (User) request.getSession().getAttribute("user");
			userManagerService.recharge(sum, user);
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		
		return "true";
	}


	
}
