package com.happytail.config.view;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Configuration
public class ShopView {

	//首頁
	@Bean
	public View shopIndex() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/shop/shopIndex.jsp");
		return view;
	}
	
	//查看商品
	@Bean
	public View showProduct() {
		InternalResourceView view = new InternalResourceView();
		System.out.println("進入view");
		view.setUrl("/WEB-INF/pages/shop/showProduct.jsp");
		return view;
	}
	
//	@Bean
//	public View showOrderDetail() {
//		InternalResourceView view = new InternalResourceView();
//		view.setUrl("/WEB-INF/pages/shop/showOrderDetail.jsp");
//		return view;
//	}
	
	@Bean
	public View shoppingCart() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/shop/shoppingCart.jsp");
		return view;
	}
	
	@Bean
	public View OrderCheck() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/shop/OrderCheck.jsp");
		return view;
	}
	
	@Bean
	public View AllOrderList() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/shop/AllOrderList.jsp");
		return view;
	}
	
	@Bean
	public View ThanksForOrder() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/shop/ThanksForOrder.jsp");
		return view;
	}
	
	@Bean
	public View getFavorite() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/shop/getFavorite.jsp");
		return view;
	}
	
	@Bean
	public View showOrder() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/shop/showOrder.jsp");
		return view;
	}
	
	@Bean
	public View showOrderDetail() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/shop/showOrderDetail.jsp");
		return view;
	}
	

}
