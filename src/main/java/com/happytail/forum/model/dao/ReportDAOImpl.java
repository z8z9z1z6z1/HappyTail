package com.happytail.forum.model.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Report;
import com.happytail.forum.model.Topic;

@Repository
public class ReportDAOImpl implements ReportDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ReportDAOImpl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	private final String selectIsReported = "FROM com.happytail.forum.model.Report WHERE topicId=:topicId and userId=:userId";

	@Override
	public Report insert(Report report) {
		try {
			if (report != null) {
				getSession().save(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return report;
	}

	@Override
	public Report update(Report report) {
		try {
			if (report != null) {
				getSession().update(report);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return report;
	}

	@Override
	public Report select(Integer topicId, Integer userId) {
		Query<Report> check = getSession().createQuery(selectIsReported, Report.class);
		check.setParameter("topicId", topicId);
		check.setParameter("userId", userId);

		List<Report> list = check.list();

		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		}

		return list.get(0);
	}

	@Override
	public Boolean delete(Integer id) {
		Report report = getSession().get(Report.class, id);
		try {
			if (report != null) {
				getSession().delete(report);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

}
