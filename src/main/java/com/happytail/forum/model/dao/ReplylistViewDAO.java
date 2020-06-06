package com.happytail.forum.model.dao;

import java.util.List;
import java.util.Map;

import com.happytail.forum.model.ReplylistView;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;


public interface ReplylistViewDAO {
	
	public Page<ReplylistView> getAllReplylist(Integer topicId, PageInfo pageInfo);

	public long AllReplyCounts(Integer topicId);

//	public List<ReplylistView> select(int topicId);

}
