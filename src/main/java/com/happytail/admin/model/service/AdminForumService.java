package com.happytail.admin.model.service;

import java.util.List;

import com.happytail.forum.model.ReportlistView;
import com.happytail.forum.model.Topic;

public interface AdminForumService {

	// 所有檢舉文章
	public List<ReportlistView> allReportlist();
	//單一文章
	public List<Topic> singleTopic(Integer id);

}
