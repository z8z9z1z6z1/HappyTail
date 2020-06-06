package com.happytail.forum.model.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.TopicImage;

@Repository
public class TopicImageDAOImpl implements TopicImageDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public TopicImageDAOImpl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public TopicImage insert(TopicImage topicImage) {
		try {
			if (topicImage != null) {
				getSession().save(topicImage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return topicImage;
	}

	@Override
	public boolean delete(Integer id) {
		TopicImage topicImage = getSession().get(TopicImage.class, id);
		try {
			if (topicImage != null) {
				getSession().delete(topicImage);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public TopicImage update(TopicImage topicImage) {
		try {
			if (topicImage != null) {
				getSession().update(topicImage);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return topicImage;
	}

	@Override
	public TopicImage select(Integer topicId) {
		if(topicId == null) {
			return null;
		}
		TopicImage topicImage = null;
		try {
			topicImage = getSession().get(TopicImage.class, topicId);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return topicImage;
	}

}
