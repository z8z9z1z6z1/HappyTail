package com.happytail.shopping.model;

import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class CartBean {
	private Map<Integer, OrderItem> cart = new LinkedHashMap< >();
	public CartBean() {
	}
	public Map<Integer, OrderItem>  getContent() { // ${ShoppingCart.content}
		return cart;
	}
	public void addToCart(int productId, OrderItem  od) {
		if (od.getQuantity() <= 0 ) {
			return;
		}
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if ( cart.get(productId) == null ) {
		    cart.put(productId, od);
		} else {
	        // 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			OrderItem oib = cart.get(productId);
			// 加購的數量：oi.getQty()
			// 原有的數量：oib.getQty()			
			oib.setQuantity(od.getQuantity() + oib.getQuantity());
		}
	}

	public boolean modifyQty(int productId, int  newQuantity) {
		if ( cart.get(productId) != null ) {
			OrderItem  oi = cart.get(productId);
		   oi.setQuantity(newQuantity);
	       //cart.put(bookID, oi);
	       return true;
		} else {
		   return false;
		}
	}
	// 刪除某項商品
	public int deleteProduct(int productId) {
		if ( cart.get(productId) != null ) {
	       cart.remove(productId);  // Map介面的remove()方法
	       return 1;
		} else {
		   return 0;
		}
	}
	public int getItemNumber(){   // ShoppingCart.itemNumber
		return cart.size();
	}
	//計算購物車內所有商品的合計金額(每項商品的單價*數量的總和)
	public double getSubtotal(){
		double subTotal = 0 ;
		Set<Integer> set = cart.keySet();
		for(int n : set){
			double price    = cart.get(n).getUnitPrice(); //單價
//			double discount = cart.get(n).getDiscount(); // 折扣Q
			int    qty      = cart.get(n).getQuantity();
			subTotal +=  price  * qty;
		}
		return subTotal;
	}
	public void listCart() {
		Set<Integer> set = cart.keySet();
		for(Integer k : set){
			System.out.printf("BookID=%3d,  Qty=%3d,  price=%5.2f,  discount=%6.2f\n" , k , cart.get(k).getQuantity(), cart.get(k).getUnitPrice(), cart.get(k).getDiscount());
		}
		System.out.println("------------------");
	}
}
