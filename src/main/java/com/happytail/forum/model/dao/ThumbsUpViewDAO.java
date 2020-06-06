package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.ThumbsUpView;


public interface ThumbsUpViewDAO {
	
	public List<ThumbsUpView> selectByTopicId(Integer topicId);

	public List<String> selectBriefThumbsUp(Integer topicId, String type);
	
	public List<ThumbsUpView> selectByReplyId(Integer replyId);

	public List<ThumbsUpView> selectByMemberId(Integer userId);
	
	public Long topicAllCounts(Integer topicId);
	
	public Long topicCategoryCounts(Integer categoryId);
	
	public Long replyAllCounts(Integer replyId);


}
