package com.happytail.forum.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.ThumbsUpView;
@Repository
public class ThumbsUpViewDAOImpl implements ThumbsUpViewDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public ThumbsUpViewDAOImpl() {

	}

	private final String SelectByTopicId = "FROM com.happytail.forum.model.ThumbsUpView WHERE topicId=:topicId";
	private final String SelectByReplyId = "FROM com.happytail.forum.model.ThumbsUpView WHERE replyId=:replyId";
	private final String SelectByUserId = "FROM com.happytail.forum.model.ThumbsUpView WHERE userId=:userId";
	private final String SelectBriefThumbsUp = "SELECT DISTINCT FROM com.happytail.forum.model.ThumbsUpView WHERE topicId=:topicId AND type=: type";
	private final String TopicAllLikeCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.ThumbsUpView WHERE topicId=:topicId";
	private final String TopicCategoryLikeCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.ThumbsUpView WHERE topicId=:topicId and categoryId =:categoryId";
	private final String ReplyAllLikeCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.ThumbsUpView WHERE replyId=:replyId";

	@Override
	public List<ThumbsUpView> selectByTopicId(Integer topicId) {
		List<ThumbsUpView> list = null;
		try {
			list = getSession().createQuery(SelectByTopicId, ThumbsUpView.class).setParameter("topicId", topicId)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	@Override
	public List<ThumbsUpView> selectByReplyId(Integer replyId) {
		List<ThumbsUpView> list = null;
		try {
			list = getSession().createQuery(SelectByReplyId, ThumbsUpView.class)
					.setParameter("replyId", replyId)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	@Override
	public List<ThumbsUpView> selectByMemberId(Integer userId) {
		List<ThumbsUpView> list = null;
		try {
			list = getSession().createQuery(SelectByUserId, ThumbsUpView.class).setParameter("userId", userId)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
		return list;
	}
	
	@Override
	public List<String> selectBriefThumbsUp(Integer topicId, String type) {
		List<String> list = null;
		try {
			list = getSession().createQuery(SelectBriefThumbsUp, String.class)
					.setParameter("topicId", topicId)
					.setParameter("type", type)
					.setMaxResults(3)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
		return list;
	}

	@Override
	public Long topicAllCounts(Integer topicId) {
		Long count = null;
		try {
			Query query = getSession().createQuery(TopicAllLikeCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

	@Override
	public Long topicCategoryCounts(Integer categoryId) {
		Long count = null;
		try {
			Query query = getSession().createQuery(TopicCategoryLikeCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

	@Override
	public Long replyAllCounts(Integer replyId) {
		Long count = null;
		try {
			Query query = getSession().createQuery(ReplyAllLikeCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

}
