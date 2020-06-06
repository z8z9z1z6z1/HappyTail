package com.happytail.forum.model.dao;

import com.happytail.forum.model.Reply;

public interface ReplyDAO {
	
	public Reply insert(Reply reply);
	
	public boolean delete(Integer id);
	
	public Reply update(Reply reply);
	
	public Reply select(Integer id);
	
	public Reply selectByTopicId(Integer topicId);


}
