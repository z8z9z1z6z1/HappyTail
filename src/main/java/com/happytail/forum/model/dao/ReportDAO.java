package com.happytail.forum.model.dao;

import com.happytail.forum.model.Report;

public interface ReportDAO {
	
	public Report insert(Report report);
	
	public Report update(Report report);
	
	public Report select(Integer topicId, Integer userId);
	
	public Boolean delete (Integer id);
	
}
