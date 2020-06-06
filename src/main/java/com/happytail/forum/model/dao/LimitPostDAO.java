package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.LimitPost;

public interface LimitPostDAO {
	
	public LimitPost insert(LimitPost limitPost);

	public boolean delete(Integer id);

	public LimitPost select(Integer id);
	
	public List<LimitPost> selectAll();

}
