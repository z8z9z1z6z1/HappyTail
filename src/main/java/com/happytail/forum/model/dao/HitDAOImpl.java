package com.happytail.forum.model.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Hit;

@Repository
public class HitDAOImpl implements HitDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public HitDAOImpl() {
		
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public Hit insert(Hit hit) {
		try {
			if (hit != null) {
				getSession().save(hit);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return hit;
	}

	@Override
	public Hit update(Hit hit) {
		try {
			if (hit != null) {
				getSession().update(hit);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return hit;
	}

	@Override
	public Hit select(Integer id) {
		if(id == null) {
			return null;
		}
		Hit hit = null;
		try {
			hit = getSession().get(Hit.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return hit;
	}

}
