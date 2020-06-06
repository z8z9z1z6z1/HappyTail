package com.happytail.forum.model.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.TopiclistView;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

@Repository
public class TopiclistViewDAOImpl implements TopiclistViewDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	public TopiclistViewDAOImpl() {

	}
	//all topic
	private final String SelectAllTopic = "FROM com.happytail.forum.model.TopiclistView ORDER BY createDate DESC";
	private final String AllTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView";
	
	//per category topic
	private final String SelectByCategoryId = "FROM com.happytail.forum.model.TopiclistView t WHERE t.categoryId = :categoryId ORDER BY t.createDate DESC";
	private final String CategoryTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView WHERE categoryId=:categoryId";

	//self topic
	private final String SelectByMemberId = "FROM com.happytail.forum.model.TopiclistView WHERE userId=:userId ORDER BY createDate DESC";
	private final String MyTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView WHERE userId=:userId";

	//self follow or thumbsUp or history topic
	private final String SelectByTopicIdList = "FROM com.happytail.forum.model.TopiclistView WHERE topicId in (:topicIdList) ORDER BY createDate DESC";
	private final String FollowOrThumbsUpTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView WHERE topicId in (:topicIdList)";

	//self favorite category topic
	private final String SelectByFavorteCategoryId = "FROM com.happytail.forum.model.TopiclistView WHERE categoryId in (:categoryIdList) ORDER BY createDate DESC";
	private final String FavorateTopicCounts = "SELECT COUNT(*) FROM com.happytail.forum.model.TopiclistView WHERE categoryId in (:categoryIdList)";

	//all hit topic
	private final String SelectHitAllTopic = "FROM com.happytail.forum.model.TopiclistView t ORDER BY t.count DESC";
	
	//per category hit topic
	private final String SelectHitTopicByCategoryId = "FROM com.happytail.forum.model.TopiclistView t WHERE t.categoryId=:categoryId ORDER BY t.count DESC";

	

	@Override
	public Page<TopiclistView> getAllTopiclist(PageInfo pageInfo) {

		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession().createQuery(SelectAllTopic, TopiclistView.class)
				.setFirstResult(startPosition).setMaxResults(pageInfo.getPageSize()).getResultList();
		Query query = getSession().createQuery(AllTopicCounts);
		Long totalCount = (Long) query.uniqueResult();
		System.out.println("totalCount="+totalCount);

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}
	
	@Override
	public Page<TopiclistView> getCategoryTopiclist(Integer categoryId, PageInfo pageInfo){
		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		System.out.println("categoryId = " + categoryId);
		System.out.println("pageInfo.getPageSize() = " + pageInfo.getPageSize());
		System.out.println("pageInfo.getPageNum() = " + pageInfo.getPageNum());
		
		List<TopiclistView> resultList = getSession().createQuery(SelectByCategoryId, TopiclistView.class)
				.setParameter("categoryId", categoryId).setFirstResult(startPosition)
				.setMaxResults(pageInfo.getPageSize()).getResultList();
		Query query = getSession().createQuery(CategoryTopicCounts);
		query.setParameter("categoryId", categoryId);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}

	@Override
	public Page<TopiclistView> getMemberIdTopiclist(Integer userId, PageInfo pageInfo) {
		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession().createQuery(SelectByMemberId, TopiclistView.class)
				.setParameter("userId", userId).setFirstResult(startPosition).setMaxResults(pageInfo.getPageSize())
				.getResultList();
		Query query = getSession().createQuery(MyTopicCounts);
		query.setParameter("userId", userId);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}

	@Override
	public Page<TopiclistView> getHitAllTopiclist(PageInfo pageInfo) {

		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession().createQuery(SelectHitAllTopic, TopiclistView.class)
				.setFirstResult(startPosition).setMaxResults(pageInfo.getPageSize()).getResultList();
		Query query = getSession().createQuery(AllTopicCounts);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}

	@Override
	public Page<TopiclistView> getHitCategoryTopiclist(Integer categoryId, PageInfo pageInfo) {

		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession().createQuery(SelectHitTopicByCategoryId , TopiclistView.class)
				.setParameter("categoryId", categoryId).setFirstResult(startPosition)
				.setMaxResults(pageInfo.getPageSize()).getResultList();
		Query query = getSession().createQuery(CategoryTopicCounts);
		query.setParameter("categoryId", categoryId);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}

	@Override
	public Page<TopiclistView> getFollowOrThumbsUpOrHistorylist(List<Integer> topicIdList, PageInfo pageInfo){
		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession().createQuery(SelectByTopicIdList , TopiclistView.class)
				.setParameterList("topicIdList", topicIdList).setFirstResult(startPosition)
				.setMaxResults(pageInfo.getPageSize()).getResultList();
		Query query = getSession().createQuery(FollowOrThumbsUpTopicCounts);
		query.setParameter("topicIdList", topicIdList);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}

	@Override
	public Page<TopiclistView> getFavorateCategoryTopiclist(List<Integer> categoryIdList, PageInfo pageInfo) {
		Integer startPosition = pageInfo.getPageSize() * (pageInfo.getPageNum() - 1);
		List<TopiclistView> resultList = getSession().createQuery(SelectByFavorteCategoryId, TopiclistView.class)
				.setParameterList("categoryIdList", categoryIdList).setFirstResult(startPosition)
				.setMaxResults(pageInfo.getPageSize()).getResultList();
		Query query = getSession().createQuery(FavorateTopicCounts);
		query.setParameterList("categoryIdList", categoryIdList);
		Long totalCount = (Long) query.uniqueResult();

		return new Page<TopiclistView>(resultList, pageInfo.getPageNum(), pageInfo.getPageSize(), totalCount);
	}

	@Override
	public Long allTopicCounts() {
		Long count = null;
		try {
			Query query = getSession().createQuery(AllTopicCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

	@Override
	public Long categoryTopicCounts(Integer categoryId) {
		Long count = null;
		try {
			Query query = getSession().createQuery(CategoryTopicCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

	@Override
	public Long myTopicCounts(Integer userId) {
		Long count = null;
		try {
			Query query = getSession().createQuery(MyTopicCounts);
			count = (Long) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
		return count;
	}

//	@Override
//	public List<TopiclistView> select() {
//		List<TopiclistView> list = null;
//		try {
//			list = getSession().createQuery(selectAllTopic, TopiclistView.class).list();
//		} catch (Exception e) {
//			return null;
//		}
//		return list;
//	}
//
//	@Override
//	public List<TopiclistView> selectByCategoryId(Integer categoryId) {
//		List<TopiclistView> list = null;
//		try {
//			list = getSession().createQuery(SelectByCategoryId, TopiclistView.class)
//					.setParameter("categoryId", categoryId).getResultList();
//		} catch (Exception e) {
//			return null;
//		}
//		return list;
//	}
//
//	@Override
//	public List<TopiclistView> selectByMemberId(Integer userId) {
//		List<TopiclistView> list = null;
//		try {
//			list = getSession().createQuery(selectByMemberId, TopiclistView.class).setParameter("userId", userId)
//					.getResultList();
//		} catch (Exception e) {
//			return null;
//		}
//		return list;
//	}

}
