package com.happytail.forum.model.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.ReportlistView;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

@Repository
public class ReportlistViewDAOImpl implements ReportlistViewDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public ReportlistViewDAOImpl() {
		
	}
	
	private final String selectAllReport = "FROM com.happytail.forum.model.ReportlistView ORDER BY createTime DESC";
	private final String ReportCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.ReportlistVie";
	
	@Override
	public Page<ReportlistView> getAllReplylist(PageInfo pageInfo) {
		Integer startPosition = pageInfo.getPageSize()*(pageInfo.getPageNum() - 1);
		
		List<ReportlistView> resultList = getSession()
				.createQuery(selectAllReport, ReportlistView.class)
				.setFirstResult(startPosition)
				.setMaxResults(pageInfo.getPageSize())
				.getResultList();
		
		Query query = getSession().createQuery(ReportCounts);
		Long totalcount = (Long) query.uniqueResult();
				
		return new Page<ReportlistView>(resultList,pageInfo.getPageNum(),pageInfo.getPageSize(),totalcount);
	}

	@Override
	public Long counts() {
		Long count = null;
		try {
			Query query = getSession().createQuery(ReportCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}


	
//	@Override
//	public List<ReportlistView> select() {
//		List<ReportlistView> list = null;
//		try {
//			list = getSession().createQuery(selectAllReport, ReportlistView.class).list();
//		} catch (Exception e) {
//			return null;
//		}
//		return list;
//	}

}
