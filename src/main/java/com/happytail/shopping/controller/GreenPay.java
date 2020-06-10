package com.happytail.shopping.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.happytail.member.model.PetMembers;
import com.happytail.shopping.model.OrderBean;
import com.happytail.shopping.model.service.OrderService;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutCVS;
import ecpay.payment.integration.domain.InvoiceObj;


@Controller
public class GreenPay {
	//開啟綠界交易
	public static AllInOne all;
	private static void initial(){
		all = new AllInOne("");
	}
	@Autowired
	OrderService odao;
	

	@ResponseBody
	@PostMapping("/getGreen.do{oId}")
	public String getGreen(Model m,@SessionAttribute("LoginOK")PetMembers petMembers,@PathVariable("oId") Integer oId) {
		try {
			OrderBean oBean = odao.selectOrder(oId);
			odao.payMoney(oId);
			AllInOne all = new AllInOne("");
		AioCheckOutCVS obj = new AioCheckOutCVS();
		InvoiceObj invoice = new InvoiceObj();
		UUID uid = UUID.randomUUID();
		obj.setMerchantTradeNo(uid.toString().replaceAll("-", "").substring(0, 20));
		DateFormat  day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String strBeginDate =day.format(new Date() );
		//2017/01/01 08:05:23
		
		System.out.println(strBeginDate);
		obj.setMerchantTradeDate(strBeginDate); //設定MerchantTradeDate 合作特店交易時間，請以 yyyy/MM/dd HH:mm:ss格式帶入
		Double i = oBean.getTotalPrice();
		System.out.println("i="+i);
		String s1 = String.valueOf(i);
		String s2 = s1.substring(0, s1.indexOf("."));
//		Integer totalPrice=(Integer)oBean.getTotalPrice();
		int totalPrice = Integer.parseInt(s2);
		System.out.println("totalPrice="+totalPrice);
		String setTotalAmount = String.valueOf(totalPrice);
		obj.setTotalAmount(setTotalAmount);
		obj.setTradeDesc("商品");//交易描述
		obj.setItemName("Happy Tail商品");	
		obj.setReturnURL("http://211.23.128.214:5000");
		obj.setNeedExtraPaidInfo("N");
		obj.setStoreExpireDate("3");
		obj.setInvoiceMark("Y");
		invoice.setRelateNumber("test201217test");
		String id = String.valueOf(petMembers.getId());
		invoice.setCustomerID(id);
		invoice.setCarruerType("1");
		invoice.setTaxType("1");
		invoice.setCarruerNum("");
		invoice.setDonation("2");
		invoice.setLoveCode("X123456"); //愛心碼
		invoice.setPrint("0");
		invoice.setCustomerName(petMembers.getUsername());
		invoice.setCustomerAddr(petMembers.getAddress());
		invoice.setCustomerPhone("0912345678");
		invoice.setDelayDay("1");
		invoice.setInvType("07");
		invoice.setInvoiceItemName("Happy Tail商品");
		invoice.setInvoiceItemCount("10");
		invoice.setInvoiceItemWord("個");
		invoice.setInvoiceItemPrice("30");
		invoice.setInvoiceItemTaxType("1");
		String form = all.aioCheckOut(obj, invoice);
		return form;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
