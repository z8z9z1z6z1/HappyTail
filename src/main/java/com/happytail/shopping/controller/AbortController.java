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
import org.springframework.web.bind.annotation.SessionAttribute;

import com.happytail.member.model.PetMembers;
import com.happytail.shopping.model.CartBean;
import com.happytail.shopping.model.ProductLike;
import com.happytail.shopping.model.service.ProductLikeService;

//放棄購買
@Controller
public class AbortController {
	@Autowired
	SessionFactory	 sessionFactory;
	@Autowired
	ProductLikeService ldao;
	
	
	
	@GetMapping("/abortBuy")
	public String abortBuy(Model m,HttpServletRequest request,@SessionAttribute("LoginOK")PetMembers petMembers) {
		HttpSession session = request.getSession();
		CartBean cart = (CartBean) session.getAttribute("cart");
		if(cart==null) {
			System.out.println("無購物車商品");
			return "showProduct";
		}
		request.removeAttribute("cart");
		return "showProduct";
	}
	
	@GetMapping("/remove.do/{pid}")
	public String remove(@PathVariable("pid") int pId,HttpServletRequest request,Model m,@SessionAttribute("LoginOK")PetMembers petMembers) {
		
		Integer id = petMembers.getId();
		ProductLike oneLike = ldao.getOneLike(pId, id);
		if (oneLike==null) {
			List<ProductLike> pLike = ldao.showLikes(id);
			
			m.addAttribute("pLike", pLike);
			return "getFavorite";
		}
		ldao.delete(oneLike);

		List<ProductLike> pLike = ldao.showLikes(id);
		
		m.addAttribute("pLike", pLike);

		return "getFavorite";
	}
	
}
