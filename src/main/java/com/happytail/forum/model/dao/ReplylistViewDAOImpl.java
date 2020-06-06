package com.happytail.forum.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.ReplylistView;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

@Repository
public class ReplylistViewDAOImpl implements ReplylistViewDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public ReplylistViewDAOImpl() {

	}
	
	private final String selectAllReply =
			"FROM com.happytail.forum.model.ReplylistView r WHERE r.topicId=:topicId";
	
	private final String AllReplyCounts = 
			"SELECT COUNT(*) FROM com.happytail.forum.model.ReplylistView r WHERE r.topicId=:topicId";
	

	@Override
	public Page<ReplylistView> getAllReplylist(Integer topicId, PageInfo pageInfo) {
		Integer startPosition = pageInfo.getPageSize()*(pageInfo.getPageNum() - 1);
		List<ReplylistView> resultlist = getSession()
				.createQuery(selectAllReply, ReplylistView.class)
				.setParameter("topicId", topicId)
				.setFirstResult(startPosition)
				.setMaxResults(pageInfo.getPageSize())
				.getResultList();
		
		Query query = getSession().createQuery(AllReplyCounts);
		query.setParameter("topicId", topicId);
		Long totalCount = (Long) query.uniqueResult();
		
		return new Page<ReplylistView>(resultlist, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}
	
	@Override
	public long AllReplyCounts(Integer topicId) {
		Query query = getSession().createQuery(AllReplyCounts);
		query.setParameter("topicId", topicId);
		long count = (long)query.uniqueResult();
		return count;
	}

	
//	@Override
//	public List<ReplylistView> select(int topicId) {
//		Query<ReplylistView> query = getSession().createQuery(selectAllReply, ReplylistView.class);
//		query.setParameter("topicId", topicId);
//		List<ReplylistView> list = query.list();
//		return list;
//	}

}
