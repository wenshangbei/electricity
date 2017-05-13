package com.wen.electric.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wen.electric.entity.Trade;
import com.wen.electric.entity.User;

public interface TradeRepository extends JpaRepository<Trade, Integer>{

	List<Trade> findByAUser(User user);
	
	List<Trade> findByBUser(User user);
	
	Trade findById(Integer id);
}
