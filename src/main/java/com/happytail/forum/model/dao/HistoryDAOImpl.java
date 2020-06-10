package com.happytail.forum.model.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.History;
import com.happytail.forum.model.Hit;

@Repository
public class HistoryDAOImpl implements HistoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public HistoryDAOImpl() {

	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	private final String selectTopicIdList = "SELECT topicId FROM com.happytail.forum.model.History WHERE userId=:userId";
	private final String selectByTopicIdAndUserId = "FROM com.happytail.forum.model.History WHERE topicId=:topicId AND userId=:userId";


	@Override
	public History insert(History history) {
		try {
			if (history != null) {
				getSession().save(history);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return history;
	}
	
	@Override
	public History update(History history) {
		try {
			if (history != null) {
				getSession().update(history);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return history;
	}

	@Override
	public boolean delete(Integer topicId, Integer userId) {
		
		History history = getSession().createQuery(selectByTopicIdAndUserId, History.class)
				.setParameter("topicId", topicId)
				.setParameter("userId", userId)
				.getSingleResult();
//		Query<History> query = getSession().createQuery(selectByTopicIdAndUserId, History.class);
//		query.setParameter("topicId", topicId);
//		query.setParameter("userId", userId);
//		
//		History history = query.getSingleResult();
		try {
			if (history != null) {
				getSession().delete(history);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public History select(Integer id) {
		if (id == null) {
			return null;
		}
		History history = null;
		try {
			history = getSession().get(History.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return history;
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

	@Override
	public History selectByTopicIdAndUserId(Integer topicId, Integer userId) {
		History history = null;
		
		try {

			history = getSession().createQuery(selectByTopicIdAndUserId,History.class)
				.setParameter("topicId", topicId).setParameter("userId", userId).getSingleResult();
		
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}
		return history;
	}
	
	

}
