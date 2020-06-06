package com.happytail.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.service.OrderService;
//依照會員編號與訂單編號來讀取某筆訂單的所有資料，這些資料將封裝為一個OrderBean物件
@Controller
public class CartOrderDetail {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	OrderService orderDao;
	
	@PostMapping(value = "addOrderBean")
	public  String addOrderBean(Model m ,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer orderId = (Integer)m.getAttribute("orderId");
		OrderBean ob = orderDao.selectOrder(orderId);
		
		session.setAttribute("OrderBean", ob);// 將OrderBean物件暫存到請求物件內
		System.out.println("測試  查看訂單="+ob);
		return "showOrderDetail";
	}
}
