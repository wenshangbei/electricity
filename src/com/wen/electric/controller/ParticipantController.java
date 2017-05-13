package com.wen.electric.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.electric.entity.Object;
import com.wen.electric.entity.Trade;
import com.wen.electric.entity.User;
import com.wen.electric.service.ObjectManagerService;
import com.wen.electric.service.TradeServie;

@Controller
public class ParticipantController {

	@RequestMapping("/front/participant")
	public String index(){
		return "/front/participant";
	}
	@Autowired
	private ObjectManagerService objectManagerService;
	@Autowired
	private TradeServie tradeServie;
	
	
	@ResponseBody
	@RequestMapping("/front/partiPublishList")
	public List<Object> myPublishList(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Trade> tradeByUser = tradeServie.getTradeByBUser(user);
		List<Object> objects = new ArrayList<>();
		for (Trade trade : tradeByUser) {
			objects.add(trade.getObject());
		}
		
		return objects;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/front/patiTradeList")
	public List<Trade> myTradeList(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Trade> tradeByUser = tradeServie.getTradeByBUser(user);
		
		return tradeByUser;
	}
	
	@ResponseBody
	@RequestMapping(value="/front/finishTrade")
	public String finishTrade(Integer tradeId){
		
		
		return tradeServie.finsihTrade(tradeId);
	}
}
