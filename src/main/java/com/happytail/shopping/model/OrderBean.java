package com.happytail.shopping.model;


import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Component
@Table(name="Orders")
public class OrderBean {
	private Integer orderId;
	private Integer memberId;
	private Double totalPrice;//總金額  之後要改名字  沒改好
	private String shippingAddress;
	private String orderDate;
	private String text;
	private String state ;	//訂單狀態 //用來放入此訂單屬於哪個會員    

//	private Set<OrderItemBean> orderItemBean = new HashSet<OrderItemBean>(); //用來存放訂單集合
	
	
	public OrderBean() {
		
	}
	
	
	
//	public OrderBean( Integer memberId, Double totalPrice, String shippingAddress, String orderDate,
//			Set<OrderItemBean> orderItemBean ,String text,String state) {
	public OrderBean( Integer memberId, Double totalPrice, String shippingAddress, String orderDate,String text,String state) {
		
		
		this.memberId = memberId;
		this.totalPrice = totalPrice;
		this.shippingAddress = shippingAddress;
		this.orderDate = orderDate;
//		this.orderItemBean = orderItemBean;
		this.state=state;
		this.text=text;
	}
	
	



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Column(name = "memberId")
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	@Column(name = "totalPrice")
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Column(name = "shippingAddress")
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	@Column(name = "orderDate")
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Column(name = "state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
////	@OneToMany(cascade = { CascadeType.ALL },mappedBy="orderBean")
//	@OneToMany(cascade = { CascadeType.ALL })
////	@JoinColumn
//	public Set<OrderItemBean> getOrderItemBean() {
//		return orderItemBean;
//	}
//	
//	public void setOrderItemBean(Set<OrderItemBean> orderItemBean) {
//		this.orderItemBean = orderItemBean;
//	}
	@Column(name = "text")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
//	public void  setOrderDetailBean(OrderDetailBean orderDetailBean) {
//		
//		this.orderDetailBean=orderDetailBean;
//		}
//		
//	
//	@Transient
//	public OrderDetailBean getOrderDetailBean() {
//		return this.orderDetailBean;
//	}
	
}
