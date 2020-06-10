package com.happytail.admin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happytail.admin.model.AdminForumDao;
import com.happytail.forum.model.ReportlistView;
import com.happytail.forum.model.Topic;

@Service
public class AdminForumServiceImpl implements AdminForumService {
	
	@Autowired
	AdminForumDao forumDao;

	@Override
	public List<ReportlistView> allReportlist() {
		List<ReportlistView> list = forumDao.allReportlist();
		return list;
	}

	@Override
	public List<Topic> singleTopic(Integer id) {
		List<Topic> list = forumDao.singleTopic(id);
		return list;
	}

}
