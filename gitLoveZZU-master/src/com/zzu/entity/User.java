package com.zzu.entity;

import java.util.HashSet;

import java.util.Set;

import org.springframework.stereotype.Service;



@Service(value="user")
public class User {

	//�û�����
	private Integer uid;
	private String phone;
	private String password;
	private String verification_code; //��֤��
	
	private Set<UserInfo> setuserinfo=new HashSet<UserInfo>();//ʹ��set���ϱ�ʾUserInfo
	 

	public Set<UserInfo> getSetuserinfo() {
		return setuserinfo;
	}
	public void setSetuserinfo(Set<UserInfo> setuserinfo) {
		this.setuserinfo = setuserinfo;
	}
	public String getVerification_code() {
		return verification_code;
	}
	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pssword) {
		this.password = pssword;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User[phone:"+phone+",password:"+password+"]";
	}
	
}
