package com.happytail.forum.model.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Follow;
import com.happytail.forum.model.TopiclistView;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

@Repository
public class FollowDAOImpl implements FollowDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public FollowDAOImpl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	private final String selectIsFollowed =
			"FROM com.happytail.forum.model.Follow WHERE topicId=:topicId and userId=:userId"; 
	private final String selectTopicIdList =
			"SELECT topicId FROM com.happytail.forum.model.Follow WHERE userId=:userId"; 
	
	@Override
	public Follow insert(Follow follow) {
		try {
			if (follow != null) {
				getSession().save(follow);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return follow;
	}


	@Override
	public boolean delete(Integer id) {
		Follow follow = getSession().get(Follow.class, id);
		try {
			if (follow != null) {
				getSession().delete(follow);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;

	}

	@Override
	public Follow update(Follow follow) {
		try {
			if (follow != null) {
				getSession().update(follow);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return follow;
	}

	@Override
	public Follow select(Integer topicId, Integer userId) {
		Query<Follow> check = getSession().createQuery(selectIsFollowed, Follow.class);
		check.setParameter("topicId", topicId);
		check.setParameter("userId", userId);
		
		List<Follow> list = check.list();
		
		if(list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list.get(0);
	}

	@Override
	public List<Integer> selectTopicIdList(Integer userId) {
		Query<Integer> check = getSession().createQuery(selectTopicIdList,Integer.class);
		check.setParameter("userId", userId);
		
		List<Integer> list = check.list();
		
		if(list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list;
	}		
		
}
