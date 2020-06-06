package com.happytail.shopping.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytail.shopping.model.CartBean;
import com.happytail.shopping.model.OrderItem;
import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.service.ProductService;



@Controller	
public class BuyCartController {
	@Autowired
	SessionFactory  sessionFactory;
	@Autowired
	 ProductService dao ;
	
//	@Autowired
//	 ProductDao dao ;
	
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	@GetMapping(value = "/addProductToCart",produces= {"application/json"})
	public ResponseEntity<ArrayList<Object>> addProductToCart(Model m,
			@RequestParam("productId") Integer  productId,		
			HttpServletRequest request){
		// 取出存放在session物件內的ShoppingCart物件
		System.out.println("進入/addProductToCart");
		HttpSession session = request.getSession(false);
		CartBean cart = (CartBean)session.getAttribute("cart");
		if(cart==null) {
			 cart=new CartBean( );      
			 session.setAttribute("cart", cart);
		}
		System.out.println("productId="+productId);

		ProductBean pBean = dao.selectOne(productId);
		
		System.out.println("pBean="+pBean);
		List<ProductBean> list =new ArrayList<ProductBean>();
		list.add(pBean);
//		System.out.println(cart);
		//新增一筆訂單明細
		//每一個訂單有複數個訂單明細
		OrderItem oItem =
				new OrderItem(productId, pBean.getName(), 1, pBean.getPrice(), pBean.getDiscount());
		System.out.println("oItemBean="+oItem);
		cart.addToCart(productId, oItem);
		Integer itemNumber =(Integer) cart.getItemNumber();
		
		Map<Integer,Object> map =new HashMap<Integer, Object>();
		map.put(1, list);
		map.put(2, itemNumber);
		ArrayList<Object> list2 = new ArrayList<>();
		list2.add(pBean);
		list2.add(itemNumber);
		ResponseEntity<ArrayList<Object>>  re = new ResponseEntity<ArrayList<Object>>(list2, HttpStatus.OK);
		return re;
	}
	
	
}


