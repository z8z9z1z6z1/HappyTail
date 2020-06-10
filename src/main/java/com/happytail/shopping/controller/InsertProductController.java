package com.happytail.shopping.controller;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.dao.ProductDao;
import com.happytail.shopping.model.service.ProductService;

@Controller
public class InsertProductController {
	@Autowired
	SessionFactory session;
	@Autowired
	 ProductService dao2 ;
	
	@Autowired
	 ProductDao dao ;
	
	@Autowired
	ServletContext context;
	
	
	// 本方法於新增時，送出空白的表單讓使用者輸入資料
		@GetMapping(value = "/insertProduct")
		public String showEmptyForm(Model model) {
			//一定要給一個空的bean
			ProductBean productBean=new ProductBean();
			
			model.addAttribute("productBean",productBean);
			return"toInsertProduct";
		}
		
		
		
		//新增商品
		@PostMapping(value = "/insertProduct")
		public String addProduct(
				@ModelAttribute("productBean") 
				ProductBean productBean,
				BindingResult result,
				Model model
				) {
			MultipartFile productImage = productBean.getProductImage();
			String originalFilename = productImage.getOriginalFilename();
			ProductBean pBean =(ProductBean)model.getAttribute("productBean");
			if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
				pBean.setFileName(originalFilename);
			}
			// 建立Blob物件，交由 Hibernate 寫入資料庫
			if (productImage != null && !productImage.isEmpty()) {
				try {
					byte[] b = productImage.getBytes();
					Blob blob = new SerialBlob(b);
					pBean.setCoverImage(blob);
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
				}
			}
			System.out.println("建立Blob物件成功");
			//新增放入商品的時間
			Timestamp adminTime = new Timestamp(System.currentTimeMillis());
//			ProductBean pBean =(ProductBean)model.getAttribute("productBean");
			pBean.setAdmissionTime(adminTime);
			System.out.println("建立時間成功");
			System.out.println(adminTime);
			pBean.setName(pBean.getName());
			System.out.println(pBean.getName());
			
			try {
				dao.insert(pBean);
			} catch (org.hibernate.exception.ConstraintViolationException e) {
//				result.rejectValue("account", "", "商品已存在，請重新輸入");
				return "shopping/insertProduct";
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
//				result.rejectValue("account", "", "請通知系統人員...");
				return "新增失敗";
			}
			
			
			return "查看您新增的商品";
		}
		
		
//		@GetMapping(value = "/OutputBarChart", produces= {"application/json"} )
//		public ResponseEntity<Option> OutputBarChart(@RequestParam String mon,@RequestParam String year, Model model) {
//			BarcharBean bb = commentServiceIMPL.getWebCommentAvg(year, mon);
//			Option option = bb.getOption();
//			ResponseEntity<Option> re  = new ResponseEntity<>(option, HttpStatus.OK);
//			return re;
//		}
//		

	
	
	
}
