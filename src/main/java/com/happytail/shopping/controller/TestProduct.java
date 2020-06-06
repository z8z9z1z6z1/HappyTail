package com.happytail.shopping.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductBeanImageData;
import com.happytail.shopping.model.service.ProductService;
import com.happytail.shopping.model.service.ShowProductService;

@Controller
public class  TestProduct{
	@Autowired
	SessionFactory session;
	@Autowired
	 ProductService dao ;
	@Autowired
	ShowProductService ShowProductService;
	
//	@Autowired
//	 ProductDao dao ;
	
	@Autowired
	ServletContext context;
	
	@GetMapping(value = "/allProductNoImage", produces= {"application/json"} )
	public ResponseEntity<List<ProductBean>> allProductNoImage() {

		System.out.println("進入controller");
		System.out.println("test");
		List<ProductBean> selectAll = dao.selectAll();
		ResponseEntity<List<ProductBean>> re  = new ResponseEntity<>(selectAll, HttpStatus.OK);

		
		return re;
	}
	
	@GetMapping(value = "/allProductWithImage", produces= {"application/json"} )
	public ResponseEntity<List<ProductBeanImageData>> allProductWithImage() {

		System.out.println("進入controller");
		System.out.println("test");
		List<ProductBeanImageData> list = dao.getAllProductsImageDatas();
		ResponseEntity<List<ProductBeanImageData>> re  = new ResponseEntity<>(list, HttpStatus.OK);

		
		return re;
	}
	

	
	
	
	
	
}
