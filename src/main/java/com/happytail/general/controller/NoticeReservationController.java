 //package com.happytail.general.controller;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.happytail.general.model.Notice;
//import com.happytail.general.model.dao.NoticeDAO;
//import com.happytail.general.model.service.NoticeService;
//import com.happytail.reservation.model.ReservationBean;
//import com.happytail.reservation.model.dao.ReservationDao;
//
//@Controller
//public class NoticeReservationController {
//	
//	@Autowired
//	private NoticeDAO noticeDao;
//
//	@Autowired
//	private NoticeService noticeService;
//	
//	@Autowired
//	private ReservationDao reservationDao;
//	
//	@PostMapping("/insertReservationNotice")
//	public Map<String, String> postReservation(@ModelAttribute ReservationBean reservation){
//		
//		Map<String, String> map = new HashMap<String, String>();
//		reservationDao.save(reservation);
//		noticeService.sendReservationNotice(reservation);
//		
//		map.put("insert", "success");
//
//		return map;
//	}
//	
//	@GetMapping ("/getnotice")
//	public List<Notice> getall(){
//		List<Notice> list = noticeDao.selectAll();
//		return list;
//	}
//	
//}
