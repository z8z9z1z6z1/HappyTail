package com.happytail.reservation.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.happytail.general.model.service.NoticeService;
import com.happytail.general.util.Const;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.member.model.PetMembers;
import com.happytail.reservation.model.Evaluation;
import com.happytail.reservation.model.MyReservationView;
import com.happytail.reservation.model.ReservationBean;

import com.happytail.reservation.model.service.EvaluationService;
import com.happytail.reservation.model.service.ReservationService;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;





@Controller
@SessionAttributes(value = {"reservationBean"})
public class ReservationController {
	
	@Autowired
	private ReservationService service;
	
	@Autowired
	private EvaluationService service2;
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/index37")
	public String transferReservationPage() {
		return "reservation/index37";
	}
	
	@ResponseBody
	@PostMapping("/insertSuccess")
	public String insert(@SessionAttribute("petMembers") PetMembers petMembers,
			@RequestParam("sortId")Integer sortId, @RequestParam("breed")String breed,
			@RequestParam("petName")String petName, @RequestParam("petGenger")String petGenger,
			@RequestParam("petAge") Integer petAge, @RequestParam("createDate")Date createDate,
			@RequestParam("availableDateTime")Integer availableDateTime, @RequestParam("require")String require,
			@RequestParam("statuss")String statuss,@RequestParam("done")String done,
			@RequestParam("evaluationStatus")String evaluationStatus, Model m
			) throws ParseException, ServletException, IOException {
		
		ReservationBean rb = new ReservationBean();
		rb.setSortId(sortId);
		rb.setBreed(breed);
		rb.setPetName(petName);
		rb.setPetGenger(petGenger);
		rb.setPetAge(petAge);
		rb.setCreateDate(createDate);
		rb.setAvailableDateTime(availableDateTime);
		rb.setRequire(require);
		rb.setStatuss(statuss);
		rb.setEvaluationStatus(evaluationStatus);
		rb.setDone(done);
		rb.setId(petMembers.getId());
		rb.setEmail(petMembers.getEmail());
		rb.setUsername(petMembers.getUsername());
		 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		String dateString = sdf.format(createDate);
		rb.setCreateMonth(dateString);
		
		service.save(rb);
		
		noticeService.sendReservationNotice(rb);
		
		List<Evaluation> list = service2.queryAllEvaluation();
		m.addAttribute("Evaluation" , list);
		
		double num = service2.ScoreAvg();
		DecimalFormat df = new DecimalFormat("#.0");
		String avg = df.format(num);
		m.addAttribute("scoreAvg" , avg);
		
		System.out.println(avg);
		
		AllInOne all = new AllInOne("");
		AioCheckOutALL obj = new AioCheckOutALL();
		
		UUID uid = UUID.randomUUID();
		obj.setMerchantTradeNo(uid.toString().replaceAll("-", "").substring(0, 20));
		
		DateFormat  day = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String strBeginDate =day.format(new Date(availableDateTime));
		obj.setMerchantTradeDate(strBeginDate); 
		
		obj.setTotalAmount("700");
		obj.setTradeDesc("test Description");
		obj.setItemName("寵物SPA");
		obj.setReturnURL("http://localhost:8080/happytail/HappyTailIndex.jsp");
		obj.setClientBackURL("http://localhost:8080/happytail/HappyTailIndex.jsp");
		obj.setNeedExtraPaidInfo("N");
		obj.setPeriodAmount("700");
		obj.setPeriodType("D");
		obj.setFrequency("1");
		obj.setExecTimes("12");
		String form = all.aioCheckOut(obj, null);
		
		
		return form ;
	}	
		
		
		
//		return "redirect:/Evaluationlist";
	
	
//	@RequestMapping(value = "/query", method = RequestMethod.GET)
//	public String MyReservationlist(@SessionAttribute("petMembers") PetMembers petMembers,
//				Model m) {
//	
//		Integer Id = petMembers.getId();
//		List<MyReservationView> list = service.query(Id);
//		m.addAttribute("myReservation",list);
//	
//		return "reservation/myReservation";
//	}
	
//	@RequestMapping(value = "/queryback", method = RequestMethod.GET)
//	public String queryAllView(Model m) {
//	
//
//		List<backView> list = service2.queryAllEvaluationView();
//		m.addAttribute("backView",list);
//		
//		return "backReservationPage";
//	}
	
	
	
	@PostMapping("/update")
	public String update(@SessionAttribute("petMembers") PetMembers petMembers,
			@RequestParam("reservationId")Integer reservationId,
			@RequestParam("statuss")String statuss,@RequestParam("Id")Integer Id,
			Integer pageSize,@RequestParam Integer pageNum, Model m) {
		
		ReservationBean rb = new ReservationBean();
		rb.setReservationId(reservationId);
		rb.setStatuss(statuss);
		rb.setUsername(petMembers.getUsername());
		System.out.println(reservationId);
		System.out.println(statuss);
		
		service.updateStatuss(rb);
		
		PageInfo pageinfo = new PageInfo(Const.DEFAULT_PAGE_SIZE, pageNum);
		System.out.println(pageinfo.getPageSize());
		System.out.println(pageinfo.getPageNum());
		Page<MyReservationView> list = service.query(Id,pageinfo);

		m.addAttribute("page",list);
		
		noticeService.sendReservationNotice(rb);
		
		
		return "myReservationPage";
	}
	
	
	@PostMapping("/updateEvaluationStatus")
	public String UpdateEvaluationStatus(@RequestParam("reservationId")Integer reservationId,
			@RequestParam("evaluationStatus")String evaluationStatus, Model m) {
		
		ReservationBean rb = new ReservationBean();
		rb.setReservationId(reservationId);
		rb.setEvaluationStatus(evaluationStatus);
		System.out.println(reservationId);
		System.out.println(evaluationStatus);
		
		service.updateEvaluationStatus(rb);
		
		ReservationBean bean = service.queryReservationBean(reservationId);
		
		m.addAttribute("reservation", bean);

		return "evaluationPage";
		
		
	}
	
	
//	@GetMapping("/queryReservation/{reservationId}")
//	public String showReservationBean(@PathVariable("reservationId") Integer reservationId ,Model m) {
//		System.out.println("reservationId=" + reservationId);
//		ReservationBean bean = service.queryReservationBean(reservationId);
//		
//		m.addAttribute("reservation", bean);
//
//		return "evaluationPage";
//		
//	}
	
	@GetMapping("/queryMyReservaitionView")
	public String queryMyReservaitionView(@RequestParam("Id")Integer Id,
			Integer pageSize,@RequestParam Integer pageNum,Model m) {
		
		PageInfo pageinfo = new PageInfo(Const.DEFAULT_PAGE_SIZE, pageNum);
		System.out.println(pageinfo.getPageSize());
		System.out.println(pageinfo.getPageNum());
		Page<MyReservationView> list = service.query(Id,pageinfo);
		
		m.addAttribute("page",list);
		
		
		return "myReservationPage";
	}
	
}
