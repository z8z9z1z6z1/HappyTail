package com.happytail.general.model.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.Reply;
import com.happytail.forum.model.TopiclistView;
import com.happytail.general.model.Notice;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

@Repository
public class NoticeDAO_impl implements NoticeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public NoticeDAO_impl() {

	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	private final String AllNotice = "FROM com.happytail.general.model.Notice ORDER BY createDate DESC";
	private final String SelectByUserId = "FROM com.happytail.general.model.Notice WHERE userId=: userId and isRead='N' ORDER BY createDate DESC";
	private final String SelectByModuleAndUserId = "FROM com.happytail.general.model.Notice WHERE module =: module and userId=: userId ORDER BY createDate DESC";
	private final String AllNoticeCounts = "SELECT COUNT(*) FROM com.happytail.general.model.Notice WHERE module =: module and userId=: userId and isRead='N'";

	@Override
	public Notice insert(Notice notice) {
		try {
			if (notice != null) {
				getSession().save(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert fail");
			return null;
		}

		return notice;
	}

	@Override
	public boolean delete(Integer id) {
		Notice notice = getSession().get(Notice.class, id);
		try {
			if (notice != null) {
				getSession().delete(notice);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Delete fail");
			return false;
		}
		return true;
	}

	@Override
	public Notice update(Notice notice) {
		try {
			if (notice != null) {
				getSession().update(notice);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return notice;
	}
	
	@Override
	public Notice updateAll(Notice notice) {
		try {
			if (notice != null) {
				getSession().update(notice);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Update fail");
			return null;
		}
		return notice;
	}

	@Override
	public Notice select(Integer id) {
		Notice notice = null;

		try {
			notice = getSession().get(Notice.class, id);
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}

		return notice;
	}

	@Override
	public List<Notice> selectAll() {
		List<Notice> list = null;
		try {
			list = getSession().createQuery(AllNotice, Notice.class).list();
		} catch (Exception e) {
			return null;
		}
		return list;
	}
	
	@Override
	public List<Notice> selectByUserIdList(Integer userId){
		List<Notice> list = null;
		try {
			list = getSession().createQuery(SelectByUserId, Notice.class)
					.setParameter("userId", userId)
					.getResultList();
			
		} catch (Exception e) {
			return null;
		}
		return list;
	}


	@Override
	public List<Notice> selectByModule(Integer userId, String module) {
		
		List<Notice> list = getSession()
		.createQuery(SelectByModuleAndUserId, Notice.class)
		.setParameter("module", module)
		.setParameter("userId", userId)
		.getResultList();
		
		System.out.println(module);
		System.out.println(userId);
		System.out.println(list);
		
//		Query<Notice> check = getSession().createQuery(SelectByModuleAndUserId, Notice.class);
//		check.setParameter("module", module);
//		check.setParameter("userId", userId);
//
//		List<Notice> list = check.list();
		

		return list;

	}

	@Override
	public Notice selectByUserId(Integer userId) {

		Notice notice = null;
		try {
			notice = getSession().get(Notice.class, userId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No result");
			return null;
		}
		return notice;
	}

	@Override
	public Page<Notice> getAllNoticelist(Integer userId, String module, PageInfo pageInfo) {
		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<Notice> resultList = getSession().createQuery(SelectByModuleAndUserId,Notice.class)
				.setParameter("module", module).setParameter("userId", userId)
				.setFirstResult(startPosition)
				.setMaxResults(pageInfo.getPageSize()).getResultList();
		
		Query query = getSession().createQuery(AllNoticeCounts);
		query.setParameter("module", module);
		query.setParameter("userId", userId);
		Long totalCount = (Long) query.uniqueResult();
		
		return new Page<Notice>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);

	}
	
		

}
