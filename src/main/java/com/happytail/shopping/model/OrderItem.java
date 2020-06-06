package com.happytail.shopping.model;

import org.springframework.stereotype.Component;
//本類別封裝單筆訂單資料
@Component
public class OrderItem {
	
	String name ;
	Integer productId;
	Integer quantity  = 0 ; 
	Double unitPrice = 0.0 ; 
	Double discount = 1.0 ;
	
	

	public OrderItem() {
	
	}
	public OrderItem( Integer productId,String name, Integer quantity, Double unitPrice, Double discount) {
		super();
		this.name = name;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	
	
}
