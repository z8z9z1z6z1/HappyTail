package com.happytail.forum.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.forum.model.LimitPost;
import com.happytail.forum.model.dao.LimitPostDAO;

@Service
@Transactional
public class LimitPostService {
	
	@Autowired 
	private LimitPostDAO limitPostDAO;
	
	//TODO: how to show part of post?
	
	public List<LimitPost> getLimitPostList(){
		return limitPostDAO.selectAll();
	}

}
