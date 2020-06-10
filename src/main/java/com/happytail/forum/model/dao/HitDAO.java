package com.happytail.forum.model.dao;

import com.happytail.forum.model.Hit;

public interface HitDAO {
	
	public Hit insert(Hit hit);
	
	public Hit update(Hit hit);
	
	public Hit select(Integer id);

	public Hit selectByTopicId(Integer topicId);


}
