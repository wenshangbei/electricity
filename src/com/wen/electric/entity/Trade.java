package com.wen.electric.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="TRADE")
public class Trade {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String tradeNum;
	
	@OneToOne(targetEntity = Object.class)
	@JoinColumn(name="object_id")
	private Object object;
	
	//发布标的用户
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="a_user_id")
	private User aUser;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="b_user_id")
	private User bUser;
	
	private Date createTime;
	
	private TradeStatus tradeStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTradeNum() {
		return tradeNum;
	}

	public void setTradeNum(String tradeNum) {
		this.tradeNum = tradeNum;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public User getaUser() {
		return aUser;
	}

	public void setaUser(User aUser) {
		this.aUser = aUser;
	}

	public User getbUser() {
		return bUser;
	}

	public void setbUser(User bUser) {
		this.bUser = bUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public TradeStatus getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(TradeStatus tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	
	
}
