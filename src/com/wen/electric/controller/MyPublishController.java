package com.wen.electric.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.electric.entity.Object;
import com.wen.electric.entity.Role;
import com.wen.electric.entity.Trade;
import com.wen.electric.entity.User;
import com.wen.electric.repository.TradeRepository;
import com.wen.electric.service.ObjectManagerService;
import com.wen.electric.service.TradeServie;

@Controller
public class MyPublishController {

	@Autowired
	private ObjectManagerService objectManagerService;
	@Autowired
	private TradeServie tradeServie;
	
	
	@RequestMapping("/front/myPublish")
	public String index(){
		return "front/myPublish";
	}
	
	@ResponseBody
	@RequestMapping("/front/myPublishList")
	public List<Object> myPublishList(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		return objectManagerService.getObjectListByUser(user);
	}
	
	@ResponseBody
	@RequestMapping(value="/front/deletePublishs")
	public String deletePublishs(@RequestBody 	List<Object>  publishs) {
		return String.valueOf(objectManagerService.deleteObjects(publishs));
	}
	
	@ResponseBody
	@RequestMapping(value="/front/myTradeList")
	public List<Trade> myTradeList(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Trade> tradeByUser = tradeServie.getTradeByUser(user);
		
		return tradeByUser;
	}
}
