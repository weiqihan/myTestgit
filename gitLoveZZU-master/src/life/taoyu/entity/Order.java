package life.taoyu.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import persionalCenter.entity.User;

@Component(value = "order")
public class Order {// ��Ķ���ʵ����

	private Integer order_id;// ��ID
	private String order_status;// ����״̬
	private String order_date;// ��������
	private String address;// ��ҵ�ַ
	private String name;// �������
	private String phone;// ����ֻ���
	private String buyerOrseller;// ��������һ������ҵ�
	private User user;
	// ��UO_id ���ά�������û���
	
	private Set<OrderItems> setorderitems=new HashSet<OrderItems>();//ʹ��set���ϱ�ʾOrderItems��
	
	public Set<OrderItems> getSetorderitems() {
		return setorderitems;
	}
	public void setSetorderitems(Set<OrderItems> setorderitems) {
		this.setorderitems = setorderitems;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBuyerOrseller() {
		return buyerOrseller;
	}
	public void setBuyerOrseller(String buyerOrseller) {
		this.buyerOrseller = buyerOrseller;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_status=" + order_status + ", order_date=" + order_date
				+ ", address=" + address + ", name=" + name + ", phone=" + phone + ", buyerOrseller=" + buyerOrseller
				+ "]";
	}
}
