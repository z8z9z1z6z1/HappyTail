package com.happytail.admin.model;

import java.util.List;

import com.happytail.shopping.model.OrderBean;

public interface AdminShopDao {
	
	//商品總數
	public Long countProjects();
	//訂單總數
	public Long countOrders();
	//商品銷售金額
	public Double sumOrders();
	//商品類別數
	public Long countProjectType();
	//未處理訂單
	public Long unChickOrders();
	//每月銷售金額
	public List<Long> sumOrdersByMonth();
	
	//更改訂單
	OrderBean changeOrderStatus(Integer id);
	
	//所有訂單
	public List<String> adminAllOrders();
	
	
	

}
