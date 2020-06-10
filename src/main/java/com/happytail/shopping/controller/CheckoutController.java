package com.happytail.shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.happytail.member.model.PetMembers;
import com.happytail.member.model.dao.PetMembersDAO;
import com.happytail.shopping.model.CartBean;

@Controller
public class CheckoutController {
	@Autowired
	SessionFactory sessionFactory;

//	@Autowired
//	MemberService mem;
	@Autowired
	PetMembersDAO mem;
	
	
	@GetMapping("/OrderCheck")
	public String OrderSureForm(
//			@SessionAttribute("LoginOK")PetMembers petMembers,
			HttpServletRequest request) {
		HttpSession session2 = request.getSession();
		PetMembers petMembers= (PetMembers) session2.getAttribute("LoginOK");
		if(petMembers==null) {
			return "memberLogin";
		}
		System.out.println("進去確認訂單");
		HttpSession session = request.getSession(false);
		CartBean cart=(CartBean)session.getAttribute("cart");
		if (cart == null) {
			System.out.println("找不到購物車");
			
			return"shoppingIndex";
		}
		System.out.println("前往結帳");
		
		System.out.println("以下用來測試");
	
		
		return"OrderCheck";	
				}
	
}
