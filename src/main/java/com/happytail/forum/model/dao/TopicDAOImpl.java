package com.happytail.forum.model.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Topic;

@Repository
public class TopicDAOImpl implements TopicDAO {

	@Autowired
//	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	public TopicDAOImpl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public Topic insert(Topic topic) {
		try {
			if (topic != null) {
				getSession().save(topic);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return topic;
	}

	@Override
	public boolean delete(Integer id) {
		Topic topic = getSession().get(Topic.class, id);
		try {
			if (topic != null) {
				getSession().delete(topic);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public Topic update(Topic topic) {
		try {
			if (topic != null) {
				getSession().update(topic);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DAO Update fail");
			return null;
		}
		return topic;
	}

	@Override
	public Topic select(Integer id) {
		if(id == null) {
			return null;
		}
		Topic topic = null;
		try {
			topic = getSession().get(Topic.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return topic;
	}

}
