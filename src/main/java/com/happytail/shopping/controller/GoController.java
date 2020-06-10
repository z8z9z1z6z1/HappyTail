package com.happytail.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.happytail.member.model.PetMembers;
import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.OrderItemBean;
import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductLike;
import com.happytail.shopping.model.service.OrderService;
import com.happytail.shopping.model.service.ProductLikeService;
import com.happytail.shopping.model.service.ProductService;
import com.happytail.shopping.model.service.ShowProductService;



@Controller
public class GoController {

	@Autowired
	SessionFactory session;
	@Autowired
	 ProductService dao ;
	@Autowired
	ShowProductService ShowProductService;
	@Autowired
	ProductLikeService ldao;
	@Autowired
	OrderService odao;
	
	
	
	@GetMapping("/showProduct")
	public String go() {
		return "showProduct";
	}
	@GetMapping("/shopIndex")
	public String go1() {
		System.out.println("進入商城首頁");
		return "shopIndex";
	}
	
	//前往購物車
	@GetMapping("/intoCart")
	public String intoCart() {
		
		return"shoppingCart";
	}
	
	@GetMapping(value = "/showProduct1")
	public String showProduct1(Model m,HttpServletRequest request ) {
		List<ProductBean> list = dao.selectCategory(1);
		m.addAttribute("productList", list);
		System.out.println("抓取資料成功");

		return "showProduct";
	}
	
	@GetMapping(value = "/showProduct2")
	public String showProduct2(Model m,HttpServletRequest request ) {
		List<ProductBean> list = dao.selectCategory(2);
		m.addAttribute("productList", list);
		System.out.println("抓取資料成功");

		return "showProduct";
	}
	
	@GetMapping(value = "/showProduct3")
	public String showProduct3(Model m,HttpServletRequest request ) {
		List<ProductBean> list = dao.selectCategory(3);
		m.addAttribute("productList", list);
		System.out.println("抓取資料成功");

		return "showProduct";
	}
	
	
	@GetMapping(value = "/getFavorite.do")
	public String getFavorite(Model m,HttpServletRequest request
			,@SessionAttribute("LoginOK")PetMembers petMembers) {
		List<ProductLike> pLike = ldao.showLikes(petMembers.getId());
		
		m.addAttribute("pLike", pLike);
		System.out.println("pLike.size="+pLike.size());

		return "getFavorite";
	}
	
	//查看訂單
	@GetMapping("/getOrderBean.do")
	public String getOrderBean(Model m,
			@SessionAttribute("LoginOK")PetMembers petMembers,
			HttpServletRequest res){
		HttpSession session = res.getSession();

		Integer a = petMembers.getId();
		System.out.println("petMembersId="+petMembers.getId());
		List<OrderBean> list = odao.selectOrderByMemberId(a);
		List<OrderBean> list2 = odao.selectOrderByMemberIdNew(a);
		List<OrderBean> list3 = odao.selectOrderByMemberIdOld(a);
		
		System.out.println("獲取所有訂單");
		m.addAttribute("orderList",list);
		m.addAttribute("orderList2",list2);
		m.addAttribute("orderList3",list3);
		return "showOrder";
	}
	

	@PostMapping("/getOrderDtail.do{oId}")
	public String getOrderDtail(Model m,@PathVariable("oId")Integer oId) {
		System.out.println(oId);
		OrderBean oBean = odao.selectOrder(oId);
		List<OrderItemBean> dlist = odao.getOrderItemBean(oBean);
		
		m.addAttribute("dlist",dlist);
		System.out.println(dlist);
		return "showOrderDetail";
	}
	
	
}
