package com.wen.electric.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wen.electric.entity.Role;
import com.wen.electric.entity.User;
import com.wen.electric.service.LoginService;
import com.wen.electric.service.UserManagerService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserManagerService userService;
	
	@RequestMapping(value="/login")
	public ModelAndView FrontLogin(String username,String password) {
		
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("message", "password error!");
            return mv;
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("message", "username error!");
            return mv;
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("message", "times error");
            return mv;
        }
        User user = userService.findByUsername(username);
        User userSession = new User();
        userSession.setId(user.getId());
        userSession.setRealName(user.getRealName());
        userSession.setUsername(user.getUsername());
        subject.getSession().setAttribute("user", userSession);
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
			if("manager".equals(role.getRoleName()) ||"superManager".equals(role.getRoleName())){
				  return new ModelAndView("redirect:back/index");
			}
		}
        return new ModelAndView("redirect:front/index");
		
	}
	


}
