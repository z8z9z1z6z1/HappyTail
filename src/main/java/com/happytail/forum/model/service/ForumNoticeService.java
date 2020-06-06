package com.happytail.forum.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.general.model.Notice;
import com.happytail.general.model.dao.NoticeDAO;

@Service
@Transactional
public class ForumNoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	public void readNotice(Integer id) {
		
		Notice notice = noticeDAO.select(id);
		if(notice != null) {
			notice.setIsRead(true);
			noticeDAO.update(notice);
			System.out.println("Update isRead");
		}
		System.out.println("Update fail");
	}

}
