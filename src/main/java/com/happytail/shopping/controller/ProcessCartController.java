
package com.happytail.shopping.controller;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.happytail.member.model.PetMembers;
import com.happytail.shopping.model.CartBean;
import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.OrderItem;
import com.happytail.shopping.model.OrderItemBean;
import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.dao.impl.OrderItemDaoImpl;
import com.happytail.shopping.model.service.OrderService;
import com.happytail.shopping.model.service.ProductService;


//確認訂單
@Controller
public class ProcessCartController {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	OrderService orderDao;
//	OrderDao orderDao;
	@Autowired
	OrderItemDaoImpl oidao;
	@Autowired
	ProductService pdao;
	
	@PostMapping("/OrderSure")
	public String OrderConfirm(Model m ,
			@RequestParam("address") String address,
			@RequestParam("message") String message,
			@SessionAttribute("LoginOK")PetMembers petMembers,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
//		PetMembers members= (PetMembers) session.getAttribute("LoginOk");
		//最終決定
//		 String finalDecision= (String) session.getAttribute("finalDecision");
		if(petMembers==null) {
			//沒有登入
			return "index";
		}
		 
		
		CartBean cart =  (CartBean) session.getAttribute("cart");
		if(cart==null) {
			// 處理訂單時如果找不到購物車，沒有必要往下執行
						// 導向首頁
			return "index";
		}

		double totalPrice = Math.round(cart.getSubtotal()*1.0);

		System.out.println("address="+address);
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String orderDate = sdFormat.format(date);
		System.out.println("測試用 查看當前時間="+orderDate);

		//新建訂單物件
		OrderBean orderBean=
				new OrderBean(petMembers.getId(), totalPrice, address, orderDate,message,"未付款");
//				new OrderBean(會員	,總價格	, 地址,		 日期,		備註,"狀態");
		
		Set<OrderItemBean> itemSet = new HashSet<OrderItemBean>();
		// 取出存放在購物車內的商品，放入Map型態的變數OrderItem，準備將其內的商品一個一個轉換為OrderItemBean，
				// 然後存入items。
		Map<Integer, OrderItem> OrderItemMap = cart.getContent();
		// 呼叫keySet()取出cart內所有的 key，由於Map內的Key不會重複，因此keySet()方法的傳回值為
		// Set物件
		Set<Integer> set = OrderItemMap.keySet();
		// 使用for敘述將set內所有的元素(這些元素都是Map物件內的Key)逐一取出，然後經由Map物件的
		
		for(Integer k  :  set) {
			// get方法取出Key所對應的value物件。這些value物件就是客戶購買的商品。
			OrderItem oi =OrderItemMap.get(k);
			
			System.out.println(oi);
			String  description = "商品編號="+oi.getProductId()+" 商品名稱="+oi.getName();
//			System.out.println(S"description="+description);
			ProductBean pBean = pdao.selectOne(oi.getProductId());
			OrderItemBean oib =new OrderItemBean(pBean, oi.getName(), oi.getQuantity(), oi.getUnitPrice(), oi.getDiscount());
			System.out.println("oib="+oib);
			itemSet.add(oib);
			
		}
			
			

			System.out.println("itemSet="+itemSet);
//			OrderBean oBean = orderDao.selectOrder(orderBean.getOrderId());
			try {
				orderDao.insert(orderBean);
				
				
			for(OrderItemBean o:itemSet) {
				o.setOrderBean(orderBean);
				oidao.insert(o);

				
			}
//			orderBean.setOrderItemBean(itemSet);
			System.out.println("itemSet.size()="+itemSet.size());
			
			
//			
			
			System.out.println("新增訂單成功");
			session.removeAttribute("cart");
//			return "ThanksForOrder";
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("新增訂單失敗");
				
				return "showProduct";
			}
			
		
		return "shopIndex";
		
		
	}
		
}
