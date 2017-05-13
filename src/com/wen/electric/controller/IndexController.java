package com.wen.electric.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.electric.entity.Object;
import com.wen.electric.entity.User;
import com.wen.electric.service.ObjectManagerService;
import com.wen.electric.service.UserManagerService;

@Controller
public class IndexController {

	@Autowired
	private ObjectManagerService objectManagerService;
	
	
	@Autowired
	private UserManagerService userManagerService;
	@RequestMapping(value="/front/index")
	public String index() {
		
		
		return "/front/index";
	}
	@RequestMapping(value="/back/index")
	public String backIndex() {
		
		
		return "/back/indexBack";
	}
	
	@ResponseBody
	@RequestMapping("/front/publishObject")
	public String publishObject(HttpServletRequest request,Object object){
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String username = user.getUsername();
		String string = String.valueOf(System.currentTimeMillis());
		String objectNum ="JB"+string.substring(string.length()-6, string.length()) ;
		object.setObjectNum(objectNum);
		User user2 = userManagerService.changeBalanceToFreezenByUsername(username);
		object.setUser(user2);
		object.setCreateTime(new Date());
		
		
		return String.valueOf(objectManagerService.publish(object));
	}
	
	@ResponseBody
	@RequestMapping("/front/getObjectList")
	public List<Object> getObjectList() {
		
		List<Object> objectList = objectManagerService.getObjectList();
		for (Object object : objectList) {
			object.getUser().setPassword(null);
			object.getUser().setSalt(null);
		}
		return objectList;
	}
	
	@ResponseBody
	@RequestMapping("/front/getCurrentUserInfo")
	public User getCurrentUserInfo(HttpServletRequest reqiest){
		User attribute = (User)reqiest.getSession().getAttribute("user");
		return attribute;
	}
	
	
	
}
