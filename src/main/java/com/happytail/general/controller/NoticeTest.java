package com.happytail.general.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happytail.forum.model.Follow;
import com.happytail.forum.model.Reply;
import com.happytail.forum.model.ThumbsUp;
import com.happytail.forum.model.dao.FollowDAO;
import com.happytail.forum.model.dao.ReplyDAO;
import com.happytail.forum.model.dao.ThumbsUpDAO;
import com.happytail.general.model.Notice;
import com.happytail.general.model.dao.NoticeDAO;
import com.happytail.general.model.service.NoticeService;
import com.happytail.general.util.Const.ThumbsUpType;
import com.happytail.reservation.model.ReservationBean;
import com.happytail.reservation.model.dao.ReservationDao;

@RestController
//@RequestMapping("/happytail")
public class NoticeTest {

	@Autowired
	private NoticeDAO noticeDao;

	@Autowired
	private NoticeService noticeService;

	@Autowired
	private ReplyDAO replyDAO;

	@Autowired
	private ThumbsUpDAO thumbsUpDAO;
	
	@Autowired
	private FollowDAO followDAO;
	
	@Autowired
	private ReservationDao reservationDao;

	@PostMapping("/insertnotice")
	public Map<String, String> post(@ModelAttribute Notice notice) {

		Map<String, String> map = new HashMap<String, String>();

		noticeDao.insert(notice);

		map.put("insert", "success");
		return map;
	}

	@GetMapping("/getnotice")
	public List<Notice> getall() {
		List<Notice> list = noticeDao.selectAll();
		return list;

	}

	@PostMapping("/insertreply")
	public Map<String, String> postReply(@ModelAttribute Reply reply) {
		System.out.println(reply);
		System.out.println(reply.getAtUserIdList().get(0));
		Map<String, String> map = new HashMap<String, String>();
		replyDAO.insert(reply);

		for (Integer userId : reply.getAtUserIdList()) {
			noticeService.sendAtReplyNotice(reply, userId);
		}

		noticeService.sendReplyTopicNotice(reply);

		map.put("insert", "success");
		return map;
	}

	@PostMapping("/insertthumbsup")
	public Map<String, String> postThumbsUp(@ModelAttribute ThumbsUp thumbsUp) {

		Map<String, String> map = new HashMap<String, String>();
		thumbsUpDAO.insert(thumbsUp);
		
		if (ThumbsUpType.topic.equals(thumbsUp.getType())) {
			System.out.println(thumbsUp);
			noticeService.sendLikeTopicNotice(thumbsUp);
		}else if(ThumbsUpType.reply.equals(thumbsUp.getType())){
			System.out.println(thumbsUp);
			noticeService.sendLikeReplyNotice(thumbsUp);
		}else {
			System.out.println("no this type result");
		}

		map.put("insert", "success");
		return map;
	}
	
	@PostMapping("/updatetopic")
	public Map<String, String> updateTopic(@ModelAttribute Follow follow) {
		Map<String, String> map = new HashMap<String, String>();
		followDAO.insert(follow);
		
		noticeService.sendUpdateTopicNotice(follow);
		
		map.put("insert", "success");
		return map;
	}
	
	@PostMapping("/insertReservationNotice")
	public Map<String, String> postReservation(@ModelAttribute ReservationBean reservation){
		
		Map<String, String> map = new HashMap<String, String>();
		reservationDao.save(reservation);
		noticeService.sendReservationNotice(reservation);
		
		map.put("insert", "success");

		return map;
	}
	
	
}
