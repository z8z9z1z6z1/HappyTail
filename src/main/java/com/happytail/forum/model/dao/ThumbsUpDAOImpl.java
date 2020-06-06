package com.happytail.forum.model.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.ThumbsUp;
import com.happytail.forum.model.Topic;

@Repository
public class ThumbsUpDAOImpl implements ThumbsUpDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ThumbsUpDAOImpl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	private final String selectTopicIsThumbsUp = "FROM com.happytail.forum.model.ThumbsUp WHERE topicId=:topicId and userId=:userId";
	private final String selectReplyIsThumbsUp = "FROM com.happytail.forum.model.ThumbsUp WHERE replyId=: replyId and userId=:userId";
	private final String selectTopicIdList = "SELECT topicId FROM com.happytail.forum.model.ThumbsUp WHERE userId=:userId and type='topic'";
	private final String selectByTopicId = "FROM com.happytail.forum.model.ThumbsUp WHERE type=:type and topicId=:targetId and userId=:userId";
	private final String selectByReplyId = "FROM com.happytail.forum.model.ThumbsUp WHERE type=:type and replyId=: targetId and userId=:userId";

	@Override
	public ThumbsUp insert(ThumbsUp thumbsUp) {
		try {
			if (thumbsUp != null) {
				getSession().save(thumbsUp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return thumbsUp;
	}

	@Override
	public Boolean deleteTopicThumbsUp(String type, Integer userId, Integer topicId) {
		Query<ThumbsUp> query = getSession().createQuery(selectByTopicId, ThumbsUp.class);
		query.setParameter("type", type);
		query.setParameter("userId", userId);
		query.setParameter("targetId", topicId);

		ThumbsUp thumbsUp = query.getSingleResult();
		try {
			if (type.equals("topic")) {

				getSession().delete(thumbsUp);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;

	}

	@Override
	public Boolean deleteReplyThumbsUp(String type, Integer userId, Integer replyId) {

		Query<ThumbsUp> query = getSession().createQuery(selectByReplyId, ThumbsUp.class);
		query.setParameter("type", type);
		query.setParameter("userId", userId);
		query.setParameter("targetId", replyId);

		ThumbsUp thumbsUp = query.getSingleResult();
		try {
			if (type.equals("reply")) {

				getSession().delete(thumbsUp);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;

	}

	@Override
	public ThumbsUp update(ThumbsUp thumbsUp) {
		try {
			if (thumbsUp != null) {
				getSession().update(thumbsUp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return thumbsUp;
	}

	@Override
	public ThumbsUp selectByTopic(Integer topicId, Integer userId) {
		Query<ThumbsUp> check = getSession().createQuery(selectTopicIsThumbsUp, ThumbsUp.class);
		check.setParameter("topicId", topicId);
		check.setParameter("userId", userId);

		List<ThumbsUp> list = check.list();

		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list.get(0);
	}

	@Override
	public ThumbsUp selectByReply(Integer replyId, Integer userId) {
		Query<ThumbsUp> check = getSession().createQuery(selectReplyIsThumbsUp, ThumbsUp.class);
		check.setParameter("replyId", replyId);
		check.setParameter("userId", userId);

		List<ThumbsUp> list = check.list();

		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list.get(0);
	}

	@Override
	public List<Integer> selectTopicIdList(Integer userId) {
		Query<Integer> check = getSession().createQuery(selectTopicIdList, Integer.class);
		check.setParameter("userId", userId);

		List<Integer> list = check.list();

		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list;
	}

}
