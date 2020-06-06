package com.happytail.shopping.model.dao;

import java.util.List;

import org.hibernate.Session;

import com.happytail.shopping.model.ProductLike;

public interface ProductLikeDao {

	Session s();

	String insert(ProductLike pLike);

	Boolean delete(ProductLike pLike);

	List<ProductLike> showLikes(Integer memberId);

	Boolean check(Integer pId, Integer mId);

	ProductLike getOneLike(Integer pId, Integer mId);

}