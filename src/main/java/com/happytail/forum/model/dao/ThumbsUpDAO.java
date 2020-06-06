package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.ThumbsUp;

public interface ThumbsUpDAO {
	
	public ThumbsUp insert(ThumbsUp thumbsUp);

	public Boolean deleteTopicThumbsUp(String type, Integer userId, Integer topicId);

	public Boolean deleteReplyThumbsUp(String type, Integer userId, Integer replyId);
	
	public ThumbsUp update(ThumbsUp thumbsUp);
		
	public ThumbsUp selectByTopic(Integer topicId, Integer userId);

	public ThumbsUp selectByReply(Integer replyId, Integer userId);
	
	public List<Integer> selectTopicIdList(Integer userId);

}
