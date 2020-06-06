package com.happytail.forum.model.dao;

import java.util.List;
import java.util.Map;

import com.happytail.forum.model.ReportlistView;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

public interface ReportlistViewDAO {
	
	public Page<ReportlistView> getAllReplylist(PageInfo pageInfo);
	
	public Long counts();

//	public List<ReportlistView> select();

}
