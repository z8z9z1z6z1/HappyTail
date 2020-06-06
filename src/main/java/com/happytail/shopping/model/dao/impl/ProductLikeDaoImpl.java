package com.happytail.shopping.model.dao.impl;



import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.shopping.model.ProductBean;
import com.happytail.shopping.model.ProductLike;
import com.happytail.shopping.model.dao.ProductLikeDao;
import com.happytail.shopping.model.service.ProductService;

@Repository
public class ProductLikeDaoImpl implements ProductLikeDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ServletContext context;
	@Autowired
	ProductService pdao;
	
	@Override
	public Session s() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unused")
	@Override
	public String  insert ( ProductLike pLike) {
		
				s().save(pLike);
				
				return "加入成功";
		
	}

	@Override
	public Boolean delete(ProductLike pLike) {
		try {
			s().delete(pLike);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("沒有此收藏");
			return false;
		}
		return true;
	}
	
	@Override
	public List<ProductLike> showLikes(Integer memberId){
//		String newid = String.valueOf(memberId);
		String hql ="from  ProductLike where petMemberId=:memberId";
		Query<ProductLike> createQuery = s().createQuery(hql, ProductLike.class);
		createQuery.setParameter("memberId", memberId);
		return createQuery.getResultList();
	}
	@Override
	public Boolean check(Integer pId , Integer mId) {
		String hql ="from  ProductLike where petMemberId=:mId and productId=:pId";
		Query<ProductLike> createQuery=null;
		System.out.println("進入判斷");
		createQuery = s().createQuery(hql, ProductLike.class);
		createQuery.setParameter("mId", mId);
		createQuery.setParameter("pId", pId);
		int size = createQuery.getResultList().size();
		System.out.println(size);
		if(size==0) {
			return true;
		}
		return false;
	}
	@Override
	public ProductLike getOneLike(Integer pId,Integer mId) {
		String hql ="from  ProductLike where petMemberId=:mId and productId=:pId";
		 Query<ProductLike> createQuery = s().createQuery(hql, ProductLike.class);
		 createQuery.setParameter("mId", mId);
			createQuery.setParameter("pId", pId);
			try {
				ProductLike pLike=	createQuery.getSingleResult();
				System.out.println(pLike.getProductLikeId());
				return pLike;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
			
	}
	
}
