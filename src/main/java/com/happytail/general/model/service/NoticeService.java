package com.happytail.general.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.forum.model.Follow;
import com.happytail.forum.model.Reply;
import com.happytail.forum.model.ThumbsUp;
import com.happytail.forum.model.Topic;
import com.happytail.forum.model.dao.TopicDAO;
import com.happytail.general.model.CodeMap;
import com.happytail.general.model.Notice;
import com.happytail.general.model.dao.CodeMapDAO;
import com.happytail.general.model.dao.NoticeDAO;
import com.happytail.general.util.Const;
import com.happytail.general.util.Const.Admin;
import com.happytail.general.util.Const.NoticeType;
import com.happytail.general.util.NoticeUtil;
import com.happytail.member.model.PetMembers;
import com.happytail.member.model.dao.PetMembersDAO;
import com.happytail.reservation.model.ReservationBean;
import com.happytail.reservation.model.dao.ReservationDao;

@Service
@Transactional
public class NoticeService {

	@Autowired
	private TopicDAO topicDAO;

	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private PetMembersDAO petMembersDAO;

	@Autowired
	private CodeMapDAO codeMapDAO;
	
	@Autowired
	private ReservationDao reservationDao;
	
//	@Resource(name="brokerMessagingTemplate")
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	public void sendReservationNotice(ReservationBean bean) {
		
		ReservationBean reservationBean = reservationDao.select(bean.getReservationId());
		if (reservationBean != null) {
			String statuss = reservationBean.getStatuss();
			String reservationUsername = bean.getUsername();
			String template = NoticeUtil.getNoticeTemplate(NoticeType.ReceiveReservation);
			String module = Const.ModuleType.Reservation;
			String noticeMsg = String.format(template, reservationUsername, statuss);
			
			Notice notice = new Notice();
			String sadminUserId= NoticeUtil.getNoticeTemplate(Const.Admin.AdminUserId);
			Integer adminUserId =  Integer.parseInt(sadminUserId);
			notice.setId(adminUserId);
			notice.setUsername(NoticeUtil.getNoticeTemplate(Const.Admin.AdminUserName));
			notice.setModule(module);
			notice.setMessage(noticeMsg);
			saveNotice(notice);
			sendNotice(notice);
		} else {
			System.out.println("cannot find the topicId: " + bean.getReservationId());
		}
			
	}

	
	public void sendReplyTopicNotice(Reply reply) {
		// "replyusername 回覆了你的文章 title"
		
		Topic topic = topicDAO.select(reply.getTopicId());
		if (topic != null) {
			String title = topic.getTitle();
			String replyUsername = reply.getUsername();
			String template = NoticeUtil.getNoticeTemplate(NoticeType.ReceiveReply);
			String module = Const.ModuleType.Forum;
			String noticeMsg = String.format(template, replyUsername, title);
			String link = "/forum/topicPage/" + reply.getTopicId();

			Notice notice = new Notice();
			notice.setUserId(topic.getUserId());
			notice.setUsername(topic.getUsername());
			notice.setModule(module);
			notice.setMessage(noticeMsg);
			notice.setLink(link);
			saveNotice(notice);
			sendNotice(notice);
		} else {
			System.out.println("cannot find the topicId: " + reply.getTopicId());
		}
	}

	public void sendAtReplyNotice(Reply reply, Integer userId) {
		//"replyusername 在回覆中提及了你"

		PetMembers petmembers = petMembersDAO.selectPetMembers(userId);
		if (petmembers != null) {
			String username = petmembers.getUsername();
			String module = Const.ModuleType.Forum;
			String replyUsername = reply.getUsername();
			String template = NoticeUtil.getNoticeTemplate(NoticeType.AtReply);
			String noticeMsg = String.format(template, replyUsername);
			String link = "/forum/topicPage/" + reply.getTopicId();

			Notice notice = new Notice();
			notice.setUserId(userId);
			notice.setUsername(username);
			notice.setModule(module);
			notice.setMessage(noticeMsg);
			notice.setLink(link);
			saveNotice(notice);
			sendNotice(notice);
		} else {
			System.out.println("cannot find the userId: " + userId);
		}
	}

