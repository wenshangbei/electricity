package com.wen.electric.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wen.electric.entity.Object;
import com.wen.electric.entity.TradingStatus;
import com.wen.electric.entity.Trade;
import com.wen.electric.entity.TradeStatus;
import com.wen.electric.entity.User;
import com.wen.electric.repository.TradeRepository;
import com.wen.electric.service.ObjectManagerService;
import com.wen.electric.service.UserManagerService;

@Controller
public class BuyDetailController {
	
	@Autowired
	private ObjectManagerService objectManagerService;
	
	@Autowired
	private TradeRepository tradeRepository;
	@Autowired
	private UserManagerService userManagerService;
	
	@RequestMapping("/front/buyDetail")
	public String index(String id,Map<String,Object> map){
		
		Object object = objectManagerService.getObjectDetail(id);
		map.put("object",object);
		return "/front/buyDetail";
	}
	
	@ResponseBody
	@RequestMapping("/front/createTrade")
	public String reateTrade(String objectId,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Object object = objectManagerService.getObjectDetail(objectId);
		
		if(user.getId() == object.getUser().getId()){
			return "不能购买自己发布的标的！！！";
		}
		object.setTradingStatus(TradingStatus.traded);
		Trade trade = new Trade();
		trade.setaUser(object.getUser());
		trade.setbUser(user);
		trade.setObject(object);
		userManagerService.changeBalanceToFreezenByUsername(user.getUsername());
		String string = String.valueOf(System.currentTimeMillis());
		String  tradeNum="JBT"+string.substring(string.length()-6, string.length()) ;
		trade.setTradeNum(tradeNum );
		trade.setCreateTime(new Date());
		trade.setTradeStatus(TradeStatus.unEnd);
		
		Trade trade2 = tradeRepository.save(trade);
		if (trade2 != null){
			return "true";
		}else{
			
			return "false";
		}
		
	}
}
