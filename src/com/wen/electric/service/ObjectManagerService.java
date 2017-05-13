package com.wen.electric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wen.electric.entity.Object;
import com.wen.electric.entity.TradingStatus;
import com.wen.electric.entity.User;
import com.wen.electric.repository.ObjectRepository;

@Service
public class ObjectManagerService {
	
	@Autowired
	private ObjectRepository objectRepository;
	
	@Transactional
	public boolean publish(Object object){
		
		Object save = objectRepository.save(object);
		
		if(save != null){
			return true;
		}else{
			return false;
		}
		
		
	}
	
	public List<Object> getObjectList() {
		Sort sort = new Sort(Direction.DESC, "createTime");
		TradingStatus tradingStatus = TradingStatus.untrade;
		return objectRepository.findByTradingStatus(tradingStatus ,sort);
	}

	public List<Object> getObjectListByUser(User user) {
		// TODO Auto-generated method stub
		return objectRepository.findByUser(user);
	}

	public boolean deleteObjects(List<Object> publishs) {
		try {
			objectRepository.delete(publishs);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Object getObjectDetail(String id){
		
		return objectRepository.findById(Integer.valueOf(id));
	}
	
}
