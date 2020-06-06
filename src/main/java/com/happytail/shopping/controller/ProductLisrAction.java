package com.happytail.shopping.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.happytail.member.model.PetMembers;
import com.happytail.member.model.dao.PetMembersDAO;
import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductLike;
import com.happytail.shopping.model.service.ProductLikeService;
import com.happytail.shopping.model.service.ProductService;
@Controller
public class ProductLisrAction {

		@Autowired
		SessionFactory sessionFactory;
		@Autowired
		ProductLikeService ldao;
		@Autowired
		ProductService pdao;
		@Autowired
		PetMembersDAO mdao;
		
		@GetMapping(value = "/LikeTest")
		public ResponseEntity<ProductLike> addFacorite(
				@SessionAttribute("LoginOK")PetMembers petMembers,
				Model m
				 ){

				if(petMembers==null) {
					return null;
				}
				ProductBean pBean = pdao.selectOne(1);
				System.out.println("進入");
				ProductLike pLike=new ProductLike();
//				PetMembers member = (PetMembers)m.getAttribute("LoginOk");
			
				pLike.setBean(pBean);
				pLike.setPetMemberId(petMembers.getId());
				System.out.println("準備進入DAO");
				ldao.insert(pLike);
				System.out.println("成功匯入");
				ResponseEntity<ProductLike>   re=new ResponseEntity<ProductLike>(pLike, HttpStatus.OK);
				System.out.println(re);
return re ;
}
		
		
	}


