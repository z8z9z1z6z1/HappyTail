package com.happytail.admin.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.happytail.admin.model.AdminMembersDao;
import com.happytail.admin.model.service.AdminMembersService;
import com.happytail.admin.model.service.AdminShopService;
import com.happytail.member.model.PetMembers;
import com.happytail.member.model.service.PetMembersService;


@Controller
public class AdminMemberController {

	@Autowired
	PetMembersService service;
	
	@Autowired
	PetMembers petMembers;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	AdminMembersDao adDao;
	
	@Autowired
	AdminMembersService adMemberService;
	
	@Autowired
	AdminShopService adShopService;
	
	//回後臺首頁
	@GetMapping(value = "admin-Index")
	public String adminIndex(Model model) {
		//所有會員數
		Long countAll = adMemberService.countMembers();
		model.addAttribute("count",countAll);
		
		//男性會員數
		Long male = adMemberService.countMale();
		model.addAttribute("male", male);
		
		//女性會員數
		Long female = adMemberService.countFemale();
		model.addAttribute("female", female);
		
		//會員年齡分布
		List<Long> list = adMemberService.age();
		model.addAttribute("list",list);
		
		//商品總數
		Long countProjects = adShopService.countProjects();
		model.addAttribute("countProjects", countProjects);
		
		//總銷售金額
		Double sumPrice = adShopService.sumOrders();
		model.addAttribute("sumPrice",sumPrice);
		
		//未處理訂單數
		Long unchickOrders = adShopService.unCheckOrders();
		model.addAttribute("unchickOrders", unchickOrders);
		
		//每月銷售額
		List<Long> sumOrderByMonth = adShopService.sumOrdersByMonth();
		model.addAttribute("list2",sumOrderByMonth);
		
		//Top3
		List<Object> top3 = adShopService.top3SalesProduct();
		model.addAttribute("top3" ,top3);

		return "adminIndex";
	}
	
	//回前台首頁
	@GetMapping(value = "admin-happyTail")
	public String happyTailIndex() {
		return "petMemberIndex";
	}
	
	//選取所有會員資料
	@GetMapping(value = "admin-AllMembers")
	public String selectAllMembers(Model model) {
		List<PetMembers> members = service.selectAllPetMembers();
		model.addAttribute("allMembers",members);
		return "adminMembers";
	}
	
	//所有會員資料Json
	@GetMapping(value = "admin-allMembersJSON", produces= {"application/json"})
	public ResponseEntity<List<PetMembers>> queryAllMembersForJSON(Model model) {
		List<PetMembers> members = service.selectAllPetMembers();
		ResponseEntity<List<PetMembers>> re  = new ResponseEntity<>(members, HttpStatus.OK);
		return re;
	}
	
	//更改狀態
	@PostMapping(value = "admin-changeStatus/{key}", produces= {"application/json"})
	public ResponseEntity<PetMembers> changeMemberstatus(@PathVariable Integer key, PetMembers member) {
		PetMembers members = adMemberService.changeMemberStatus(key);
		ResponseEntity<PetMembers> re = new ResponseEntity<>(members, HttpStatus.OK);
		return re;
	}

}
