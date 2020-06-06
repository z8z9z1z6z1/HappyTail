package com.happytail.reservation.model.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;
import com.happytail.reservation.model.Evaluation;
import com.happytail.reservation.model.backView;




@Repository
public class EvaluationDao_impl implements EvaluationDao{
	
	@Autowired
//	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public EvaluationDao_impl() {
	} 

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public Object save(Evaluation bean) {
		getSession().save(bean);
		return bean;
	}
	
	
	@Override
	public List<Evaluation> queryAllEvaluation() {
		Query<Evaluation> bean = getSession().createQuery("FROM Evaluation", Evaluation.class);
		List<Evaluation> list = bean.list();
		return list;
	}

	@Override
	public Double ScoreAvg() {
		Query query = getSession().createQuery("select AVG(score) from Evaluation");
		Double num = (Double)query.uniqueResult();
		return num;
	}

//	@Override
//	public List<backView> queryAllEvaluationView() {
//		Query<backView> bean = getSession().createQuery("from backView order by reservationId", backView.class);
//		List<backView> list = bean.list();
//		return list;
//	}

//	@Override
//	public List<backView> queryByDateEvaluationView(String createMonth) {
//		Query<backView> bean = getSession().createQuery("from backView WHERE createMonth=:createMonth", backView.class);
//		bean.setParameter("createMonth", createMonth);
//		List<backView> list = bean.list();
//		return list;
//	}
	
	private final String SelectAllBcakView = "FROM com.happytail.reservation.model.backView ORDER BY reservationId DESC";
	private final String AllBackViewCounts = "SELECT COUNT(*) FROM com.happytail.reservation.model.backView";
	
	
	@Override
	public Page<backView> getAllEvaluationlist(PageInfo pageinfo) {
		
		Integer startPosition = pageinfo.getPageSize() * (pageinfo.getPageNum() -1);
		List<backView> resultList = getSession().createQuery(SelectAllBcakView, backView.class)
				.setFirstResult(startPosition).setMaxResults(pageinfo.getPageSize()).getResultList();
		Query query = getSession().createQuery(AllBackViewCounts);
		Long totalCount = (Long)query.uniqueResult();
		return new Page<backView>(resultList,pageinfo.getPageNum(),pageinfo.getPageSize(),totalCount);
	}
	
	private final String SelectByDateEvaluationView = "FROM com.happytail.reservation.model.backView WHERE createMonth=:createMonth ORDER BY createDate ASC";
	
	@Override
	public Page<backView> queryByDateEvaluationView(String createMonth, PageInfo pageinfo) {
		
		Integer startPosition = pageinfo.getPageSize() * (pageinfo.getPageNum() -1);
		List<backView> resultList = getSession().createQuery(SelectByDateEvaluationView, backView.class)
				.setParameter("createMonth", createMonth).setFirstResult(startPosition).setMaxResults(pageinfo.getPageSize()).getResultList();
		Query query = getSession().createQuery(AllBackViewCounts);
		Long totalCount = (Long)query.uniqueResult();
	
		return new Page<backView>(resultList,pageinfo.getPageNum(),pageinfo.getPageSize(),totalCount);
	}


	

}
