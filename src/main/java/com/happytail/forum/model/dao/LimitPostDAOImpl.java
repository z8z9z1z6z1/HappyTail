package com.happytail.forum.model.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.LimitPost;

@Repository
public class LimitPostDAOImpl implements LimitPostDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public LimitPostDAOImpl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	private final String SelectAllLimitPost = "FROM com.happytail.forum.model.LimitPost ORDER BY createTime DESC";


	@Override
	public LimitPost insert(LimitPost limitPost) {
		try {
			if (limitPost != null) {
				getSession().save(limitPost);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return limitPost;
	}

	@Override
	public boolean delete(Integer id) {
		LimitPost limitPost = getSession().get(LimitPost.class, id);
		try {
			if (limitPost != null) {
				getSession().delete(limitPost);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public LimitPost select(Integer id) {
		if(id == null) {
			return null;
		}
		LimitPost limitPost = null;
		try {
			limitPost = getSession().get(LimitPost.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return limitPost;
	}

	@Override
	public List<LimitPost> selectAll() {
		List<LimitPost> list = null;
		try {
			list = getSession().createQuery(SelectAllLimitPost, LimitPost.class).list();
		} catch (Exception e) {
			return null;
		}
		return list;
	}
	
	

}
