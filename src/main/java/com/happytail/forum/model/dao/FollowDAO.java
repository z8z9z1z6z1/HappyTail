package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.Follow;
import com.happytail.forum.model.TopiclistView;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

public interface FollowDAO {
	
	public Follow insert(Follow follow);

	public boolean delete(Integer id);
	
	//update改變status或更新文章
	public Follow update(Follow follow);
	
	public Follow selectByTopicIdAndUserId(Integer topicId, Integer userId);

	public List<Integer> selectTopicIdListByUserId(Integer userId);
	
	public List<Follow> selectTopicIdListByTopicId(Integer topicId);

}
