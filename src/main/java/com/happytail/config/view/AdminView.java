package com.happytail.config.view;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

@Configuration
public class AdminView {

	// 後臺首頁
	@Bean
	public View adminIndex() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/admin/admin-Index.jsp");
		return view;
	}

	// 後臺會員
	@Bean
	public View adminMembers() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/admin/admin-allMembers.jsp");
		return view;
	}

	// 後台商城總覽
	@Bean
	public View adminShoppingIndex() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/admin/admin-shoppingIndex.jsp");
		return view;
	}

	// 所有商品
	@Bean
	public View adminAllProject() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/admin/admin-allProject.jsp");
		return view;
	}

	// 新增商品
	@Bean
	public View adminInsertProject() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/admin/admin-insertProject.jsp");
		return view;
	}

	// 訂單列表
	@Bean
	public View adminAllOrders() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/admin/admin-allOrders.jsp");
		return view;
	}

	// 未確認訂單
	@Bean
	public View adminUncheckOrders() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/admin/admin-uncheckOrders.jsp");
		return view;
	}
	
	//討論區管理
	@Bean
	public View adminForum() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/admin/admin-forum.jsp");
		return view;
	}
	
	//更新商品
	@Bean
	public View adminupdateProduct() {
		InternalResourceView view = new InternalResourceView();
		view.setUrl("/WEB-INF/pages/admin/admin-updateProduct.jsp");
		return view;
	}

}
