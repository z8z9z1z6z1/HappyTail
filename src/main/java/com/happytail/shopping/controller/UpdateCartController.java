package com.happytail.shopping.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytail.shopping.model.CartBean;
import com.happytail.shopping.model.OrderItem;
import com.happytail.shopping.model.service.ProductService;





@Controller
public class UpdateCartController {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	 ProductService dao ;
	
		@PostMapping("/UpateProduct")
		public ResponseEntity<List<Object> > UpateProduct(Model m ,
				HttpServletRequest request,
				@RequestParam("quantity") Integer quantity,
				@RequestParam("pid")Integer pid
				) {
			HttpSession session = request.getSession();
			
			System.out.println("quantity="+quantity+ " and pid="+pid);
			CartBean cart = (CartBean) session.getAttribute("cart");
			// 如果找不到購物車，沒有必要往下執行
			if(cart==null) {
				return null;
			}
			System.out.println("進入更新");
		
			Map<Integer, OrderItem> content = cart.getContent();
			OrderItem orderItem = content.get(pid);
			orderItem.setQuantity(quantity);
			
			cart.modifyQty(pid, quantity);
			
			session.setAttribute("cart", cart);
			Double price = orderItem.getUnitPrice()*orderItem.getQuantity();
			Integer productId = orderItem.getProductId();
			List<Object> list =new ArrayList<Object>();
			double subtotal = cart.getSubtotal();
			list.add(subtotal);
			list.add(price);
			list.add(productId);
			ResponseEntity<List<Object>> re =new ResponseEntity<List<Object>>(list, HttpStatus.OK);
			return re;
		}
}
