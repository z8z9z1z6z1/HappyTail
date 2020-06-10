package com.happytail.reservation.controller;


import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.happytail.forum.model.Topic;
import com.happytail.general.model.Notice;
import com.happytail.general.model.dao.NoticeDAO_impl;
import com.happytail.general.util.Const;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.member.model.PetMembers;
import com.happytail.reservation.model.Evaluation;
import com.happytail.reservation.model.backView;
import com.happytail.reservation.model.service.EvaluationService;
import com.sun.mail.handlers.message_rfc822;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;






@Controller
@SessionAttributes(value = {"Evaluation"})
public class EvaluationController {
	
	@Autowired
	private EvaluationService service;
	@Autowired
	private EvaluationService service2;
	@Autowired
	private NoticeDAO_impl notice;
	
	@PostMapping("/saveEvaluation")
	public String save(@SessionAttribute("petMembers") PetMembers petMembers,
			@RequestParam("reservationId")Integer reservationId,
			@RequestParam("score")Double score,
			@RequestParam("content")String content,Model m) {
		
		Evaluation en = new Evaluation();
		
		en.setReservationId(reservationId);
		en.setScore(score);
		en.setContent(content);
		en.setId(petMembers.getId());
		en.setUsername(petMembers.getUsername());
		
		service.save(en);
		
		List<Evaluation> list = service2.queryAllEvaluation();
		m.addAttribute("Evaluation" , list);
		
		List<Evaluation> list2 = service.queryMyEvaluation(petMembers.getId());
		
		m.addAttribute("Evaluation2" , list2);
		
		double num = service2.ScoreAvg();
		DecimalFormat df = new DecimalFormat("#.0");
		String avg = df.format(num);
		m.addAttribute("scoreAvg" , avg);
		
		System.out.println(avg);
		
		return "reservationPage";
	}
	
	
	
	@RequestMapping(value = "/Evaluationlist", method = RequestMethod.GET)
	public String Evaluationlist(@SessionAttribute("petMembers") PetMembers petMembers,
			Model m)  {
		
		
		List<Evaluation> list = service.queryAllEvaluation();
		m.addAttribute("Evaluation" , list);
		
		List<Evaluation> list2 = service.queryMyEvaluation(petMembers.getId());
		
		m.addAttribute("Evaluation2" , list2);
		
		
		double num = service.ScoreAvg();
		DecimalFormat df = new DecimalFormat("#.0");
		String avg = df.format(num);
		m.addAttribute("scoreAvg" , avg);
		
		System.out.println(avg);
		return "reservationPage";
	}
	
//	@PostMapping("/queryByDate")
//	public String queryByDateEvaluationView(@RequestParam("createMonth")String createMonth,Model m) {
//		List<backView> list = service.queryByDateEvaluationView(createMonth);
//		m.addAttribute("backView",list);
//		
//		return "backReservationPage";
//	}
	
	@GetMapping("/pageBackView")
	public String queryByPageBackView(Integer pageSize,
			String AdminUserId,String AdminUserName,
			@RequestParam Integer pageNum,Model m) {
		PageInfo pageinfo = new PageInfo(Const.DEFAULT_PAGE_SIZE, pageNum);
		System.out.println(pageinfo.getPageSize());
		System.out.println(pageinfo.getPageNum());
		Page<backView> list = service.getAllEvaluationlist(pageinfo);
		
		String sadminUserId= Const.Admin.AdminUserId;
		Integer adminUserId =  Integer.parseInt(sadminUserId);
		
		List<Notice> selectByModule = notice.selectByModule(adminUserId,Const.ModuleType.Reservation);
		
		m.addAttribute("notice",selectByModule);
		
		m.addAttribute("page",list);
		
		return "backReservationPage";
	}

		
	
	
	@GetMapping("/queryByPageBackView")
	public String queryByPageBackView(@RequestParam("createMonth")String createMonth,
			Integer pageSize,@RequestParam Integer pageNum,Model m) {
		
		PageInfo pageinfo = new PageInfo(Const.DEFAULT_PAGE_SIZE, pageNum);
		System.out.println(pageinfo.getPageSize());
		System.out.println(pageinfo.getPageNum());
		Page<backView> list = service.queryByDateEvaluationView(createMonth,pageinfo);
		
		m.addAttribute("page",list);
		
		return "backReservationPage";
	}
	
	@PostMapping("updateEvaluation")
	public String updateEvaluation(@RequestParam("evaluationId")Integer evaluationId,
			@RequestParam("score")Double score,@RequestParam("content")String content,
			@SessionAttribute("petMembers") PetMembers petMembers,Model m) {
		
		Evaluation et = new Evaluation();
		et.setEvaluationId(evaluationId);
		et.setScore(score);
		et.setContent(content);

		service.updateEvaluation(et);
		
		List<Evaluation> list = service.queryAllEvaluation();
		m.addAttribute("Evaluation" , list);
		
		List<Evaluation> list2 = service.queryMyEvaluation(petMembers.getId());
		
		m.addAttribute("Evaluation2" , list2);
		
		
		double num = service.ScoreAvg();
		DecimalFormat df = new DecimalFormat("#.0");
		String avg = df.format(num);
		m.addAttribute("scoreAvg" , avg);
		
		
		return "reservationPage";
	}
	
	@PostMapping("queryByEvaluationId")
	public String queryByEvaluationId(@RequestParam("evaluationId")Integer evaluationId,
			Model m) {
		
		Evaluation et = service.queryByEvaluationId(evaluationId);
		m.addAttribute("queryByEvaluationId",et);
		
		return "updateEvaluationPage";
		
	}
	
	@PostMapping("deleteByEvaluationId")
	public String deleteByEvaluationId(@RequestParam("evaluationId")Integer evaluationId
			,@SessionAttribute("petMembers") PetMembers petMembers,Model m) {
		
		service.deleteByEvaluationId(evaluationId);
		
		List<Evaluation> list = service.queryAllEvaluation();
		m.addAttribute("Evaluation" , list);
		
		List<Evaluation> list2 = service.queryMyEvaluation(petMembers.getId());
		
		m.addAttribute("Evaluation2" , list2);
		
		double num = service.ScoreAvg();
		DecimalFormat df = new DecimalFormat("#.0");
		String avg = df.format(num);
		m.addAttribute("scoreAvg" , avg);
		
		return "reservationPage";
		
	}
	
}
