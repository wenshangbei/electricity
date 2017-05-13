package com.wen.electric.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name="USER")
@Entity
public class User {

	@GeneratedValue
	@Id
	private Integer id;
	
	private String username;
	
	private String password;
	
	private String realName;
	
	private Gender gender;
	
	private String phoneNum;
	
	private String email;
	
	private  UserState state;
	
	private int locked = 1;
	
	private byte[] credentialsSalt;
	
	private String salt;
	
	@OneToMany(targetEntity=Role.class)
	private List<Role> roles;
	
	private String companyName;
	
	//余额
	private BigDecimal balance;
	
	//冻结资金
	private BigDecimal frezenAssets;
	
	
	

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getFrezenAssets() {
		return frezenAssets;
	}

	public void setFrezenAssets(BigDecimal frezenAssets) {
		this.frezenAssets = frezenAssets;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSalt() {
		return salt;
	}

	public void setCredentialsSalt(byte[] credentialsSalt) {
		this.credentialsSalt = credentialsSalt;
	}

	public int getLocked() {
		return locked;
	}

	public void setLocked(int locked) {
		this.locked = locked;
	}

	
	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public User() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}
	
	


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", realName=" + realName
				+ ", gender=" + gender + ", phoneNum=" + phoneNum + ", email=" + email + ", state=" + state + "]";
	}

	public User(Integer id, String username, String password, String realName, Gender gender, String phoneNum,
			String email, UserState state) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.email = email;
		this.state = state;
	}

	public byte[] getCredentialsSalt() {
		return credentialsSalt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}



	
	
	
}
