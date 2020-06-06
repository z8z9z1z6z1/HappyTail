package com.happytail.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.happytail.member.model.PetMembers;
import com.happytail.member.model.service.PetMembersService;

@Controller
@SessionAttributes(value = "petMembers")
public class LoginController {	
	
	@Autowired
	PetMembersService service;
	
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String processLogin() {
		System.out.println("進入login");
		return "memberLogin";

	}
	
	@PostMapping(value = "/loginCheck")
	public String checkLogin(
			@RequestParam(name="account") String account,
			@RequestParam(name="password") String password,
			Model m,
			HttpServletRequest request
	
		) {		
		HttpSession session = request.getSession();
		
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("ErrorMsg", errorMsg);
		
		if(account == null || account.trim().length() == 0) {
			errorMsg.put("accountError", "帳號欄不可空白");
		}
		
		if(password == null || password.trim().length() == 0) {
			errorMsg.put("passwordError", "密碼欄不可空白");
		}
		
		if (!errorMsg.isEmpty() ) {
			return "memberLogin";		}
		
		PetMembers pMember = service.checkLogin(account, password);
		
			if( pMember != null) {
				if(pMember.getStatus() == 1) {
					session.setAttribute("LoginOK", pMember);
					m.addAttribute("petMembers",pMember);
					return "petMemberIndex";				
				}else if(pMember.getStatus() == 2) {
					return "accountStop";
				}else if(pMember.getStatus() == 3) {
					session.setAttribute("LoginOK", pMember);
					m.addAttribute("petMembers",pMember);
					return"adminIndex";
				}
			
			}
				errorMsg.put("LoginError", "帳號未啟用或帳號、密碼錯誤");		
		
			if (!errorMsg.isEmpty()) {
				return "memberLogin";
			}
		
		return "petMemberIndex";
		
	}	
	
	@PostMapping(value = "/temporaryPasswordloginCheck")
	public String temporaryPasswordcheckLogin(			
			@RequestParam(name="temporaryPassword") String temporaryPassword,
			HttpServletRequest request
	
		) {		
		HttpSession session = request.getSession();		
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("ErrorMsg", errorMsg);	
		
		if(temporaryPassword == null || temporaryPassword.trim().length() == 0) {
			errorMsg.put("temporaryPasswordError", "臨時密碼欄不可空白");
		}
		PetMembers result = service.checkTemporaryPassword((String)session.getAttribute("temporaryPasswordAccount") ,temporaryPassword);			
		if(result == null) {
			errorMsg.put("temporaryPasswordError", "臨時密碼欄錯誤，請重新輸入");			
		}
			
		if (!errorMsg.isEmpty() ) {
			return "temporaryPetMemberPage2";			
		}
			
		session.setAttribute("LoginOK", result);
		return "changePassword";
		}	
		
	
	
	@GetMapping(value = "/logoutCheck")
	public String Logout(HttpServletRequest request ) {
				
		HttpSession session = request.getSession(false);
		
		session.invalidate();
		
		return "petMemberIndex";
	}
	
}
