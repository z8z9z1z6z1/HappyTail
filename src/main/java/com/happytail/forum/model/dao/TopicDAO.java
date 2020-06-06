package com.happytail.forum.model.dao;

import com.happytail.forum.model.Topic;

public interface TopicDAO {
	
	public Topic insert(Topic topic);
	
	public boolean delete(Integer id);
	
	public Topic update(Topic topic);
	
	public Topic select(Integer id);
}
