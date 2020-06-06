package com.happytail.admin.model.service;

import java.util.List;

public interface AdminShopService {
	
	//商品總數
	public Long countProjects();
	//訂單總數
	public Long countOrders();
	//商品銷售金額
	public Double sumOrders();
	//商品類別數
	public Long countProjectType();
	//未處理訂單數
	public Long unChickOrders();
	//每月銷售額
	public List<Long> sumOrdersByMonth();
	
	public List<String> adminAllOrders();

}
