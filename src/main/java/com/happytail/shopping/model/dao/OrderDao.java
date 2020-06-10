package com.happytail.shopping.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.OrderItemBean;



public interface OrderDao {

	Session getSession();

	Session s();

	// 查詢訂單 利用訂單編號OrderId
	OrderBean selectOrder(int orderId);

	//查詢所有訂單
	List<OrderBean> selectAllOrder();

	//查詢訂單 依照單一時間
	List<OrderBean> selectOrderByTime(String time);

	// 取消訂單
	String cancel(int orderId);

	// 更新訂單狀態→完成
	String complete(int orderId);

	// 更新訂單狀態→逾時
	String overtime(int orderId);



	//取得訂單總數
	long selectOrderByCount(Integer memberId);

	List<OrderBean> getAllOrderJson();

	String insert(OrderBean ob);
	//會員查詢自己的訂單
	List<OrderBean> selectOrderByMemberId(Integer memberId);

	List<OrderItemBean> getOrderItemBean(OrderBean orderBean);

	List<OrderItemBean> getOib(Integer mId, Integer oId);

	List<OrderItemBean> getOibNew(Integer mId, Integer oId);

	List<OrderItemBean> getOibOld(Integer mId, Integer oId);

	List<OrderBean> selectOrderByMemberIdNew(Integer Id);

	List<OrderBean> selectOrderByMemberIdOld(Integer Id);

	String payMoney(int orderId);

}