package com.happytail.forum.model.dao;

import com.happytail.forum.model.TopicImage;

public interface TopicImageDAO {

	public TopicImage insert(TopicImage topicImage);

	public boolean delete(Integer id);

	public TopicImage update(TopicImage topicImage);

	public TopicImage select(Integer topicId);

}