	public void sendLikeTopicNotice(ThumbsUp thumbsUp) {
		//"thumbsUpusername 對你的文章title 按了value 表示心情"
		
		Topic topic = topicDAO.select(thumbsUp.getTopicId());
			if (topic != null) {
				String title = topic.getTitle();
				Integer userId = topic.getUserId();
				String username = topic.getUsername();
			
				String module = Const.ModuleType.Forum;
				String type = Const.CategoryType.likeCategory;
				String thumbsUpUsername = thumbsUp.getUsername();
				String key = String.valueOf(thumbsUp.getCategoryId());

				CodeMap codeMap = codeMapDAO.selectValue(module, type, key);
			if (codeMap != null) {
				String value = codeMap.getValue();

				String template = NoticeUtil.getNoticeTemplate(NoticeType.LikeTopic);
				String noticeMsg = String.format(template, thumbsUpUsername, title, value);
				String link = "/forum/topicPage/" + thumbsUp.getTopicId();

				Notice notice = new Notice();
				notice.setUserId(userId);
				notice.setUsername(username);
				notice.setModule(module);
				notice.setMessage(noticeMsg);
				notice.setLink(link);
				saveNotice(notice);
				sendNotice(notice);

			} else {
				System.out.println("cannot find the CategoryId: " + thumbsUp.getCategoryId());
			}
		} else {
			System.out.println("cannot find the TopicId: " + thumbsUp.getTopicId());
		}
	}

	public void sendLikeReplyNotice(ThumbsUp thumbsUp) {
		//"thumbsUpusername 對你的回覆按了讚"
		
		Topic topic = topicDAO.select(thumbsUp.getTopicId());
		if (topic != null) {
			Integer userId = topic.getUserId();
			String username = topic.getUsername();
			
			String module = Const.ModuleType.Forum;
			String thumbsUpUsername = thumbsUp.getUsername();

			String template = NoticeUtil.getNoticeTemplate(NoticeType.LikeReply);
			String noticeMsg = String.format(template, thumbsUpUsername);
			String link = "/forum/topicPage/" + thumbsUp.getTopicId();

			Notice notice = new Notice();
			notice.setUserId(userId);
			notice.setUsername(username);
			notice.setModule(module);
			notice.setMessage(noticeMsg);
			notice.setLink(link);
			saveNotice(notice);
			sendNotice(notice);

		} else {
			System.out.println("cannot find the TopicId: " + thumbsUp.getTopicId());
		}
	}
	
	public void sendUpdateTopicNotice(Follow  follow) {
		//"追蹤的文章 title 更新了，快去看看吧！"
		
		Topic topic = topicDAO.select(follow.getTopicId());
		if (topic != null) {
			String title = topic.getTitle();
			Integer userId = follow.getUserId();
			String username = follow.getUsername();
			
			String module = Const.ModuleType.Forum;
			String template = NoticeUtil.getNoticeTemplate(NoticeType.UpdateTopic);
			String noticeMsg = String.format(template, title);
			String link = "/forum/topicPage/" + topic.getId();
			
			Notice notice = new Notice();
			notice.setUserId(userId);
			notice.setUsername(username);
			notice.setModule(module);
			notice.setMessage(noticeMsg);
			notice.setLink(link);
			saveNotice(notice);
			sendNotice(notice);
			
		}else {
			System.out.println("cannot find the topicId: " + follow.getTopicId());
		}
		
		
	}
	

	private void saveNotice(Notice notice) {
		noticeDAO.insert(notice);
	}

	private void sendNotice(Notice notice) {
		System.out.println("send notice success: " + notice.getMessage());
		simpMessagingTemplate.convertAndSendToUser(String.valueOf(notice.getUserId()), "/queue/messages", notice);
	}

}
