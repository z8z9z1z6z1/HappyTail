package com.happytail.member.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.happytail.member.model.PetMembers;
import com.happytail.member.model.service.PetMembersService;


@Controller
public class PetMembersController {	
	
	@Autowired
	PetMembersService service;
	
	@Autowired
	PetMembers petMember;
	
	@Autowired
	ServletContext context;
	
	final static Pattern emailPattern = Pattern
			.compile("^[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*$");
	final static Pattern pwd1 = Pattern.compile(".*[a-z]+.*");
	final static Pattern pwd2 = Pattern.compile(".*[A-Z]+.*");
	final static Pattern pwd3 = Pattern.compile(".*[0-9]+.*");
	final static Pattern pwd4 = Pattern.compile(".*[~!@#$%^&*]+.*");	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String processRregister() {
		return "petMemberPage";
	}
	
	@GetMapping(value ="/accountStart")
	public String accountStart(@RequestParam(name="code") String startCode, Model model) {
		
		boolean result = service.checkStartCode(startCode);			
		model.addAttribute("verificationResult", result);
		return "verificationResult";
	}	
	
	
	@GetMapping(value ="/forgetPassword")
	public String forgetPassword() {
		return "sendTemporaryPassword";
	}
	
	
	@RequestMapping(value = "/sendTemporaryPassword", method = {RequestMethod.GET,RequestMethod.POST })
	public String sendTemporaryPassword(
		@RequestParam(name="temporaryPasswordAccount") String temporaryPasswordAccount,
		HttpServletRequest request,
		Model model
		) {
		Map<String, String> errorMsg = new HashMap<String, String>();	
		model.addAttribute("errorMsg", errorMsg);
		
		if(temporaryPasswordAccount == null || temporaryPasswordAccount.trim().length() == 0) {
			errorMsg.put("temporaryPasswordAccountError", "帳號欄不可空白");
		}else{
			PetMembers un = service.selectPetMembers(temporaryPasswordAccount);			
			if(un == null) {
				errorMsg.put("temporaryPasswordAccountError", "該帳號不存在，請重新輸入");			
			}		
		}
		if (!errorMsg.isEmpty()) {			
			return "temporaryPetMemberPage1";
		}
		HttpSession session = request.getSession();
		session.setAttribute("temporaryPasswordAccount", temporaryPasswordAccount);
		service.sendTemporaryPassword(temporaryPasswordAccount);
		
		return "redirectTemporaryPetMemberPage2";
	}
	
	
	@GetMapping("/redirectTemporaryPetMemberPage2")
	public String RedirectTemporaryPetMemberPage2() {
		return "temporaryPetMemberPage2";
	}
	
