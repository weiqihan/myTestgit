package persionalCenter.entity;

import java.util.HashSet;

import java.util.Set;

import org.springframework.stereotype.Service;

import life.taoyu.entity.Cart;
import life.taoyu.entity.Goods;
import life.taoyu.entity.Order;



@Service(value="User")
public class User {

	//�û�����
	private Integer uid;
	private String phone;
	private String password;
	private String account;
	private String verification_code; //��֤��
	private String SessionID;//���ID
	private String SessionIDDate;//���ID����

	

	private Set<UserInfo> setuserinfo=new HashSet<UserInfo>();//ʹ��set���ϱ�ʾUserInfo
	private Set<Goods> setgoods=new HashSet<Goods>();//ʹ��set���ϱ�ʾGoods��
	private Set<Order> setorder=new HashSet<Order>();//ʹ��set���ϱ�ʾOrder��
	private Set<Cart> setcart=new HashSet<Cart>();//ʹ��set���ϱ�ʾCart��

	
	public Set<Order> getSetorder() {
		return setorder;
	}
	public void setSetorder(Set<Order> setorder) {
		this.setorder = setorder;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getSessionIDDate() {
		return SessionIDDate;
	}
	public void setSessionIDDate(String sessionIDDate) {
		SessionIDDate = sessionIDDate;
	}
	
	


	public Set<Cart> getSetcart() {
		return setcart;
	}
	public void setSetcart(Set<Cart> setcart) {
		this.setcart = setcart;
	}
	public String getSessionID() {
		return SessionID;
	}
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}


	public Set<Goods> getSetgoods() {
		return setgoods;
	}
	public void setSetgoods(Set<Goods> setgoods) {
		this.setgoods = setgoods;
	}
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
