package com.wen.electric.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wen.electric.entity.Object;
import com.wen.electric.entity.Trade;
import com.wen.electric.entity.TradeStatus;
import com.wen.electric.entity.User;
import com.wen.electric.repository.TradeRepository;

@Service
public class TradeServie {

	@Autowired
	private TradeRepository tradeRepository;
	
	public List<Trade> getTradeByUser(User user){
		
		return tradeRepository.findByAUser(user);
	}
	
	public List<Trade> getTradeByBUser(User user){
		
		return tradeRepository.findByBUser(user);
	}

	/**
	 * 完成交易
	 * @param tradeId
	 * @return
	 */
	@Transactional
	public String finsihTrade(Integer tradeId) {

		Trade trade = tradeRepository.findById(tradeId);
		Object object = trade.getObject();
		BigDecimal electQuantity = object.getElectQuantity();
		BigDecimal price = object.getPrice();
		BigDecimal sum = electQuantity.multiply(electQuantity);
		User aUser = trade.getaUser();
		User bUser = trade.getbUser();
		
		if(bUser.getBalance().compareTo(sum) == -1){
			return "not enough";
		}else{
			
			bUser.setBalance(bUser.getBalance().subtract(sum).add(BigDecimal.valueOf(2000)));
			aUser.setBalance(aUser.getBalance().add(sum).add(BigDecimal.valueOf(2000)));
			bUser.setBalance(bUser.getFrezenAssets().subtract(BigDecimal.valueOf(2000)));
			aUser.setBalance(aUser.getFrezenAssets().subtract(BigDecimal.valueOf(2000)));
			trade.setTradeStatus(TradeStatus.end);
			return "true";
			
		}
		
	}
	
}
