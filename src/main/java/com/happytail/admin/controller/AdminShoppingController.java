package com.happytail.admin.controller;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.happytail.admin.model.service.AdminShopService;
import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductBeanImageData;
import com.happytail.shopping.model.dao.ProductDao;
import com.happytail.shopping.model.service.OrderService;
import com.happytail.shopping.model.service.ProductService;
import com.happytail.shopping.model.service.ShowProductService;

@Controller
public class AdminShoppingController {

	@Autowired
	SessionFactory Session;

	@Autowired
	ServletContext context;

	@Autowired
	ProductService pservice;
	
	@Autowired
	ShowProductService showproductservice;

	@Autowired
	ProductDao pdao;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	AdminShopService adminShopService;

	// 回商城總覽
	@GetMapping(value = "admin-ShoppingIndex")
	public String adminShoppingIndex() {
		return "adminShoppingIndex";
	}
	
	//商品列表頁
	@GetMapping(value = "admin-AllProjects")
	public String adminAllProject() {
		return "adminAllProject";
	}
	
	//所有訂單
	@GetMapping(value = "admin-AllOrders")
	public String adminAllOrders() {
		return "adminAllOrders";
	}

	// 商品列表Json
	@GetMapping(value = "admin-AllProjects-json")
	public ResponseEntity<List<ProductBean>> selectAllProject() {
		List<ProductBean> list = pservice.getAllProductsJson();
		ResponseEntity<List<ProductBean>> re  = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
		
		
	}

	// 新增商品1
	@GetMapping(value = "admin-InsertProject")
	public String insertProject(Model model) {
		//送出空白表單
		ProductBean productBean = new ProductBean();
		model.addAttribute("productBean", productBean);
		return "adminInsertProject";
	}

	// 新增商品2
	@PostMapping(value = "admin-InsertProject")
	public String addProduct(@ModelAttribute("productBean") ProductBean productBean, 
			BindingResult result,
			Model model) {
		MultipartFile productImage = productBean.getProductImage();
		String originalFilename = productImage.getOriginalFilename();
		ProductBean pBean = (ProductBean) model.getAttribute("productBean");
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
		// 新增放入商品的時間
		Timestamp adminTime = new Timestamp(System.currentTimeMillis());
//		ProductBean pBean =(ProductBean)model.getAttribute("productBean");
		pBean.setAdmissionTime(adminTime);
		System.out.println("建立時間成功");
		System.out.println(adminTime);
		pBean.setName(pBean.getName());
		System.out.println(pBean.getName());

		try {
			pdao.insert(pBean);
		} catch (org.hibernate.exception.ConstraintViolationException e) {
//			result.rejectValue("account", "", "商品已存在，請重新輸入");
			return "adminInsertProject";
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
//			result.rejectValue("account", "", "請通知系統人員...");
			return "adminInsertProject";
		}

		return "adminAllProject";
	}
	
	//訂單列表Json
	@GetMapping(value = "admin-AllOrders-json")
	public ResponseEntity<List<OrderBean>> allOrdersJson() {
		List<OrderBean> list = orderService.getAllOrderJson();
		ResponseEntity<List<OrderBean>> re  = new ResponseEntity<>(list, HttpStatus.OK);
		return re;
	}
	

}