	@PostMapping(value = "/changePassword")
	public String changePassword(
			@RequestParam(name="password") String password,
			@RequestParam(name="id") Integer id,
			Model model, HttpServletRequest request
			
			) {
		Map<String, String> errorMsg = new HashMap<String, String>();	
		model.addAttribute("errorMsg", errorMsg);	

		if(password == null || password.trim().length() == 0) {
			errorMsg.put("passwordError", "密碼欄不可空白");
		}else if( !(pwd1.matcher(password).matches() 
				 && pwd2.matcher(password).matches() 
				 && pwd3.matcher(password).matches() 
				 && pwd4.matcher(password).matches() 
				 && password.length() > 7 ) ){
			errorMsg.put("passwordformatError", "密碼格式不符要求");
		}	
		

		if (!errorMsg.isEmpty()) {				
			return "changePassword";
		}
		
		PetMembers petmember = service.selectPetMembers(id);
		petmember.setPassword(password);
		petmember.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		
		PetMembers um = service.updatePetMembers(petmember);
		HttpSession session = request.getSession();
		session.setAttribute("LoginOK", um);
		
		return "petMemberIndex";
	}
	
	
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String updatePetMembers(
//			@RequestParam(name="account") String account,
			@RequestParam(name="id") Integer memberId,
			@RequestParam(name="username") String username,
			@RequestParam(name="password") String password,
			@RequestParam(name="gender") String gender,
			@RequestParam(name="bday") String bday,
			@RequestParam(name="age") String age,
			@RequestParam(name="address") String address,
			@RequestParam(name="phone") String phone,
			@RequestParam(name="memberImage") MultipartFile memberImage,
			HttpServletRequest request,
			Model model		
			
			) {	
//		System.out.println(gender);
		PetMembers petmember = service.selectPetMembers(memberId);
		Map<String, String> errorMsg = new HashMap<String, String>();	
		model.addAttribute("errorMsg", errorMsg);		
		
//		if(account == null || account.trim().length() == 0) {
//			errorMsg.put("usernameError", "帳號欄不可空白");
//		}else if(!account.isEmpty()) {
//			PetMembers un = service.selectPetMembers(account);			
//			if(un != null && un.getAccount() != petmember.getAccount()) {
//				errorMsg.put("userIsExist", "會員帳號重複");				
//			}			
//		}	
		
		if(username == null || username.trim().length() == 0) {
			errorMsg.put("usernameError", "姓名欄不可空白");
		}
		
		if(password == null || password.trim().length() == 0) {
			errorMsg.put("passwordError", "密碼欄不可空白");
		}else if( !(pwd1.matcher(password).matches() 
				 && pwd2.matcher(password).matches() 
				 && pwd3.matcher(password).matches() 
				 && pwd4.matcher(password).matches() 
				 && password.length() > 7 ) ){
			errorMsg.put("passwordformatError", "密碼格式不符要求");
		}
		
		Date bdate = null;
		try {
			bdate = Date.valueOf(bday);
		}catch(Exception e) {
			e.printStackTrace();
//			errorMsg.put("mBbday", "出生日期格式錯誤");
		}
		
		Integer age2 = null;
		try {
			age2 = Integer.parseInt(age);			
		}catch(Exception e) {
			e.printStackTrace();
//			errorMsg.put("mAge", "年齡格式錯誤");
		}
		
		if(memberImage.getSize() == 0) {
			
		} else {		
			String originalFilename = memberImage.getOriginalFilename();			
			if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
				petmember.setFileName(originalFilename);
//				ext = picture.getOriginalFilename().substring(originalFilename.lastIndexOf("."));
			}else {
				petmember.setFileName(username);
			}			
			
			if (memberImage != null && !memberImage.isEmpty()) {				
				try {
					byte[] b = memberImage.getBytes();
					Blob blob = new SerialBlob(b);
					petmember.setMemberImage(blob);
				} catch (IOException e) {					
						e.printStackTrace();
				} catch (SerialException e) {					
						e.printStackTrace();
				} catch (SQLException e) {					
						e.printStackTrace();
				}				
			}
		}
		
		if (!errorMsg.isEmpty()) {	
			String gen = "M";
			if(gender.equalsIgnoreCase(gen)) {
				model.addAttribute("gender", true);
			}else {
				model.addAttribute("gender", false);
			}			
			return "memberCRUD";
		}
//		petmember.setAccount(account);
		petmember.setUsername(username);
		petmember.setPassword(password);
//		petMember.setEmail(account);
		petmember.setGender(gender);
		petmember.setBday(bdate);
		petmember.setAge(age2);
		petmember.setAddress(address);
		petmember.setPhone(phone);
		petmember.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		
		PetMembers um = service.updatePetMembers(petmember);
		HttpSession session = request.getSession();
		session.setAttribute("LoginOK", um);
		
