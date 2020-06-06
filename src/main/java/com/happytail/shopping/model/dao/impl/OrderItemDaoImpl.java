package com.happytail.shopping.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.shopping.model.OrderItemBean;
@Repository
public class OrderItemDaoImpl {
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderItemDaoImpl() {
	}
	
	public Session s() {
		
		return sessionFactory.getCurrentSession();
	}
	/*
	 * 計算客戶欲購買之某項商品(以OrderItemBean物件oib來表示)的小計金額(subtotal)， 
	 * 計算公式為: 商品的數量 * 商品的單價  * 商品的折扣
	 */
	public double findItemAmount(OrderItemBean oib) {
		double subtotal = oib.getQuantity() * oib.getUnitPrice() * oib.getDiscount();
		return subtotal;
	}
	
	public void insert(OrderItemBean oib) {
		s().save(oib);
	}
	
	
	
}
