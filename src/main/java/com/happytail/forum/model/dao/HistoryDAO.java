package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.History;

public interface HistoryDAO {

	public History insert(History history);

	public boolean delete(Integer topicId, Integer userId);

	public History select(Integer id);
	
	public List<Integer> selectTopicIdList(Integer userId);

}
