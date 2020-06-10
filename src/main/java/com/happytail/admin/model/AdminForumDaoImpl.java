package com.happytail.admin.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.ReportlistView;
import com.happytail.forum.model.Topic;

@Repository
public class AdminForumDaoImpl implements AdminForumDao {

	@Autowired
	private SessionFactory factory;
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		return session;
	}
	
	//所有檢舉清單
	@Override
	public List<ReportlistView> allReportlist() {
		Query<ReportlistView> query = getSession().createQuery("FROM ReportlistView r where r.title is not null", ReportlistView.class);
		List<ReportlistView> list = query.list();
		return list;
	}

	@Override
	public List<Topic> singleTopic(Integer id) {
			
		Query<Topic> query = getSession().createQuery("FROM Topic t where t.id=:id", Topic.class);
		query.setParameter("id", id);
		List<Topic> list = query.getResultList();
		return list;
		
		}

}
