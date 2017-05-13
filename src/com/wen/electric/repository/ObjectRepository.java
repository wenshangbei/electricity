package com.wen.electric.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wen.electric.entity.Object;
import com.wen.electric.entity.TradingStatus;
import com.wen.electric.entity.User;

public interface ObjectRepository extends JpaRepository<Object, Integer> {
	List<Object> findByUser(User user);
	Object findById(Integer id);
	List<Object> findByTradingStatus(TradingStatus tradingStatus,Sort sort);
}
