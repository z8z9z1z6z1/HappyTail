package com.happytail.admin.model;

import java.util.List;

import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.OrderItemBean;
import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.dao.ProductDao;

public interface AdminShopDao {
	
	//商品總數
	public Long countProjects();
	//訂單總數
	public Long countOrders();
	//商品銷售金額
	public Double sumOrders();
	//商品類別數
	public Long countProductType();
	//未處理訂單數
	public Long unCheckOrders();
	//每月銷售金額
	public List<Long> sumOrdersByMonth();
	//熱銷商品前三名
	public List<Object> top3SalesProduct();
	
	//更改訂單
	OrderBean changeOrderStatus(Integer id);
	//所有訂單
	public List<OrderBean> adminAllOrders();
	//單一訂單
	public List<OrderBean> orderItemByOrderId(Integer id);
	//未處理訂單
	public List<OrderBean> unCheckOrderList();
	
	//修改產品
	ProductBean updateProduct(ProductBean product);

	
	
	

}
