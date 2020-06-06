package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.TopiclistView;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

public interface TopiclistViewDAO {

	//all topic
	public Page<TopiclistView> getAllTopiclist(PageInfo pageInfo);

	//per category topic
	public Page<TopiclistView> getCategoryTopiclist(Integer categoryId, PageInfo pageInfo);

	//self topic
	public Page<TopiclistView> getMemberIdTopiclist(Integer userId, PageInfo pageInfo);

	//self follow or thumbsUp topic
	public Page<TopiclistView> getFollowOrThumbsUpOrHistorylist(List<Integer> topicIdList, PageInfo pageInfo);
	
	//self favorate category topic
	public Page<TopiclistView> getFavorateCategoryTopiclist(List<Integer> categoryIdList, PageInfo pageInfo);

	//all hit topic
	public Page<TopiclistView> getHitAllTopiclist(PageInfo pageInfo);
	
	//per category hit topic
	public Page<TopiclistView> getHitCategoryTopiclist(Integer categoryId, PageInfo pageInfo);

	public Long allTopicCounts();

	public Long categoryTopicCounts(Integer categoryId);

	public Long myTopicCounts(Integer userId);

//	public List<TopiclistView> select();

//	public List<TopiclistView> selectByCategoryId();

//	public List<TopiclistView> selectByMemberId(Integer userId);
	
//	public PageInfo getPageInfo(Map<String, Object> paramMap);

}