		return "petMemberIndex";
	}
	
	@RequestMapping(value = "/memberCenter", method = RequestMethod.GET)
	public String selectPetMembers(HttpServletRequest request, Model model) {		
		HttpSession session = request.getSession();
		PetMembers pMember = (PetMembers) session.getAttribute("LoginOK");
		PetMembers petmember = service.selectPetMembers(Integer.valueOf(pMember.getId()));
		
		String gen = "M";		
		boolean re =  petmember.getGender().equalsIgnoreCase(gen) ;
		System.out.println(re);
		System.out.println( petmember.getGender());
		
		if( petmember.getGender().equalsIgnoreCase(gen)) {
			model.addAttribute("gender", true);
		}else {
			model.addAttribute("gender", false);
		}
		model.addAttribute("petMember",  petmember);
		System.out.println(petmember.getId());
		return "memberCRUD";			
	}	
	
	@RequestMapping(value = "/registerInsert", method = RequestMethod.POST)
	public String insertMembers(
		@RequestParam(name="account") String account,	
		@RequestParam(name="username") String username,
		@RequestParam(name="password") String password,
//		@RequestParam(name="email") String email,
		@RequestParam(name="gender") String gender,
		@RequestParam(name="bday") String bday,
		@RequestParam(name="age") String age,
		@RequestParam(name="address") String address,
		@RequestParam(name="phone") String phone,	
		@RequestParam(name="memberImage") MultipartFile memberImage,
		Model model
			) {
		Map<String, String> errorMsg = new HashMap<String, String>();	
		model.addAttribute("errorMsg", errorMsg);
				
		if(account == null || account.trim().length() == 0) {
			errorMsg.put("accountError", "帳號欄不可空白");
		}else if(!emailPattern.matcher(account).matches()) {
			errorMsg.put("accountformatError", "會員帳號格式錯誤");				
		}
		
		PetMembers un = service.selectPetMembers(account);			
		if(un != null) {
			errorMsg.put("accountIsExist", "會員帳號重複");				
		}				
		
		if(username == null || username.trim().length() == 0) {
			errorMsg.put("usernameError", "姓名欄不可空白");
		}
		
		if(password == null || password.trim().length() == 0) {
			errorMsg.put("passwordError", "密碼欄不可空白");
		}else if( !(pwd1.matcher(password).matches() 
				 && pwd2.matcher(password).matches() 
				 && pwd3.matcher(password).matches() 
				 && pwd4.matcher(password).matches() 
				 && password.length() > 7 ) ){
			errorMsg.put("passwordformatError", "密碼格式不符要求");
		}
		
		Date bdate = null;
		try {
			bdate = Date.valueOf(bday);
		}catch(Exception e) {
			e.printStackTrace();
//			errorMsg.put("mBbday", "出生日期格式錯誤");
		}
		
		Integer age2 = null;
		try {
			age2 = Integer.parseInt(age);			
		}catch(Exception e) {
			e.printStackTrace();
//			errorMsg.put("mAge", "年齡格式錯誤");
		}		

		if (!errorMsg.isEmpty()) {	
			String gen = "M";
			if(gender.equalsIgnoreCase(gen)) {
				model.addAttribute("gender", true);
			}else {
				model.addAttribute("gender", false);
			}
			return "petMemberPage";
		}
		
		String originalFilename = memberImage.getOriginalFilename();			
		if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
			petMember.setFileName(originalFilename);
//			ext = picture.getOriginalFilename().substring(originalFilename.lastIndexOf("."));
		}else {
			petMember.setFileName(username);
		}			
		
		if (memberImage != null && !memberImage.isEmpty()) {				
			try {
				byte[] b = memberImage.getBytes();
				Blob blob = new SerialBlob(b);
				petMember.setMemberImage(blob);
			} catch (IOException e) {					
					e.printStackTrace();
			} catch (SerialException e) {					
					e.printStackTrace();
			} catch (SQLException e) {					
					e.printStackTrace();
			}				
		}
		
		petMember.setAccount(account);
		petMember.setUsername(username);
		petMember.setPassword(password);
		petMember.setEmail(account);
		petMember.setGender(gender);
		petMember.setBday(bdate);
		petMember.setAge(age2);
		petMember.setAddress(address);
		petMember.setPhone(phone);
	
		PetMembers pm = service.insertPetMembers(petMember);		
		
		if (pm != null) {
			return "redirectVerificationSended";
		} else {
			return "petMemberPage";
		}
	}
	
	@GetMapping("/redirectVerificationSended")
	public String RedirectVerificationSended() {
		return "verificationSended";
	}
	
	@GetMapping("/memberImage/{id}")
	public ResponseEntity<byte[]> getMemberImage(@PathVariable("id") Integer id) {
		byte[] body = null;
		ResponseEntity<byte[]> re = null;
		MediaType mediaType = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		
		PetMembers pMember = service.selectPetMembers(id);
		if (pMember == null) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		
		String filename = pMember.getFileName();
		if (filename != null) {
			if (filename.toLowerCase().endsWith("jfif")) {
				mediaType = MediaType.valueOf(context.getMimeType("dummy.jpeg"));
			} else {
				mediaType = MediaType.valueOf(context.getMimeType(filename));
				headers.setContentType(mediaType);
			}
		}
		
		Blob blob = pMember.getMemberImage();
		if (blob != null) {
			body = blobToByteArray(blob);
		}else {	
//			mediaType = MediaType.valueOf("image/png");
//			headers.setContentType(mediaType);
			String path = "/WEB-INF/static/img/NoImage.png";
			body = fileToByteArray(path);			
		}		
		re = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);

		return re;		
	}
	
	private byte[] fileToByteArray(String path) {
		byte[] result = null;
		try (InputStream is = context.getResourceAsStream(path);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public byte[] blobToByteArray(Blob blob) {
		byte[] result = null;
		try (InputStream is = blob.getBinaryStream(); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}	
