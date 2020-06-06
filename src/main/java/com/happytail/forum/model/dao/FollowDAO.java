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
	
	public Follow select(Integer topicId, Integer userId);

	public List<Integer> selectTopicIdList(Integer userId);

}
