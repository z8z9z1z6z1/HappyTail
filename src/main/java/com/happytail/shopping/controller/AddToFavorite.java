package com.happytail.shopping.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Timestamp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.happytail.member.model.PetMembers;
import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductLike;
import com.happytail.shopping.model.service.ProductLikeService;
import com.happytail.shopping.model.service.ProductService;

@Controller
public class AddToFavorite {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductLikeService dao;
	@Autowired
	ProductService pdao;
	@Autowired
	ProductLikeService ldao;

	@GetMapping(value = "/addToLike")
	public ResponseEntity<ProductLike> addFacorite(
			@RequestParam("productId") Integer productId, Model m,@SessionAttribute("logionOK")PetMembers pMembers) {
		ProductBean pBean = pdao.selectOne(productId);
		if(pMembers==null) {
			return null;
		}
		System.out.println("進入");
		ProductLike pLike = new ProductLike();

		pLike.setBean(pBean);
		pLike.setPetMemberId(pMembers.getId());

		Boolean check = ldao.check(pLike.getBean().getProductId(), pLike.getPetMemberId());

		if (check == false) {
			System.out.println("已經加入");
			return null;
		}
		Timestamp date2 = new Timestamp(System.currentTimeMillis());

		pLike.setUpdatetime(date2);
		System.out.println("準備進入DAO");
		ldao.insert(pLike);
		System.out.println("成功匯入");
		ResponseEntity<ProductLike> re = new ResponseEntity<ProductLike>(pLike, HttpStatus.OK);
		System.out.println(re);
		return re;
	}
}
