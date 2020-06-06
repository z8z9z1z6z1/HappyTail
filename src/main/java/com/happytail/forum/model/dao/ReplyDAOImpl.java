package com.happytail.forum.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Reply;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public Reply insert(Reply reply) {
		try {
			if (reply != null) {
				getSession().save(reply);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}
		return reply;
	}

	@Override
	public boolean delete(Integer id) {
		try {
			if (id != null) {
				getSession().delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public Reply update(Reply reply) {
		try {
			if (reply != null) {
				getSession().update(reply);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return reply;
	}

	@Override
	public Reply select(Integer id) {
		Reply reply = null;
		try {
			reply = getSession().get(Reply.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}
		return reply;
	}

	@Override
	public Reply selectByTopicId(Integer topicId) {
		Reply reply = null;
		try {
			reply = getSession().get(Reply.class, topicId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}
		return reply;
	}

}
