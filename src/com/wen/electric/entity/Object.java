package com.wen.electric.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="OBJECT")
public class Object {

	@GeneratedValue
	@Id
	private Integer id;
	
	//电量
	private BigDecimal electQuantity;
	
	//单价
	private BigDecimal price;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id")
	private User user;
	
	//交易状态
	@Column(columnDefinition="tinyint default 0")
	private TradingStatus tradingStatus = TradingStatus.untrade;
	
	//编码
	private String objectNum;
	
	//创建时间
	private Date createTime;
	
	
	
	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getObjectNum() {
		return objectNum;
	}

	public void setObjectNum(String objectNum) {
		this.objectNum = objectNum;
	}

	public TradingStatus getTradingStatus() {
		return tradingStatus;
	}

	public void setTradingStatus(TradingStatus tradingStatus) {
		this.tradingStatus = tradingStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getElectQuantity() {
		return electQuantity;
	}

	public void setElectQuantity(BigDecimal electQuantity) {
		this.electQuantity = electQuantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
