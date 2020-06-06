package com.happytail.shopping.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happytail.shopping.model.ProductLike;
import com.happytail.shopping.model.dao.ProductLikeDao;
@Transactional
@Service
public class ProductLikeService {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	ProductLikeDao dao;
	
	public  String insert(ProductLike pLike) {
		return dao.insert(pLike);
	}
	
	public Boolean delete(ProductLike pLike) {
		return dao.delete(pLike);
	}
	
	public List<ProductLike> showLikes(Integer memberId){
		return dao.showLikes(memberId);
	}
	
	public Boolean check(Integer pId, Integer mId) {
		return dao.check(pId, mId);
	}
	
	public  ProductLike getOneLike(Integer pId, Integer mId) {
		return dao.getOneLike(pId, mId);
	}
	
}
